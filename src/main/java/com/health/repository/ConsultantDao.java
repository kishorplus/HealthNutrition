package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.Consultant;
import com.health.model.Testimonial;



public interface ConsultantDao extends CrudRepository<Consultant,Integer>{
	
	
	@Modifying
	@Query("update Consultant set  descriptionConsaltant=?1 ,nameConsaltant=?2, uploadConsaltantImage=?3 where id=?4")
	int updateconsalantant(String description,String name, String uploadVideo,int id);
	
	/*
	 * here is code consalatant
	 */
	@Query("from Consultant order by timedate desc")
	List<Consultant> findBydateConsalant();
	
	/*
	 * Here is code for only access three recored from consalatatant table
	 */

	 @Query("from Consultant order by timedate ") 
	 List<Consultant> findByConsultantDate();
	 

}

