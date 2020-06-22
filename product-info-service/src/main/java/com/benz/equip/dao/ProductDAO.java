package com.benz.equip.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.equip.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

	Product findByproductId(int productId);
	
	List<Product> findByCategory(String category);
}
