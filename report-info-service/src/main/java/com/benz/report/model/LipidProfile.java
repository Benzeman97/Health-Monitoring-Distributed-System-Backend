package com.benz.report.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonRootName(value = "LipidProfile")
@Component("LipidProfile")
@NoArgsConstructor
@AllArgsConstructor
public class LipidProfile {

	private int age;
	private int tot_chole;
	private int ldl_chole;
	private int hdl_chole;
	private int trigly;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTot_chole() {
		return tot_chole;
	}
	public void setTot_chole(int tot_chole) {
		this.tot_chole = tot_chole;
	}
	public int getLdl_chole() {
		return ldl_chole;
	}
	public void setLdl_chole(int ldl_chole) {
		this.ldl_chole = ldl_chole;
	}
	public int getHdl_chole() {
		return hdl_chole;
	}
	public void setHdl_chole(int hdl_chole) {
		this.hdl_chole = hdl_chole;
	}
	public int getTrigly() {
		return trigly;
	}
	public void setTrigly(int trigly) {
		this.trigly = trigly;
	}
	
	
	
	
}
