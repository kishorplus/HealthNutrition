package com.health.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.health.model.ParticipantDetail;

public interface ParticipantDao extends CrudRepository<ParticipantDetail, Integer> {

	
	@Modifying
	@Query("update ParticipantDetail set  firstname=?1 ,lastname=?2, email=?3,adharNumber=?4,gender=?5,language=?6 where id=?7")
	 int updateparticipantDeatail(String firstname, String lastname,String email,String adharNumber, String gender,String language,int participant_id);

	
	/*
	 * @Modifying
	 * // @Query(" FROM parcipants_deatail t1 INNER JOIN parcipants_deatail t2  WHERE t1.participant_id = :participant_id < t2.participant_id = :participant_id AND t1.adhar_number = :aadharNumber = t2.adhar_number = :aadharNumber"
	 * ) int deleteByQuery(int participant_id,String aadharNumber );
	 * 
	 */
	

}
