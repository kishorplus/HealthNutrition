package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.category_Tutorial;
import com.health.model.topic;

public interface topicRepositary extends CrudRepository<topic , Integer>
{
	
		topic findBytopicname(String topic);
		 
		// List<topic> findBytopicnameserach(String topic)
	
	
		 @Query("from topic u where u.category=?1") 
		 List<topic> findByCategory(Category category);
	 
	
	  
	/*
	 * @Query("from topic u where u.category=?1") List<topic>
	 * findBytopicnameserach(String topic);
	 */
			
}
