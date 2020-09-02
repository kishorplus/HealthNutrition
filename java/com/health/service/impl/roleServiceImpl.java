package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.domain.security.Role;
import com.health.repository.RoleRepository;
import com.health.service.roleService;


@Service
public class roleServiceImpl implements roleService {
	
	@Autowired
	RoleRepository roleRepository;

	
	@Override
	public List<Role> findAll() {
		
		
		List<Role> local = (List<Role>) roleRepository.findAll();
		
		return local;
		
		
	}
	
	/*
	 * @Override public Role findByIdRoles(Long id){
	 * 
	 * return roleRepository.findByIdRoles(id);
	 * 
	 * 
	 * 
	 * }
	 */
	 

	
	
	
	

	
	
	
	
	

}
