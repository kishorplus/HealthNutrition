package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Consaltantant;
import com.health.model.Testimonial;



public interface ConsaltantDao extends CrudRepository<Consaltantant,Integer>{
	
	
	@Modifying
	@Query("update Consaltantant set  descriptionConsaltant=?1 ,nameConsaltant=?2, uploadConsaltantImage=?3 where id=?4")
	int updateconsalantant(String description,String name, String uploadVideo,int id);
	
	/*
	 * here is code consalatant
	 */
	@Query("from Consaltantant order by timedate desc")
	List<Consaltantant> findBydateConsalant();
	
	/*
	 * Here is code for only access three recored from consalatatant table
	 */

	 @Query("from Consaltantant order by timedate ") 
	 List<Consaltantant> findByConsaltantantDate();
	 

}

