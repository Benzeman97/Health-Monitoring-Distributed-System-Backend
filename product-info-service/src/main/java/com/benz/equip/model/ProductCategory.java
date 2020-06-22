package com.benz.equip.model;

import java.util.List;

import com.benz.equip.entity.Product;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = " ProductCategory")
public class ProductCategory {

	private List<Product> product;

	public ProductCategory() {
	}

	public ProductCategory(List<Product> product) {
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
}
