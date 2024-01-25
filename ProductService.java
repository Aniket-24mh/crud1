package com.logproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logproject.model.Product;

@Service
public interface ProductService {

	
	public List<Product> findByMoleculerformula(String moleculerformula);
		
	
	
}
