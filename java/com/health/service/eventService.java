package com.health.service;

import java.util.List;

import com.health.model.Event;



public interface eventService {
	
		List<Event> findAll();
	
	  void deleteProduct(Integer id);
	  
	  
	  Event getProductById(int id);
	  

	  Boolean UpdateEvent(String eventname,String date, String description,String venuename, String contactperson,String contactnumber,String email,int id);
	  
	  
 

}
