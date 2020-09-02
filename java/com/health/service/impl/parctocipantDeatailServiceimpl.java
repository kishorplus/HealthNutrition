package com.health.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.repository.participantDao;
import com.health.service.participantService;


@Service
public class parctocipantDeatailServiceimpl implements participantService {

	
	
	@Autowired 
	private participantDao participantDao;

	@Transactional																																																							
	public Boolean updateparticipantDeatail(String firstname,String lastname,String email,String adharNumber, String gender,String language,String age,String qua,String exp, String org, int participant_id) 
	{
		
		int status=	participantDao.updateparticipantDeatail( firstname,lastname, email, adharNumber,  gender,language,age,qua,exp,org,participant_id);
		
	
		System.err.println(status);
		
		if(status>0) {
			return true;
		}else {
			return false;
		}
	
	}
	
	

	/*
	 * @Transactional public Boolean deleteByQuery(int id,String aadhar) {
	 * 
	 * int status= participantDao.deleteByQuery(id,aadhar);
	 * 
	 * 
	 * 
	 * 
	 * System.err.println(status);
	 * 
	 * if(status>0) { return true; }else { return false; }
	 * 
	 * }
	 */




	

	}
