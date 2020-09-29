package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Category;
import com.health.model.District;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.language;
import com.health.model.state;

public interface DistrictRepositary extends CrudRepository<District,Integer> {
	
	
     District findByid(int id);
	
     District findBydistrictName(String name);
 	
    
	  @Query("from District  where state=?1 ")
	  List<District> findByState(state state);
	  
	 
	
}
