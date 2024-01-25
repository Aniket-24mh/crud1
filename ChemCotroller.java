package com.logproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logproject.model.Product;
import com.logproject.model.User;
import com.logproject.repo.ProductRepo;
import com.logproject.repo.UserRepo;
import com.logproject.service.ProductService;

@RestController
@CrossOrigin
public class ChemCotroller {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProductService productService;

	List<Product> list = new ArrayList<>();

	@RequestMapping("load")
	public List<Product> load() {
		return productRepo.findAll();
	}

	@RequestMapping("add")
	public Product add(@RequestBody Product product) {
		product = productRepo.save(product);
		return product;
	}

	

	@RequestMapping("login{username}and{password}")
	public int login(@PathVariable String username, @PathVariable String password) {
		System.out.print("username");
		List<User> list = userRepo.findAll();

		for (User user : list) {

			if (username.equals(user.getUsername())) {
				if (password.equals(user.getPassword())) {
					if (user.getActive() == 1)
						return 3; // login done
					else
						return 2; // account not active
				} else
					return 1; // password wrong
			}
		}
		if (username.equals("ss") && password.equals("221199")) {
			return 10;// Admin login
		}

		return 0; // username wrong

	}

	@RequestMapping("register")
	public boolean register(@RequestBody User user) {
		System.out.println("in register");

		try {
			user.setActive(0);

			userRepo.save(user);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	
	@RequestMapping(value = "buy/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> buyProduct(@PathVariable int id) {
        // Logic to mark the product as bought in the database
        // Implement your business logic here

        // For example, updating the product status to "bought"
        java.util.Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setBought(true); // Assuming there *is a boolean field 'bought' in your Product entity
            productRepo.save(product);
            return ResponseEntity.ok("Product bought successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }
	
	@RequestMapping("delete{id}")
	public boolean delete(@PathVariable int id)

	{
		System.out.println("delete");
		try {
	        productRepo.deleteById(id);
	        return true;
	    } catch (EmptyResultDataAccessException e) {
	        // Handle case where ID is not found in the database
	        e.printStackTrace();
	        return false;
	    } catch (Exception e) {
	        // Handle other exceptions
	        e.printStackTrace();
	        return false;
	    }

	}
	
	
	
	
	//// find by mol.formula
	
	@RequestMapping("loadProductByMol{moleculerformula}")
	public List<Product> findByMoleculerformula(@PathVariable String moleculerformula)
	{
		return productService.findByMoleculerformula(moleculerformula);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
