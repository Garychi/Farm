package com.it.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class HQLGenerator {
	private Map beanMap;
	private String className;
	private Class clazz;
	private String sql = "";
	private List<Object> param;
	
	
	public HQLGenerator(){
		
	}
	
	public HQLGenerator(Object resource){
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
	
	
	public String getSearchHQLByBean(Object resource){
		StringBuffer columnBuffer = new StringBuffer();
		StringBuffer valuesBuffer = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		
		Map<String, Object> map =descriptionMapper(resource);
		this.setBeanMap(map);
		
		columnBuffer.append("SELECT model from ");
		columnBuffer.append(this.getClassName()+" model ");
		columnBuffer.append(" where 1=1 ");
		
		
		return "";
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
