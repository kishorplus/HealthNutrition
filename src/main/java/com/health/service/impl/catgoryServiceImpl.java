package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;
import com.health.model.Consultant;
import com.health.model.Event;
import com.health.repository.CategoryDao;
import com.health.service.ConsultantService;
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
	  public Category getProductById(int id){
	  
		  Category var=categoryDao.findOne(id);
	  
	  return var;
	  
	  }
	  
	  
	  @Override 
	  public Category findByid(int id){
	  
		  Category var=categoryDao.findByid(id);
		  
	  
	  return var;
	  
	  }
	  

}
