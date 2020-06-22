package com.benz.equip.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.equip.dao.ProductDAO;
import com.benz.equip.entity.Product;

interface IMedicalProductServiceImpl
{
	public Product updateProduct(Product product);
}

@Service
public class MedicalProductServiceImpl implements IMedicalProductServiceImpl{

	@Autowired
	ProductDAO product_dao;
	
	public Product updateProduct(Product product)
	{
		try {
		Product prod=product_dao.getOne(product.getProductId());
		
		prod.setProductName(product.getProductName());
		prod.setPrice(product.getPrice());
		prod.setInfo(product.getInfo());
		prod.setCategory(product.getCategory());
		
		return prod;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return product;
		}
	}
}
