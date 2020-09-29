package com.health.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface trainingInformationDao extends CrudRepository<TraningInformation, Integer>{ 
	
	
	 @Query("from TraningInformation u where u.user=?1") 
	 List<TraningInformation> findByCategoryOnUser(User user);
	 
	 
	 @Query("from TraningInformation u where u.user=?1 and category_id=?2") 
	 TraningInformation findByuserOnfeedback(User user,Category cat);
	 


}
