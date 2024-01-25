package com.logproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logproject.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin save(org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin admin);

	
	
	

}
