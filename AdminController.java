package com.logproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logproject.repo.AdminRepo;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	AdminRepo adminRepo;
	
	List<Admin> list=new ArrayList<>();
	
	@RequestMapping("adminload")
	public Admin add(@RequestBody Admin admin)
	{
		admin=adminRepo.save(admin);
		return admin;
	}
	
	@RequestMapping("admindelete{id}")
	public boolean delete(@PathVariable int id)
	{
		System.out.println("delete");
		try {
			adminRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
