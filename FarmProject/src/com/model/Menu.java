package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MENU_ID")
	private String menuId;

	private Date createdate;

	private String creator;

	private Integer flag;

	@Column(name = "MENU_NAME")
	private String menuName;

	private String modiby;

	private Date modidate;

	private String parent;

	@Column(name = "MENU_PATH")
	private String menuPath;

	public Menu() {
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
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

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

}