package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.UserRole;
import com.health.model.Tutorial;
import com.health.model.commentOnComponent;

public interface commentOnComponentDao extends CrudRepository<commentOnComponent, Integer> 
{


	@Query("from commentOnComponent u where u.tutorial=?1")
	List<commentOnComponent> findBytutorial_id(Tutorial tutorial);
	
	

	 
}
