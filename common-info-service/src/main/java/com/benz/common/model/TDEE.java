package com.benz.common.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonRootName(value = "TDEE")
@Component("TDEE")
@NoArgsConstructor
@AllArgsConstructor
public class TDEE {

	private int age;
	private int weight;
	private int height;
	private String gender;
	private String activity;
	private int bodyFat;
	private long result;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getBodyFat() {
		return bodyFat;
	}
	public void setBodyFat(int bodyFat) {
		this.bodyFat = bodyFat;
	}
	public long getResult() {
		return result;
	}
	public void setResult(long result) {
		this.result = result;
	}
	
	
}
