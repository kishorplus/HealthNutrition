package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.User;
import com.health.model.contributor_Role;
import com.health.model.topic;

public interface contributor_RoleDao extends CrudRepository<contributor_Role, Long> 
{

	@Query("from contributor_Role  u where u.user=?1")
	List<contributor_Role> findByContributorRole(User role);
		
	@Query("from contributor_Role  u where u.user=?1 and u.category=?2")
	List<contributor_Role> findByContributorTopic(User user,Category category);
	
	
	@Query("from contributor_Role  u where u.user=?1 and u.topic=?2")
	List<contributor_Role> findByContributorLanguage(User user,topic topic);
	

}
