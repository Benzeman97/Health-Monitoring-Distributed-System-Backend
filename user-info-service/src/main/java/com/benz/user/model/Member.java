package com.benz.user.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonRootName;



@Component("Member")
@JsonRootName(value = "Member")
public class Member {

	private String email;
	private boolean isLogged;
	
	
	public Member() {
	}

	public Member(String email, boolean isLogged) {
		this.email = email;
		this.isLogged = isLogged;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	
	
	
}
