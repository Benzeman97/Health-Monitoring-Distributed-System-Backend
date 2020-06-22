package com.benz.common.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonRootName(value = "Keto")
@Component("Keto")
@NoArgsConstructor
@AllArgsConstructor
public class Keto {

       private String pActivity;
       private String meat;
       private String veggies;
       private String products;
       private String day;
       private String which;
       
	public String getpActivity() {
		return pActivity;
	}
	public void setpActivity(String pActivity) {
		this.pActivity = pActivity;
	}
	public String getMeat() {
		return meat;
	}
	public void setMeat(String meat) {
		this.meat = meat;
	}
	public String getVeggies() {
		return veggies;
	}
	public void setVeggies(String veggies) {
		this.veggies = veggies;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getWhich() {
		return which;
	}
	public void setWhich(String which) {
		this.which = which;
	}
       
       
       
}
