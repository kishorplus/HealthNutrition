package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Event;
import com.health.model.Testimonial;
import com.health.repository.EventDao;
import com.health.service.eventService;



@Service
public class eventServiceImpl implements eventService {
	

	@Autowired
	private EventDao eventdao;

	
	@Override
	public List<Event> findAll() {
		
		List<Event> local = (List<Event>) eventdao.findAll();
		return local;
	}
	
	  @Override public void deleteProduct(Integer id) {  
	  eventdao.delete(id);
	  
	  }
		
	  @Override 
	  public Event getProductById(int id){
	  
	  Event var=eventdao.findOne(id);
	  
	  return var;
	  
	  }
 
	  @Override
	  @Transactional
	  public Boolean UpdateEvent(String eventname,String date, String description,String venuename, String contactperson,String contactnumber,String email,int id) {
	  
       int status= eventdao.UpdateEvent(eventname, date, description, venuename, contactperson,contactnumber,email, id);

	  System.err.println(status);
	  
	  if(status>0) { return true; }
	  else { return false; }
	  
	  }


	

}
