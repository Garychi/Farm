package com.model;

import java.io.Serializable;
import java.util.Date;

public class Management implements Serializable{

	private static final long serialVersionUID = -1092676145615242454L;
	
	private String creator;
	private Date createdate;
	private String modiby;
	private Date modidate;
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
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
}
