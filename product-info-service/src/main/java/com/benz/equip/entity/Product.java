package com.benz.equip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.benz.equip.cfg.Schema;

@Entity
@Table(name = "PRODUCTTABLE",schema = Schema.HR)
public class Product {

	@Id
	@Column(name="PRODUCTID")
	@SequenceGenerator(name = "PRODUCTID_GEN",sequenceName = "PRODUCTID_SEQ",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "PRODUCTID_GEN")
	private int productId;
	@Column(name="PRODUCTNAME")
	private String productName;
	@Column(name="MADEBY")
	private String madeBy;
	@Column(name="PRICE")
	private double price;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="INFO")
	private String info;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
