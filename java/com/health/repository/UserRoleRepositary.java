package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.User;
import com.health.model.language;

public interface UserRoleRepositary extends  CrudRepository<UserRole, Long>{
	
		
			
	
	
		@Query("from UserRole u where u.status=?1 and role=?2")
		List<UserRole> findByStatus(int status,Role rolId);
		
		List<UserRole> findByuser_id(Long long1);
		
		
		@Query("from UserRole u where u.user=?1 and role=?2")
		UserRole findByUserAndRole(User user,Role role);
				
		@Query("from UserRole u where u.status=?1 and role=?2")
		UserRole findByAlreadyUser(int status,User userA);
		
		@Query("from UserRole u where u.status=?1 and u.user=?2")
		List<UserRole> findByUserAndStatuslanguages(int status,User userA);
		
		
		@Query("from UserRole u where u.user=?1")
		UserRole findByRoleCheck(Role role);
		
		@Query(" delete from UserRole u where u.user=?1")
		UserRole findByAndDelete(User role);
	
		@Query(" from UserRole u where u.user=?1")
		UserRole findByRejectElement(User role);
	
		
		@Query(" from UserRole u where u.user=?1")
		UserRole findByUserInfo(User role);
		
		@Query(" from UserRole u where u.user=?1 and u.role=?2")
		UserRole findByUserRole(Role role);
		
		
		@Query(" from UserRole u where u.user=?1")
		List<UserRole> findByUser(User role);
		

		/* accesing value according contributor */
	 
		@Query("from UserRole u where u.status=?1 and user_id=?2")
		List<UserRole> findByStatusAndUser(int status,User user);
	
		/* revoke on the basis of language */
		
		@Query("from UserRole u where u.user=?1 and lan_id=?2")
		UserRole findByLanguageAnduser(User user,language role);
		
		
		@Query("from UserRole u where u.user=?1 and role=?2")
		List<UserRole> findByuserAndRole(User user,Role role);
		

		@Query("from UserRole u where u.user=?1 and role=?2")
		UserRole findByuserAndRoles(User user,Role role);
	
	   /* access the user contribution */	
		@Query(" from UserRole u where u.status=?1 and u.role=?2") 	
		List<UserRole> finbyRoleUser(int status,Role role);
		
		
		
		
		@Query(" from UserRole u where u.user=?1")
		List<UserRole> findBylanguage(User user);
		
	
		@Query("from UserRole u where u.userRoleId=?1 and role=?2")
		UserRole findByContributorId(Long user,Role role);
		
		
	}
