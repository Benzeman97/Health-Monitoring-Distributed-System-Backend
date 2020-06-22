package com.benz.equip.controller;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.equip.entity.Product;
import com.benz.equip.exception.DataNotFoundException;
import com.benz.equip.model.ProductCategory;
import com.benz.equip.services.MedicalProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class MedicalProductController {

	@Autowired
	MedicalProductService medical_prod_service;
	
	@PostMapping("/save")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Product saveProduct(@RequestBody Product product)
	{
	
		if(!product.getProductName().trim().isEmpty() &&!product.getMadeBy().trim().isEmpty() && product.getPrice()!=0.0 
				&& !product.getInfo().trim().isEmpty())
			return medical_prod_service.saveProduct(product);
		else 
			throw new NullPointerException();
	}
	
	@PutMapping("/update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Product updateProduct(@RequestBody Product product)
	{
		if(!product.getProductName().trim().isEmpty() &&!product.getMadeBy().trim().isEmpty() && product.getPrice()!=0.0 
				&& !product.getInfo().trim().isEmpty())
			return medical_prod_service.updateProduct(product);
		else 
			throw new NullPointerException();
	}
	
	@GetMapping("get/{productId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Product getProduct(@PathVariable("productId") int productId)
	{
		if(productId!=0)
			return medical_prod_service.getProduct(productId);
			else
				throw new DataNotFoundException("Data Not Found");
	}
	
	@GetMapping("/all")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Product> getProducts()
	{
		List<Product> products=medical_prod_service.getProducts();
		
		if(products.size()!=0)
			return products;
		else
			throw new DataNotFoundException("Data Not Found");
	}
	
	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId)
	{
		if(productId!=0)
			medical_prod_service.deleteProduct(productId);
			else
				throw new DataNotFoundException("Data Not Found");
	}
	
	@GetMapping("/{category}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ProductCategory getProducts(@PathVariable("category") String category)
	{
		if(!category.trim().isEmpty())
		return medical_prod_service.getProducts(category);
		else
			throw new DataNotFoundException("Data Not Found");
	}
	
	
}
