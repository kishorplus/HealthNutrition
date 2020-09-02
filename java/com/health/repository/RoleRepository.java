package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.model.User;

public interface RoleRepository extends CrudRepository<Role, Integer> {
			
	Role findByname(String name);

	/*
	 * @Query("from Role u where u.roleId=?1") List<Role> findByIdList(int id);
	 */
	
	  @Query("from Role u where u.roleId=?1")
	   Role findByIdRoles(int id);
	 

}
