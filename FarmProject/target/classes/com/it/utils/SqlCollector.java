package com.it.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SqlCollector {
	private String sql;
	private List<Object> param;
	private Map<String, Object> mapParam;
	private List<Object[]> paramList;

	public SqlCollector() {
		this.mapParam = new HashMap();
		this.param = new ArrayList();
	}

	public SqlCollector(String paramString, List<Object> paramList1) {
		setSql(paramString);
		setParam(paramList1);
	}

	public SqlCollector(String paramString, Map<String, Object> paramMap) {
		setSql(paramString);
		setMapParam(paramMap);
	}

	public String getSql() {
		return this.sql;
	}

	public void setSql(String paramString) {
		this.sql = paramString;
	}

	public List<Object> getParam() {
		return this.param;
	}

	public void setParam(List<Object> paramList1) {
		this.param = paramList1;
	}

	public Map<String, Object> getMapParam() {
		return this.mapParam;
	}

	public void setMapParam(Map<String, Object> paramMap) {
		this.mapParam = paramMap;
	}

	public String toString() {
		StringBuilder localStringBuilder = new StringBuilder();
		localStringBuilder.append("\t[SQL]" + this.sql + "\n");
		localStringBuilder.append("\t[param]\n");
		if (this.param != null) {
			Iterator localIterator = this.param.iterator();
			while (localIterator.hasNext()) {
				Object localObject = localIterator.next();
				localStringBuilder.append("\t\t{" + localObject + "}");
			}
		}
		return localStringBuilder.toString();
	}

	public List<Object[]> getParamList() {
		return this.paramList;
	}

	public void setParamList(List<Object[]> paramList1) {
		this.paramList = paramList1;
	}
}
