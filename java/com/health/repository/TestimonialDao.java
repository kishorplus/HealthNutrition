package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Testimonial;

public interface TestimonialDao extends CrudRepository<Testimonial, Integer> 
{

	
	@Modifying
	@Query("update Testimonial set  testimonialName=?1 ,testimoniaqlDescription=?2, uploadTestiminial=?3 where id=?4")
	 int updateTestimonial(String testimonialName,String testimoniaqlDescription, String uploadTestiminial,int id);
	
	/*
	 * here is code for date spring
	 */

	@Query("from Testimonial order by timedate desc")
	List<Testimonial> findBydate();


	
	

}
