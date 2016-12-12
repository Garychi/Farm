package com.test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

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
//		JSONObject jsonObject = (JSONObject) resource;
		
		this.setBeanMap(descriptionMapper(resource));
		this.getBeanMap();
		columnBuffer.append("SELECT ");
		valuesBuffer.append(" WHERE 1=1 ");
		String s ="aaa";
		if (MapUtils.isNotEmpty(this.getBeanMap())) {
			Map<String, Object> map = this.getBeanMap();
			map.remove("class");
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = toBaselineColumn(entry.getKey());
				Object value = entry.getValue();
				if (value != null && StringUtils.isNotEmpty(value.toString())) {					
					columnBuffer.append(key + ",");
//					valuesBuffer.append(" "+key + "= ? and");
					valuesBuffer.append(" and "+key+"=? ");
					param.add(value);				
				}
			}
		}
		
		columnBuffer.append(" FROM ");
		columnBuffer.append(tableBaseLine(resource));
		columnBuffer=columnBuffer.replace(columnBuffer.lastIndexOf(","), columnBuffer.lastIndexOf(",")+1, "");
		
//		String columnSql = columnBuffer.toString();
//		String whereSql =valuesBuffer.toString());
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
		columnBuffer.append(this.getClassName() + " (");

		valuesBuffer.append(" VALUES( ");

		if (MapUtils.isNotEmpty(this.getBeanMap())) {
			Map<String, Object> map = this.getBeanMap();
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
		String tableName=toBaselineColumn(className);
		return tableName.startsWith("_") ==true ? toBaselineColumn(className).substring(1).toUpperCase() :tableName;
	}
	
	/**
	 * ex:hireDate -->hire_date
	 * @param column
	 * @return
	 */
	public String toBaselineColumn(String column) {
		if (StringUtils.isAllLowerCase(column) || StringUtils.isAllUpperCase(column)) {
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
		return buffer.toString();
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
