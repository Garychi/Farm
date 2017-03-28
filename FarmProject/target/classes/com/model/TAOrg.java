package com.model;

import java.io.Serializable;
import java.util.Date;

public class TAOrg implements Serializable{

	private static final long serialVersionUID = 523457869259708001L;
	
	
	private String orgCode;
	private String company;
	private String creator;
	private Date createDate;
	private String dataSource;
	private String tenantGroup;
	
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getTenantGroup() {
		return tenantGroup;
	}
	public void setTenantGroup(String tenantGroup) {
		this.tenantGroup = tenantGroup;
	}
}
