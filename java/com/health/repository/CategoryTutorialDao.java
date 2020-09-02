package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.category_Tutorial;
public interface CategoryTutorialDao extends CrudRepository<category_Tutorial, Integer> {
	
	  @Query("from category_Tutorial u where u.cat=?1")
	  List<category_Tutorial> findByCategory(Category cat);
	 
	  
	/*
	 * @Query("from category_Tutorial u where u.cat=?1,u.tutorial=?2")
	 * List<category_Tutorial> findByCategoryAndlanguage(Category cat,Tutorial
	 * tutorial);
	 */
	  @Query("from category_Tutorial u where u.cat=?1 and u.tutorial=?2")
	  List<category_Tutorial> findBycategoryAndlanguageza(Category cat,Tutorial tutorial);
	  
	 

}
