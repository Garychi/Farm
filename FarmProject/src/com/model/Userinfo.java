package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USERINFO database table.
 * 
 */
@Entity
@Table(name="USERINFO")
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserinfoPK id;

	@Column(name="COMP_CODE")
	private String compCode;

	private Date createdate;

	private String creator;

	private Integer flag;

	private String modiby;

	private Date modidate;

	private String userName;

	public Userinfo() {
		this.id=new UserinfoPK();
	}

	public UserinfoPK getId() {
		return this.id;
	}

	public void setId(UserinfoPK id) {
		this.id = id;
	}

	public String getCompCode() {
		return this.compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getModiby() {
		return this.modiby;
	}

	public void setModiby(String modiby) {
		this.modiby = modiby;
	}

	public Date getModidate() {
		return this.modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}