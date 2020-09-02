package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Consaltantant;
import com.health.repository.ConsaltantDao;
import com.health.service.ConsaltantService;


@Service
public class consaltantServiceImpl implements ConsaltantService {

	@Autowired
	private ConsaltantDao consaltantdao;

	@Override
	public List<Consaltantant> findAll() {

		List<Consaltantant> local = (List<Consaltantant>) consaltantdao.findAll();

		return local;

	}
	
	@Override
	public void deleteProduct(Integer id){

		
		consaltantdao.delete(id);
		
																																																																												
	}
//chage the method
	@Override
	
	  public Consaltantant getProductById(Integer id) {
	  
	  Consaltantant var = consaltantdao.findOne(id);
	  
	  return var;
	  
	  }
	 
	
	@Transactional																																																							
	public Boolean UpdateConsalantant(String description,String name, String uploadVideo,int id) {
		
		int status=	consaltantdao.updateconsalantant( description,name,uploadVideo,id);
		
		System.err.println(status);
		
		if(status>0) {
			return true;
		}else {
			return false;
		}
	
	}
	
	
    @Override
    public Consaltantant saveProduct(Consaltantant product) {
    	
        return consaltantdao.save(product);
    }

	/*
	 * @Override public Consaltantant getProductById(Integer id) { // TODO
	 * Auto-generated method stub return null; }
	 */
	


	
	
	
	
	
}
 

	
	

