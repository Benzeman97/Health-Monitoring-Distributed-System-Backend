package com.benz.user.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component("UserStatus")
@Scope(value = "prototype")
@JsonRootName(value="UserStatus")
@NoArgsConstructor
@AllArgsConstructor
public class UserStatus {

	
	private String userId;
	private boolean isLogged;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	
}
