package com.it.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

public class MultitenancyUtil {

	private static String company = "G001";
	private static String tenantGroup = "100";

	public MultitenancyUtil() {

	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTenantGroup() {
		return tenantGroup;
	}

	public void setTenantGroup(String tenantGroup) {
		this.tenantGroup = tenantGroup;
	}

	public static Map<String, Object> getManageColumnMap() {
		Map<String, Object> manage = new HashMap<String, Object>();

		manage.put("Company" , company);
		manage.put("TenantGroup" , tenantGroup);
		return manage;
	}

	public List<String> getManageColumnList() {
		List<String> list = new ArrayList<String>();
		list.add("company");
		list.add("tenantGroup");
		return list;
	}

	/**
	 * 判斷是否為管理欄位
	 * 
	 * @param column
	 * @return
	 */
	public static boolean isManageColumn(String column) {

		if (StringUtils.isNotBlank(column)) {
			column = column.substring(3 , column.length());
			for (Entry<String, Object> entry : getManageColumnMap().entrySet()) {

				// if (StringUtils.endsWith(column, manage)) {
				// return true;
				// }
			}
		}

		return false;
	}
}
