package com.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRODUCT database table.
 * 
 */
@Embeddable
public class ProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROD_CODE")
	private String prodCode;
	
	@Column(name="COMP_CODE")
	private String compCode;

	public ProductPK() {
	}
	public String getProdCode() {
		return this.prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getCompCode() {
		return this.compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductPK)) {
			return false;
		}
		ProductPK castOther = (ProductPK)other;
		return 
			this.prodCode.equals(castOther.prodCode)
			&& this.compCode.equals(castOther.compCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prodCode.hashCode();
		hash = hash * prime + this.compCode.hashCode();
		
		return hash;
	}
}