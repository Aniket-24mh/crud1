package com.logproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logproject.model.Product;
import com.logproject.repo.ProductRepo;
import com.logproject.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {
	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Product> findByMoleculerformula(String moleculerformula) {
		return productRepo.findByMoleculerformula(moleculerformula);
	}

}
