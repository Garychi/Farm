package com.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Argiculture implements Serializable{
	private static final long serialVersionUID = 6145871092886827996L;
	
	private String type;
	private String farmAge;
	private String owner;
	private Double acre; // 英畝
	private Map<String, Object> info;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFarmAge() {
		return farmAge;
	}

	public void setFarmAge(String farmAge) {
		this.farmAge = farmAge;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Double getAcre() {
		return acre;
	}

	public void setAcre(Double acre) {
		this.acre = acre;
	}

	public Double getArea() {
		return this.acre * this.acre;
	}

	public Map<String, Object> getInfo() {
		info = new HashMap<String, Object>();
		info.put("owner" , getOwner());
		info.put("type" , getType());
		info.put("farmAge" , getFarmAge());
		info.put("acre" , getAcre());
		info.put("area" , getArea());
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

}
