package com.it.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Multitenancy implements Serializable{
	private static final long serialVersionUID = 588950245360469340L;
	
	protected Date createdate;
	protected String creator;
	protected String modiby;
	protected Date modidate;
	protected BigDecimal flag;
	
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModiby() {
		return modiby;
	}
	public void setModiby(String modiby) {
		this.modiby = modiby;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public BigDecimal getFlag() {
		return flag;
	}
	public void setFlag(BigDecimal flag) {
		this.flag = flag;
	}
	
	
}
