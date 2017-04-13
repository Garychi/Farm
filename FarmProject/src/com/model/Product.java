package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductPK id;

	private String category;
	private Date createdate;
	private String creator;
	private String description;
	private BigDecimal flag;
	
	@Column(name="IMG_URI")
	private String imgUri;
	
	@Column(name="IS_ONSHELF")
	private String isOnshelf;
	
	private String modiby;
	private Date modidate;
	private String remark;
	
	@Column(name="SALES_PRICE")
	private Double salesPrice;
	
	private String status;

	public Product() {
		this.id = new ProductPK();
	}

	public ProductPK getId() {
		return this.id;
	}

	public void setId(ProductPK id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getFlag() {
		return this.flag;
	}

	public void setFlag(BigDecimal flag) {
		this.flag = flag;
	}

	public String getImgUri() {
		return this.imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public String getIsOnshelf() {
		return this.isOnshelf;
	}

	public void setIsOnshelf(String isOnshelf) {
		this.isOnshelf = isOnshelf;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getSalesPrice() {
		return this.salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}