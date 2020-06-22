package com.benz.equip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.benz.equip.dao.ProductDAO;
import com.benz.equip.entity.Product;
import com.benz.equip.model.ProductCategory;
import com.benz.equip.services.impl.MedicalProductServiceImpl;

@Service
public class MedicalProductService {
	
	@Autowired
	MedicalProductServiceImpl medical_product_service_impl;

	@Autowired
	ProductDAO product_dao;
	
	public Product saveProduct(Product product)
	{
		return product_dao.save(product);
	}
	
	public Product updateProduct(Product product)
	{
		Product prod=medical_product_service_impl.updateProduct(product);
		return product_dao.saveAndFlush(prod);
	}
	
	public Product getProduct(int productId)
	{
		return product_dao.findByproductId(productId);
	}
	
	public List<Product> getProducts()
	{
		return product_dao.findAll();
	}
	
	public void deleteProduct(int productId)
	{
		Product prod= product_dao.getOne(productId);
		product_dao.delete(prod);
	}
	public ProductCategory getProducts(String category)
	{
		List<Product> products=product_dao.findByCategory(category);
		
		if(products.size()!=0)
		{
			ProductCategory productCategory=new ProductCategory();
			productCategory.setProduct(products);
			return productCategory;
		}else
			return null;
	}
}
