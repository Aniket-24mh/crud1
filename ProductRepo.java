package com.logproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.logproject.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	
	 @Query(value = "  SELECT * FROM product where moleculerformula= ?1", nativeQuery = true)
        public List<Product>  findByMoleculerformula(String moleculerformula);

	
}
