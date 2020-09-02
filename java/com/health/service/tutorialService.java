package com.health.service;

import java.util.List;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.language;
import com.health.model.topic;

public interface tutorialService {
	
	
	List<Tutorial> findAll();
	
	
	Boolean updateKeyword(String keywordMessage, int status,User user, topic topic ,Category category);

	Boolean updateOutline(String outlineMessage, int status,User user,topic topic,Category category);
	
	Boolean updateSlide(String slideUpload, int statusSlide,User user,topic topic,Category category);
	
	Boolean updateGraphics(String graphicsUpload, int graphicsUploadStatus,User user,topic topic,Category category);

	Boolean updateScript(String scriptUpload, int statusScript,User user,topic topic,Category category);

	Boolean updateVideo(String videoUpload, int statusVideo,User user,topic topic,Category category);
	
	Boolean updateVideoStatusByAdmin(int StatusByAdmin,topic topic,Category category,language language);
	
	// Domain Accept Or Need To Improvement
	
	Boolean updateOutlineStatusByDomain(int outlineStautusByDomain,topic topic,Category category,language language);
	
	Boolean updateScriptStatusByDomain(int scriptStautusByDomain,topic topic,Category category,language language);
	
	// Quality review Or need To Improvements
	
	Boolean updateOutLineStatusByQuality(int scriptStautusByQuality,topic topic,Category category,language language);
	
	Boolean upadateSlideStatusByQuality(int scriptStautusByQuality,topic topic,Category category,language language);
	
	Boolean upadateScriptStatusByQuality(int scriptStautusByQuality,topic topic,Category category,language language);
	
	Boolean upadateKeywordByQuality(int scriptStautusByQuality,topic topic,Category category,language language);
	
	Boolean upadateVideoByQuality(int videoStautusByQuality,topic topic,Category category,language language);
	
	// here is code for upadet Status when click as public
	
	Boolean updateStatusByQualityApprove(int StatusApprove,int IdByrecord);
	
	
}
