package com.health.service;

import java.util.List;

import com.health.model.Consultant;



public interface ConsultantService {
	
	List<Consultant> findAll();
	
    void deleteProduct(Integer id);
    
    
    Consultant getProductById(Integer id);

	Boolean updateConsultant(String description,String name, String uploadVideo,int consalantant_id);
	
	
	
	 Consultant saveProduct(Consultant product);
	


}
