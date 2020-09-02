package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.health.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

	
	User findByEmail(String email);
	
	@Query("from User u where u.username=?1")
	User findByClassname(String username);
	
	
	
	
	
	 
}
