package com.health.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;
import com.health.model.Consaltantant;
import com.health.model.Event;
import com.health.repository.CategoryDao;
import com.health.service.ConsaltantService;
import com.health.service.categoryService;

@Service
public class catgoryServiceImpl implements categoryService {

	@Autowired 
	private CategoryDao  categoryDao;
	
	@Override
	public List<Category> findAll() {

		List<Category> local = (List<Category>) categoryDao.findAll();

		return local;

	}
	
	@Override
	public Category findBycategoryname(String name) {

		Category local =  categoryDao.findBycategoryname(name);

		return local;

	}
	
	@Override
	public void deleteProduct(Integer id){

		
		categoryDao.delete(id);
		
																																																																												
	}
	
	   
	   @Override
		@Transactional																																																							
		public Boolean updateCategory(String testimonialName,int id) {
			
			int status=	categoryDao.updateCategory(testimonialName,id);

			
			if(status>0) {
				return true;
			}else {
				return false;
			}
		
		}
	
	  @Override 
	  public Category getProductById(int id){
	  
		  Category var=categoryDao.findOne(id);
	  
	  return var;
	  
	  }
	  
	  
	  @Override 
	  public Category findByid(int id){
	  
		  Category var=categoryDao.findByid(id);
		  
	  
	  return var;
	  
	  }

	@Override
	public Category findByid(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	  
	
	

}
