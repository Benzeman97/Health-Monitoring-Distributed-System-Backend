package com.benz.user.entity;

import java.io.Serializable;

public class UserId implements Serializable{


	private static final long serialVersionUID = -8741829119105587702L;
	
	private int userId;
	private String uniqueId;
	
	public UserId() {
	}
	public UserId(int userId, String uniqueId) {
		this.userId = userId;
		this.uniqueId = uniqueId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uniqueId == null) ? 0 : uniqueId.hashCode());
		result = prime * result + userId;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserId other = (UserId) obj;
		if (uniqueId == null) {
			if (other.uniqueId != null)
				return false;
		} else if (!uniqueId.equals(other.uniqueId))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
}
