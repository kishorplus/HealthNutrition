package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.TraningInformation;
import com.health.model.topic;

public interface TraninigInformationRespositary extends CrudRepository<TraningInformation,Integer> 

{

	
	 @Query("from TraningInformation u where u.category=?1") 
	 List<TraningInformation> findByCategory(Category category);
 

}
