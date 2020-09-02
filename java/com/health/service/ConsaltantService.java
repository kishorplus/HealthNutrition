package com.health.service;

import java.util.List;

import com.health.model.Consaltantant;



public interface ConsaltantService {
	
	List<Consaltantant> findAll();
	
    void deleteProduct(Integer id);
    
    
    Consaltantant getProductById(Integer id);

	Boolean UpdateConsalantant(String description,String name, String uploadVideo,int consalantant_id);
	
	
	
	 Consaltantant saveProduct(Consaltantant product);
	


}
