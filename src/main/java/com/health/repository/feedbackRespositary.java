package com.health.repository;

import org.springframework.data.repository.CrudRepository;

import com.health.model.Feedback;
import com.health.model.feedbackMasterTrainer;

	public interface feedbackRespositary extends CrudRepository<feedbackMasterTrainer, Integer>
{
	
	
	

}
