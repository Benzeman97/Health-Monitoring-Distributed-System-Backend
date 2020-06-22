package com.benz.user.model;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value="UserLogin")
public class UserLogin {

	private String email;
	private String password;
	
	public UserLogin() {
	}
	
	public UserLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
