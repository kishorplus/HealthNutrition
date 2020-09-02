package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.health.model.Category;
import com.health.model.TraningInformation;
import com.health.model.partipantDeatil;

public interface participantDao extends CrudRepository<partipantDeatil, Integer> {

	
	@Modifying
	@Query("update partipantDeatil set  firstname=?1 ,lastname=?2, email=?3,adharNumber=?4,gender=?5,language=?6,age=?7,qualification=?8,exprience=?9,organization=?10 where id=?11")
	 int updateparticipantDeatail(String firstname, String lastname,String email,String adharNumber, String gender,String language,String age,String qua,String exp,String org,int participant_id);


	
	
	 @Query("from partipantDeatil u where u.category=?1 and u.titleName=?2") 
	 List<partipantDeatil> findByCategoryAndName(Category category,String name);

	
	/*
	 * @Modifying
	 * // @Query(" FROM parcipants_deatail t1 INNER JOIN parcipants_deatail t2  WHERE t1.participant_id = :participant_id < t2.participant_id = :participant_id AND t1.adhar_number = :aadharNumber = t2.adhar_number = :aadharNumber"
	 * ) int deleteByQuery(int participant_id,String aadharNumber );
	 * 
	 */
	

}
