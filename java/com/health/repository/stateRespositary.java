package com.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.health.model.state;

	public interface stateRespositary extends CrudRepository<state, Integer>
	{
		
		//state findBystate_id(int id);
		
		state findBystateName(String name);
		
		
		
	}
