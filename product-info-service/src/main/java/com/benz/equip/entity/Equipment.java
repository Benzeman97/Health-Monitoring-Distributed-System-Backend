package com.benz.equip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.benz.equip.cfg.Schema;

@Entity
@Table(name="EQUIPMENTTABLE",schema=Schema.HR)
public class Equipment {

	@Id
	@SequenceGenerator(name = "EQUIP_ID_GEN",sequenceName = "EQUIP_ID_SEQ",initialValue = 6001,allocationSize = 1)
	@GeneratedValue(generator = "EQUIP_ID_GEN")
	@Column(name="EQUIP_ID")
	private int equipId;
	@Column(name="NAME",nullable=false)
	private String name;
	@Column(name="PRICE",nullable=false)
	private double price;
	@Column(name="BRAND",nullable=false)
	private String brand;
	
	public int getEquipId() {
		return equipId;
	}
	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	
}
