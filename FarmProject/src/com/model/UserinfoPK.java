package com.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USERINFO database table.
 * 
 */
@Embeddable
public class UserinfoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID", unique=true, nullable=false, length=40)
	private String userId;

	@Column(unique=true, nullable=false, length=100)
	private String password;

	public UserinfoPK() {
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserinfoPK)) {
			return false;
		}
		UserinfoPK castOther = (UserinfoPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.password.equals(castOther.password);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.password.hashCode();
		
		return hash;
	}
}