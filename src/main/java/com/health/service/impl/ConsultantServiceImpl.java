package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Consultant;
import com.health.repository.ConsultantDao;
import com.health.service.ConsultantService;


@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	private ConsultantDao consultantDao;

	@Override
	public List<Consultant> findAll() {

		List<Consultant> local = (List<Consultant>) consultantDao.findAll();

		return local;

	}
	
	@Override
	public void deleteProduct(Integer id){

		
		consultantDao.delete(id);
		
																																																																												
	}
//chage the method
	@Override
	
	  public Consultant getProductById(Integer id) {
	  
	  Consultant var = consultantDao.findOne(id);
	  
	  return var;
	  
	  }
	 
	
	@Transactional																																																							
	public Boolean updateConsultant(String description,String name, String uploadVideo,int id) {
		
		int status=	consultantDao.updateconsalantant( description,name,uploadVideo,id);
		
		System.err.println(status);
		
		if(status>0) {
			return true;
		}else {
			return false;
		}
	
	}
	
	
    @Override
    public Consultant saveProduct(Consultant product) {
    	
        return consultantDao.save(product);
    }

	/*
	 * @Override public Consaltantant getProductById(Integer id) { // TODO
	 * Auto-generated method stub return null; }
	 */
	


	
	
	
	
	
}
 

	
	

