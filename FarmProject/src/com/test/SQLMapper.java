package com.test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

public class SQLMapper {

	private Map beanMap;
	private String className;
	private Class clazz;
	private String sql = "";
	private List<Object> param;

	public SQLMapper() {
	}

	public SQLMapper(Object resource) {
		this.clazz = resource.getClass();
		this.className = clazz.getName().replace(clazz.getPackage().getName() + ".", "");
		this.beanMap = descriptionMapper(resource);
	}

	public Map descriptionMapper(Object resource) {
		Map map = null;
		if (resource != null) {
			try {
				map = BeanUtils.describe(resource);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public void generateSelectSqlByBean(Object resource) {
		StringBuffer columnBuffer = new StringBuffer();
		StringBuffer valuesBuffer = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		Map<String, Object> map =descriptionMapper(resource);
		this.setBeanMap(map);
		
		columnBuffer.append("SELECT ");
		valuesBuffer.append(" WHERE 1=1 ");

		if (MapUtils.isNotEmpty(map)) {
			map.remove("class");
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = toBaselineColumn(entry.getKey());
				Object value = entry.getValue();
				if (value != null && StringUtils.isNotEmpty(value.toString())) {					
					columnBuffer.append(key + ",");
					valuesBuffer.append(" and "+key+"=? ");
					param.add(value);				
				}
			}
		}
		
		columnBuffer.append(" FROM ");
		columnBuffer.append(tableBaseLine(resource));
		int index =columnBuffer.lastIndexOf(",");
		columnBuffer=columnBuffer.replace(index, index+1, "");
		
		this.setSql(columnBuffer.toString()+valuesBuffer.toString());
		this.setParam(param);
	}

	/**
	 * Insert SQL
	 */
	public void generateInsertSqlByBean() {
		StringBuffer columnBuffer = new StringBuffer();
		StringBuffer valuesBuffer = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		columnBuffer.append("INSERT INTO ");
		columnBuffer.append(toBaselineColumn(this.getClassName()) + " (");

		valuesBuffer.append(" VALUES( ");
		
		Map<String, Object> map =this.getBeanMap();
		if (MapUtils.isNotEmpty(map)) {
			map.remove("class");
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = toBaselineColumn(entry.getKey());
				Object value = entry.getValue();
				if (value != null && StringUtils.isNotEmpty(value.toString())) {
					columnBuffer.append(key + ",");
					valuesBuffer.append("?,");
					param.add(value);
				}
			}

			String columnSql = columnBuffer.substring(0, columnBuffer.length() - 1) + ")";
			String valuesSql = valuesBuffer.substring(0, valuesBuffer.length() - 1) + ")";
			this.setSql(columnSql + valuesSql);
			this.setParam(param);
		}
	}

	/**
	 * EX:TAOrg -->T_A_ORG
	 * table Name 
	 * @param resource
	 * @return
	 */
	public String tableBaseLine(Object resource){
		Class clazz=resource.getClass();
		String className=clazz.getName().replace(clazz.getPackage().getName() + ".", "");		
		//_T_A_Org-->T_A_ORG
		//EMP-->EMP
		String tableName=toBaselineColumn(className);
		return tableName.startsWith("_") ==true ? tableName.substring(1).toUpperCase() :tableName;
	}
	
	/**
	 * ex:hireDate -->hire_date
	 * @param column
	 * @return
	 */
	public String toBaselineColumn(String column) {
		if (StringUtils.isAllLowerCase(column) || StringUtils.isAllUpperCase(column) || "tenantGroup".equals(column) ||"createDate".equals(column)) {
			return column;
		} 

		StringBuffer buffer = new StringBuffer();
		char arr[] = column.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '_') {
				if (Character.isUpperCase(arr[i])) {
					buffer.append("_" + arr[i]);
				} else {
					buffer.append(arr[i]);
				}
			}
		}
		String columnName=buffer.toString();
		return columnName.startsWith("_")==true ? columnName.substring(1) : columnName;
	}

	public Map getBeanMap() {
		return beanMap;
	}

	public void setBeanMap(Map beanMap) {
		this.beanMap = beanMap;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<Object> getParam() {
		return param;
	}

	public void setParam(List<Object> param) {
		this.param = param;
	}

}
