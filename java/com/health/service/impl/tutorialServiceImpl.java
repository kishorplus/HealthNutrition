package com.health.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.language;
import com.health.model.topic;
import com.health.repository.TutorialDao;
import com.health.service.tutorialService;

@Service
public class tutorialServiceImpl implements tutorialService {

	@Autowired
	private TutorialDao tutorialDao;
		
	@Override
	public List<Tutorial> findAll() {

		List<Tutorial> local = (List<Tutorial>) tutorialDao.findAll();

		return local;

	}
	
	@Transactional
	public Boolean updateKeyword(String keywordMessage,int status,User user,topic topic ,Category category) 
	{	
		
		int keywordfStatus=	tutorialDao.updateKeyword(keywordMessage,status,user,topic,category);
		
		if(keywordfStatus>0) 
		{
			return true;
			
		}else {
			return false;
		}
	}
	
	
	
	@Transactional
	public Boolean updateOutline(String outlineMessage, int status, User user, topic topic, Category category) {
		
		int outlineStatus=tutorialDao.updateOutline(outlineMessage,status,user,topic,category);
		
		if(outlineStatus>0) 
		{
			return true;
			
		}else {
			return false;
		}
	}

	@Transactional
	public Boolean updateSlide(String slideUpload, int statusSlide, User user, topic topic, Category category) 
	{
		
		int slideStatus=tutorialDao.updateSlide(slideUpload,statusSlide,user,topic,category);
			
		if(slideStatus>0) 
		{
			return true;
			
		}else {
			return false;
		}
	
	}

	@Transactional
	public Boolean updateScript(String scriptUpload, int scriptStatus, User user, topic topic, Category category)
	{
		
		int scriptSta=tutorialDao.updateScript(scriptUpload,scriptStatus,user,topic,category);
		
		if(scriptSta>0) 
		{
			return true;
			
		}else
		{
			return false;
		}
		
		
		
		
	}

	@Transactional
	public Boolean updateVideo(String videoUpload, int statusVideo, User user, topic topic, Category category)
	{
		int v=tutorialDao.updateVideo(videoUpload, statusVideo, user, topic, category);
		
		if(v>0)
		{	
			return true;
		}
		else {
			return false;
		}
		
	}

	//admin update status =2
	
	@Transactional
	public Boolean updateVideoStatusByAdmin(int StatusByAdmin,topic topic,Category category,language language)
	{

		int statusByAdmin=tutorialDao.updateVideoStatusByAdmin( StatusByAdmin, topic, category, language);
		
		if(statusByAdmin>0)
		{
			
			return true;
		}else {
			
			return false;
		}
			
		
	
	}
	
	
	
	@Transactional
	public Boolean updateOutlineStatusByDomain(int StatusByDomain,topic topic,Category category,language language)
	{

		int statusByAdmin=tutorialDao.updateOutlineStatusByDomain(StatusByDomain, topic, category, language);
		
		
		
		if(statusByAdmin>0)
		{
			
			return true;
		}else {
			
			return false;
		}
			
	
	}


	@Transactional
	public Boolean updateScriptStatusByDomain(int scriptStautusByDomain, topic topic, Category category,language language) 
	{
		int statusByDomain=tutorialDao.updateScriptStatusByDomain(scriptStautusByDomain, topic, category, language);
		

		if(statusByDomain>0)
		{
			
			return true;
		}else {
			
			return false;
		}
		
	}

	@Transactional
	public Boolean updateOutLineStatusByQuality(int scriptStautusByQuality, topic topic, Category category,language language)
	{

		int statusByQuality=tutorialDao.updateOutLineStatusByQuality(scriptStautusByQuality, topic, category, language);
		

		if(statusByQuality>0)
		{
			
			return true;
		}else {
			
			return false;
		}

	
	
	
	}

	@Transactional
	public Boolean upadateSlideStatusByQuality(int scriptStautusByQuality, topic topic, Category category,language language)
	{
			
		int statusByQualitSlide=tutorialDao.upadateSlideStatusByQuality(scriptStautusByQuality,topic,category,language);
		
		if(statusByQualitSlide>0)
		{
			
			return true;
		}else {
			
			return false;
		}

	}

	@Transactional
	public Boolean upadateScriptStatusByQuality(int scriptStautusByQuality, topic topic, Category category,language language)
	{
		
		int statusByQualitScript=tutorialDao.upadateScriptStatusByQuality(scriptStautusByQuality,topic,category,language);
		
		if(statusByQualitScript>0)
		{
			
			
			return true;
		}else {
			
			return false;
		}

	}

	@Transactional
	public Boolean upadateKeywordByQuality(int scriptStautusByQuality, topic topic, Category category,language language) 
	{
		
	  int statusByQuality=tutorialDao.upadateKeywordByQuality(scriptStautusByQuality,topic,category,language);
	
		if(statusByQuality>0)
		{
			
			
			return true;
		}else {
			
			return false;
		}
	}

	@Transactional
	public Boolean upadateVideoByQuality(int videoStautusByQuality, topic topic, Category category, language language) {
	
		
		  int statusByQuality=tutorialDao.upadateVideoByQuality(videoStautusByQuality,topic,category,language);
			
			if(statusByQuality>0)
			{
				
				
				return true;
			}else {
				
				return false;
			}
	}

	@Transactional
	public Boolean updateStatusByQualityApprove(int StatusApprove, int IdByrecord) {
	
		 int statusByQualityApprove=tutorialDao.updateStatusByQualityApprove(StatusApprove,IdByrecord);
		
				if(statusByQualityApprove>0)
				{
					
					return true;
				}else {
					
					return false;
				}
		
		
	}

	@Transactional
	public Boolean updateGraphics(String graphicsUpload, int graphicsUploadStatus, User user, topic topic,Category category) {
			
	
		
		  int statusByQgraphics=tutorialDao.updateGraphics(graphicsUpload,graphicsUploadStatus,user,topic,category);
		
			if(statusByQgraphics>0)
			{
				
				
				return true;
			}else {
				
				return false;
			}
	
	}


}
