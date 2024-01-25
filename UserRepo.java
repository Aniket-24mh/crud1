package com.logproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logproject.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
	
	
}
