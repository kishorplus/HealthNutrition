package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.contributor_Role;
import com.health.model.language;
import com.health.model.topic;

public interface TutorialDao extends CrudRepository<Tutorial, Integer> {

	Tutorial findBylanguage(String name);

	// Admin Video Approve
	
	@Query("from Tutorial u where u.category=?1 and u.lan=?2 and u.status=?3")
	List<Tutorial> findByLanAndCat(Category category,language language,int status);
	
	@Query("from Tutorial u where u.category=?1 and u.lan=?2 and u.user=?3 ")
	List<Tutorial> findByuserNameLancat(Category cat,language lan,User user);
	

	
	@Query("from Tutorial u where u.category=?1 and u.lan=?2")
	List<Tutorial> findByLanAndCategory(Category category,language language);
	
	
	
	@Query("from Tutorial u where u.category=?1 and u.status=?2")
	List<Tutorial> findByCategoryLan(Category cat,int status);
	
    @Query("from Tutorial u where u.lan=?1")
	List<Tutorial> findByLan(language language);

	@Query("from Tutorial u where u.outlineStatus=4 or slideStatus=4 or  supadateKeywordByQualitycriptStatus=4 or  videoStatus=4 or keywordStatusSet=4")
	List<Tutorial> findByTutorialQualityReview();

	/* Only other than English language */

	/*
	 * @Query("from Tutorial u where u.lan Not IN (1)") List<Tutorial>
	 * findBylanguageIdForMarkAsPublicReview();
	 */

	// Here is code for Approve Tutorial

	@Query("from Tutorial u where u.status=0 and u.outlineStatus=4 and slideStatus=4 and  scriptStatus=4 and  videoStatus=4 and keywordStatusSet=4")
	List<Tutorial> findByIdStausForApprove();

	/*
	 * @Query("from Tutorial u where u.videoStatus IN ()") List<Tutorial>
	 * findByContributorStatus();
	 */
	
	@Query("from Tutorial u where u.status=1 ORDER BY status Desc")
	List<Tutorial> finBystatus();
	
	
//	@Query("from Tutorial u where u.videoStatus=1")
//	List<Tutorial> finByVideoStatus();
	
	@Query("from Tutorial u where u.videoStatus=1")
	List<Tutorial> findByVideoAdminRevPending();
	
	@Query("from Tutorial u where u.videoStatus=5")
	List<Tutorial> findByVideoAdminRevImprovement();
	
	@Query("from Tutorial u where u.videoStatus=2")
	List<Tutorial> findByVideoAdminRevApproved();
	
	@Query("from Tutorial u where u.videoStatus IN (1,2,5,4,3)")
	List<Tutorial> findByVideoAll();
	
	@Query("from Tutorial u where u.videoStatus IN (2,5,4,3)")
	List<Tutorial> findByVideoStatusByAdmin();

	@Query("from Tutorial u where  topic=?1 and category=?2 and langaueg_id=?3")
	Tutorial findByTutorialForComment(topic topic, Category category, language language);

	@Query("from Tutorial u where u.user=?1 and topic=?2 and category=?3 and langaueg_id=?4")
	Tutorial finByKeywordContent(User user, topic topic, Category category, language language);

	// Access Keyword information into Quality
	@Query("from Tutorial u where  topic=?1 and category=?2 and langaueg_id=?3")
	Tutorial findByKeywordInQuality(topic topic, Category category, language language);

	@Query("from Tutorial u where  topic=?1 and category=?2 and langaueg_id=?3")
	Tutorial finByKeywordContentDomain(topic topic, Category category, language language);

	@Query("from Tutorial u where u.category=?1 and langaueg_id=?2 and topic=?3")
	List<Tutorial> findByCategoryAndlanguage(Category category, language language, topic topic);

	@Query("from Tutorial  u where u.user=?1 and u.category=?2")
	List<Tutorial> findByContributorTopic(User user, Category category);

	@Query("from Tutorial  u where u.user=?1 and u.topic=?2")
	List<Tutorial> findByTopicByLanguage(User user, topic topic);

	@Query("from Tutorial u where u.user=?1 and topic=?2")
	Tutorial findByContributorUserAndTopic(User user, topic topic);

	@Modifying
	@Query("update Tutorial set keyword=?1, keywordStatusSet=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateKeyword(String keywordmeassage, int keywordstatus, User user, topic topic, Category category);

	@Modifying
	@Query("update Tutorial set outlin=?1, outlineStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateOutline(String outlinemeassage, int outlineStatus, User user, topic topic, Category category);

	@Modifying
	@Query("update Tutorial set slide=?1, slideStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateSlide(String outlinemeassage, int outlineStatus, User user, topic topic, Category category);

	@Modifying
	@Query("update Tutorial set script=?1,scriptStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateScript(String script, int scriptStatus, User user, topic topic, Category category);

	@Query("from Tutorial  u where u.user=?1")
	List<Tutorial> findByContributorRole(User role);

	@Modifying
	@Query("update Tutorial set video=?1, videoStatus=?2 where user_id=?3 and topic_id=?4 and category_id=?5")
	int updateVideo(String video, int videoStatus, User user, topic topic, Category category);

	// Admin Update status VideotutorialDao

	@Modifying
	@Query("update Tutorial set videoStatus=?1 where  topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int updateVideoStatusByAdmin(int videoStatus, topic topic, Category category, language language);

	// Domain update status for Component

	@Modifying
	@Query("update Tutorial set outlineStatus=?1 where  topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int updateOutlineStatusByDomain(int outlineStatus, topic topic, Category category, language language);

	@Modifying
	@Query("update Tutorial set scriptStatus=?1 where  topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int updateScriptStatusByDomain(int scriptStatus, topic topic, Category category, language language);

	// Quality review for the component

	@Modifying
	@Query("update Tutorial set outlineStatus=?1 where  topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int updateOutLineStatusByQuality(int outlineStatus, topic topic, Category category, language language);

	@Modifying
	@Query("update Tutorial set slideStatus=?1 where  topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int upadateSlideStatusByQuality(int slideStataus, topic topic, Category category, language language);

	// Script

	@Modifying
	@Query("update Tutorial set scriptStatus=?1 where topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int upadateScriptStatusByQuality(int scriptStatus, topic topic, Category category, language language);

	// keyword

	@Modifying
	@Query("update Tutorial set keywordStatusSet=?1 where topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int upadateKeywordByQuality(int keywordStatus, topic topic, Category category, language language);

	@Modifying
	@Query("update Tutorial set videoStatus=?1 where topic_id=?2 and category_id=?3 and langaueg_id=?4")
	int upadateVideoByQuality(int videoStatus, topic topic, Category category, language language);

	// here is code for upadate Status Approves

	@Modifying
	@Query("update Tutorial set  status=?1 where id=?2")
	int updateStatusByQualityApprove(int statusApproveByQuality, int idStatus);

	


}
