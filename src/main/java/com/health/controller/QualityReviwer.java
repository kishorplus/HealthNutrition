package com.health.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.Category;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.commentOnComponent;
import com.health.model.language;
import com.health.model.topic;
import com.health.repository.CategoryDao;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.commentOnComponentDao;
import com.health.repository.languagedao;
import com.health.repository.topicRepositary;
import com.health.service.tutorialService;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Controller
public class QualityReviwer 
{

	public static final String RECORD_SAVED_SUCCESS_MSG = "Record Saved Successfully !" ;
	public static final String DOMAIN_REV_STATUS_MSG = "Waiting for Domain Review" ;
	public static final String ADMIN_REV_STATUS_MSG = "Waiting for Admin Review" ;
	public static final String QUALITY_REV_STATUS_MSG = "Waiting for Quality Review" ;
	public static final String WAITING_PUBLISH_MSG = "Waiting to be published" ;
	public static final String NEED_IMPROVEMENT_MSG = "Need for improvement";
	
	@Autowired
	private TutorialDao tutorialdao;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private topicRepositary topicRepositary;
	
	@Autowired
	private  CategoryDao categoryDao;
	
	@Autowired
	private  tutorialService tutorialService;
	
	@Autowired
	private languagedao languageDao;
	
	@Autowired
	private commentOnComponentDao commentOnComponentDao; 
	
	// Here is code for review Componenet  

		@RequestMapping("/listQualityReviewrTutorial")
		public String listTutorialss(Model model) 
		{
		 
			List<Tutorial> tutorilal=(List<Tutorial>) tutorialdao.findAll();
	
		 	model.addAttribute("QualityReviwerList",tutorilal);
		 	
		 	return "listTutorialQualityReviwer";
		 	
		}
		
		// Here is code for mark as public	
		@RequestMapping("/listQualityMarkAsPublicReviewTutorial")
		public String markAsPubliscReview(Model model) 
		{
			
		List<Tutorial> tutorial=(List<Tutorial>)tutorialdao.findByIdStausForApprove();
		
		/*
		 * List<Tutorial> tutorial=(List<Tutorial>) tutorialdao.findAll();
		 */	
			model.addAttribute("QualityReviwerList",tutorial);
		 	
		 	return "listTutorialPublishQualityReviwer";
		 	
		}

		@RequestMapping("qualityComponenettutorial/publish/{id}") 
		public String publishTutotril(Model model,@PathVariable Integer id)
		{
			 
		 	
			Tutorial tutorial=tutorialdao.findOne(id);
			
			int statusApprove=1;
			
			tutorialService.updateStatusByQualityApprove(statusApprove,id);
		
			Tutorial  ApproveStatu=tutorialdao.findOne(id);
			
				/*
				 * if (ApproveStatu.getStatus()==1) {
				 * 
				 * model.addAttribute("approvStatus",true);
				 * 
				 * }
				 */	
			model.addAttribute("approve",ApproveStatu);
			
			model.addAttribute("msgSuccess", "Publish Tutorial successfully");
			
			
		 	return "listTutorialPublishQualityReviwer";
		 	
		 	
		}
		
		// Here is code already code review  Quality
	
		@RequestMapping("/qualityreviewByQuality") 
		public String alreadyReview(Model model)
		{
			
			List<Tutorial> tutorial=tutorialdao.findByTutorialQualityReview();
			
			
			model.addAttribute("QualityReviwerList", tutorial);
		    
		    return "listQualityReviwerAlreadyReview";
		    
		   
		}
		
	
		@RequestMapping("qualityComponenettutorial/review/{id}")  
		public String qualityeReview(Model model,@PathVariable Integer id)
		{
			
			
			Tutorial tutorial=tutorialdao.findOne(id);
		

			if(tutorial.getOutlineStatus()==0)
			{		
				model.addAttribute("statusOutline","Pending");

			}	
			else if(tutorial.getOutlineStatus()==1)
			{ 
				
				model.addAttribute("statusOutline",DOMAIN_REV_STATUS_MSG);
			
			
			}else if (tutorial.getOutlineStatus()==3) 
			{
				
				model.addAttribute("statusOutline",QUALITY_REV_STATUS_MSG);
				model.addAttribute("statusOutlineTrue",true);
				
				
			}else if (tutorial.getOutlineStatus()==5) {
				
				model.addAttribute("statusOutline",NEED_IMPROVEMENT_MSG);
				
			}else if(tutorial.getOutlineStatus()==4) {
				
				model.addAttribute("statusOutline",WAITING_PUBLISH_MSG);
			}
			
			
			
		/* outline */	
			
			if(tutorial.getScriptStatus()==0) 
			{
				
				model.addAttribute("statusScript", "Pending");
				

			}else if (tutorial.getScriptStatus()==1) 								
			{

				model.addAttribute("statusScript",DOMAIN_REV_STATUS_MSG);
			
				
			}else if (tutorial.getScriptStatus()==3){
				
				model.addAttribute("statusScript",QUALITY_REV_STATUS_MSG);
				model.addAttribute("statusScriptTrue", true);
				
			
			}else if (tutorial.getScriptStatus()==4) {
				
				model.addAttribute("statusScript",WAITING_PUBLISH_MSG);
				
			}
			
			
			else if (tutorial.getScriptStatus()==5) 
			{
				
				model.addAttribute("statusScript",NEED_IMPROVEMENT_MSG);
				
			}
			
		/* script */	
			
			if(tutorial.getSlideStatus()==0) 
			{
				
				model.addAttribute("statusSlide", "Pending");

			}
			
			else if (tutorial.getSlideStatus()==1)
			{
				
				model.addAttribute("statusSlide",DOMAIN_REV_STATUS_MSG);
			
			}
			else if (tutorial.getSlideStatus()==3)
			{
				
				model.addAttribute("statusSlide",QUALITY_REV_STATUS_MSG);
				model.addAttribute("statusSlideTrue", true);
				
			}
			
			else if (tutorial.getSlideStatus()==4)
			{	
				
				model.addAttribute("statusSlide",WAITING_PUBLISH_MSG);
			
			}
			
			else if (tutorial.getSlideStatus()==5) {
				
				model.addAttribute("statusSlide",NEED_IMPROVEMENT_MSG);
				
			}
			
		/* slide */
			
			
			if(tutorial.getVideoStatus()==0) 
			{
				
				model.addAttribute("statusVideo", "Pending");

			}else if (tutorial.getVideoStatus()==2) 		
			{

				model.addAttribute("statusVideo",DOMAIN_REV_STATUS_MSG);
			
			}
			else if (tutorial.getVideoStatus()==1){
				
				
				model.addAttribute("statusVideo",ADMIN_REV_STATUS_MSG);

				
			}else if (tutorial.getVideoStatus()==3){
				
				model.addAttribute("statusVideo",QUALITY_REV_STATUS_MSG);
				model.addAttribute("statusVideoTrue", true);
				
				
			}else if (tutorial.getVideoStatus()==4) {
				
				model.addAttribute("statusVideo","Waiting For Publish");
				
				
			}
			
			
			else if (tutorial.getVideoStatus()==5) {
				
				
				model.addAttribute("statusVideo",NEED_IMPROVEMENT_MSG);
			}
			
			
		/* video */	
		
			if (tutorial.getKeywordStatusSet()==0) 
			{
				
				model.addAttribute("statusKeyword","Pending");
				
			}
			
			else if(tutorial.getKeywordStatusSet()==1)
			{
				
				model.addAttribute("statusKeyword",DOMAIN_REV_STATUS_MSG);
							
			
			}
			
			else if (tutorial.getKeywordStatusSet()==3){
				
				model.addAttribute("statusKeyword",QUALITY_REV_STATUS_MSG);
				model.addAttribute("statusKeywordTrue",true);
				
				
			}
			
			
			else if (tutorial.getKeywordStatusSet()==4){
				
				model.addAttribute("statusKeyword",WAITING_PUBLISH_MSG);
				
			}else if(tutorial.getKeywordStatusSet()==5)
			{
				
				model.addAttribute("statusKeyword", NEED_IMPROVEMENT_MSG);
				
			}
			
			Tutorial tutorialobject=tutorialdao.findOne(tutorial.getTutorialid());
			
			List<commentOnComponent> commentComponent=(List<commentOnComponent>) commentOnComponentDao.findBytutorial_id(tutorialobject);	
							
			model.addAttribute("CommentMsg",commentComponent);
			
			
			model.addAttribute("tutorialComponenet",tutorial);	


			
			  return "addContentQualityReview"; 
		}
			 
		// here is code Quality reviwer code accept outline
		
		  @RequestMapping("/acceptOutlineByQuality")
		  public @ResponseBody List<String> needToImprovemenetByAdmin(@RequestParam(value = "categorname") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
		{
			  
			  
			  List<String> QualityStatusUpdate = new ArrayList<String>();
			  
			  User user=userRepository.findByUsername(authentication.getName());
			  
			  topic topic = topicRepositary.findBytopicname(topicid);		  
			  
			  Category category=categoryDao.findBycategoryname(categorname);
		
			  language language=languageDao.findBylanguageName(lanId);
		  
			  //Admin set to need to improvement
			
			  int QualittyStatus=4;
			  
			  tutorialService.updateOutLineStatusByQuality(QualittyStatus,topic, category,language);
			 
			 
			  QualityStatusUpdate.add("Outline Status Update  successfully");
			  
			  return QualityStatusUpdate;

		}
		  
		// here is code Quality reviwer code need to Improvements outline
		
			  @RequestMapping("/needToImprovementOutLineByQuality")
			  public @ResponseBody List<String> needToImprovementsOutlineByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "msg") String msgComment,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  
				  List<String> outlineQuality = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
				  
				  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
				  
				  
				  int QualityStatus=5;
				  
				  String outline="Outline";
				  
				  
				  tutorialService.updateOutLineStatusByQuality(QualityStatus, topic, category,language);
				  
			
					java.util.Date dt = new java.util.Date();
					java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					
					String currentTime = sdf.format(dt);
		
					commentOnComponent commentonComponet= new commentOnComponent();
					
							 commentonComponet.setUser(user);
							 commentonComponet.setTopic(topic);
							 commentonComponet.setLanguage(language);
							 commentonComponet.setCategory(category);
							 commentonComponet.setTutorial(tutorial);
							 commentonComponet.setCommentdate(currentTime);
							 commentonComponet.setCommentInfo(msgComment);
							 
							 commentonComponet.setComponenenetDeatail(outline);
							 					 
							 commentOnComponentDao.save(commentonComponet);	 
				  
							 outlineQuality.add("Outline Status Update  successfully");
				 
				  return outlineQuality;

			}
			  
			  // Here is code for View Slide
			  
				@RequestMapping("/slidePdfQuality")
				 public @ResponseBody List<String> viewScriptPdfDomain
				 (
						  @RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
				 {

					  List<String> slide = new ArrayList<String>();
					  
					  User user=userRepository.findByUsername(authentication.getName());
					  
					  topic topic = topicRepositary.findBytopicname(topicid);		  
					  
					  Category category=categoryDao.findBycategoryname(categorname);
				
					  language language=languageDao.findBylanguageName(lanId);
				
					  int status = 1;
					 
					  Tutorial tutorial=tutorialdao.finByKeywordContentDomain(topic,category,language);
					  
					  
					  slide.add(tutorial.getSlide());
					
					return slide;
					
					 
			}  
			//Here Is code for Accept Slide 
				
				  @RequestMapping("/acceptSlideByQuality")
				  public @ResponseBody List<String> acceptSlide(@RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
				{
				
					  System.err.println("Welcome to print");
					  
					  List<String> slideStatusByQuality = new ArrayList<String>();
					  
					  User user=userRepository.findByUsername(authentication.getName());
					  
					  topic topic = topicRepositary.findBytopicname(topicid);		  
					  
					  Category category=categoryDao.findBycategoryname(categorname);
				
					  language language=languageDao.findBylanguageName(lanId);
				  
					  //Admin set to need to improvement
					
					  int QualittyStatus=4;
					  
					  tutorialService.upadateSlideStatusByQuality(QualittyStatus,topic, category,language);
					 
					  slideStatusByQuality.add("Slide Status Update  successfully");
					  
					  return slideStatusByQuality;

				}
				  
		// Here is code for need To improvement
				  
				  @RequestMapping("/needToImprovementSlideByQuality")
				  public @ResponseBody List<String> needToImprovementsSlideByQuality(@RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "msg") String msgComment,
						  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
		{
					
					  
					  
					  
					  List<String> slideQuality = new ArrayList<String>();
					  
					  User user=userRepository.findByUsername(authentication.getName());
					  
					  topic topic = topicRepositary.findBytopicname(topicid);		  
					  
					  Category category=categoryDao.findBycategoryname(categorname);
				
					  language language=languageDao.findBylanguageName(lanId);
					  
					  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
					  
					  int QualityStatus=5;
					  
			
					  
					  tutorialService.upadateSlideStatusByQuality(QualityStatus,topic, category,language);
					  
				
						java.util.Date dt = new java.util.Date();
						java.text.SimpleDateFormat sdf = 
						     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

						String currentTime = sdf.format(dt);
			
						  String Slide="Slide";
						commentOnComponent commentonComponet= new commentOnComponent();
					
								 commentonComponet.setUser(user);
								 commentonComponet.setTopic(topic);
								 commentonComponet.setLanguage(language);
								 commentonComponet.setCategory(category);
								 commentonComponet.setTutorial(tutorial);
								 commentonComponet.setCommentdate(currentTime);
								 commentonComponet.setCommentInfo(msgComment);
								 
								 commentonComponet.setComponenenetDeatail(Slide);
								 					 
								 commentOnComponentDao.save(commentonComponet);	 
					  
								 slideQuality.add("Slide Status Update  successfully");
					 
					
					  return slideQuality;
	
		}
				
		// here is code for Comment On Script on Quality Side
				  
				  @RequestMapping("/commentOnScriptByQuality")
				  public @ResponseBody List<String> acceptScriptByDomain(@RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "lanId") String lanId,
						  Model model,Authentication authentication)	  
				{
					 
					  List<String> scriptQuality = new ArrayList<String>();
					  
					  User user=userRepository.findByUsername(authentication.getName());
					  
					  topic topic = topicRepositary.findBytopicname(topicid);		  
					  
					  Category category=categoryDao.findBycategoryname(categorname);
				
					  language language=languageDao.findBylanguageName(lanId);
				      
					  int QualityStatus=4;
						 
					  tutorialService.upadateScriptStatusByQuality(QualityStatus, topic, category,language);
					 
					  scriptQuality.add("Script Status Update  successfully");
					  
					  return scriptQuality;
					  

				}
				  
				  
				  
		// here is code for Comment On Script  need To Improvement  Quality Side	  
		
				  
				  
				  @RequestMapping("/needToImpScriptByQuality")
				  public @ResponseBody List<String> needToImprovementsScriptByDomain(@RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "msgScript") String msgComment,
						  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
				{
					
					  
		
					  System.err.println(NEED_IMPROVEMENT_MSG);
					  
					  List<String> scriptQuality = new ArrayList<String>();
					  
					  User user=userRepository.findByUsername(authentication.getName());
					  
					  
					  topic topic = topicRepositary.findBytopicname(topicid);		  
					  
					  Category category=categoryDao.findBycategoryname(categorname);
				
					  language language=languageDao.findBylanguageName(lanId);
					  
					  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
					  
					  int QualityStatus=5;
				
					  tutorialService.upadateScriptStatusByQuality(QualityStatus, topic, category,language);
					  
					  String Script="Script";
				
						java.util.Date dt = new java.util.Date();
						java.text.SimpleDateFormat sdf = 
						     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

						String currentTime = sdf.format(dt);
						
			
						commentOnComponent commentonComponet= new commentOnComponent();
					 
								 commentonComponet.setUser(user);
								 commentonComponet.setTopic(topic);
								 commentonComponet.setLanguage(language);
								 commentonComponet.setCategory(category);
								 commentonComponet.setTutorial(tutorial);
								 commentonComponet.setCommentdate(currentTime);
								 commentonComponet.setCommentInfo(msgComment);
								 
								 commentonComponet.setComponenenetDeatail(Script);
								 					 
								 commentOnComponentDao.save(commentonComponet);
					  
								 scriptQuality.add("Script Status Update  successfully");
								 
								 
					 
					  return scriptQuality;

				}
				  
				
				//here is code for Quality review	on KeyWord		  
					
				  @RequestMapping("/acceptKeywordByQuality")
				  public @ResponseBody List<String> acceptKeywordByQuality(@RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
				{
				
					 System.err.println("Prient recored");
					  
					 List<String> ScriptStatusByQuality = new ArrayList<String>();
					  
					  
					  topic topic = topicRepositary.findBytopicname(topicid);		  
					  
					  Category category=categoryDao.findBycategoryname(categorname);
				
					  language language=languageDao.findBylanguageName(lanId);
				  
					  //Admin set to need to improvement
					
					  int QualittyStatus=4;
					
					  tutorialService.upadateKeywordByQuality(QualittyStatus,topic, category,language);
					 
					  ScriptStatusByQuality.add("KeyWord Status Update  successfully");
					  
					  return ScriptStatusByQuality;

				}
				  
				  
				  
				  
				  
			//Here is code for Quality review on Need To Improvement
				  
				  
				  @RequestMapping("/needToImprovementKeywordByQuality")
				  public @ResponseBody List<String> needToImprovementKeywordByQuality(@RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "msg") String msgComment,
						  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
					  
			
		
					  List<String> keywordQuality = new ArrayList<String>();
					  
					  User user=userRepository.findByUsername(authentication.getName());
					  
					  
					  topic topic = topicRepositary.findBytopicname(topicid);		  
					  
					  Category category=categoryDao.findBycategoryname(categorname);
				
					  language language=languageDao.findBylanguageName(lanId);
					  
					  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
					  
					  int QualityStatus=5;
				
					  tutorialService.upadateKeywordByQuality(QualityStatus,topic, category,language);
					  
					  String Keyword="keyword";
				
						java.util.Date dt = new java.util.Date();
						java.text.SimpleDateFormat sdf = 
						     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

						String currentTime = sdf.format(dt);
						
			
						commentOnComponent commentonComponet= new commentOnComponent();
					 
								 commentonComponet.setUser(user);
								 commentonComponet.setTopic(topic);
								 commentonComponet.setLanguage(language);
								 commentonComponet.setCategory(category);
								 commentonComponet.setTutorial(tutorial);
								 commentonComponet.setCommentdate(currentTime);
								 commentonComponet.setCommentInfo(msgComment);
								 commentonComponet.setComponenenetDeatail(Keyword);
								 					 
								 commentOnComponentDao.save(commentonComponet);
					  
								 keywordQuality.add("Keyword Status Update  successfully");
								
								 
								 
					  return keywordQuality;

				}
				  
				    
				 //Here is code for View keyword information  
				  
					@RequestMapping("/viewKeywordInQuality")
					  public @ResponseBody List<String>
					  viewKeywordContentQuality(
							  @RequestParam(value = "categorname") String categorname,
							  @RequestParam(value = "topicid") String topicid,
							  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
					 {
						
						
							
						  List<String> topicName = new ArrayList<String>();
						  
						 // User user=userRepository.findByUsername(authentication.getName());
						  
						  topic topic = topicRepositary.findBytopicname(topicid);		  
						  
						  Category category=categoryDao.findBycategoryname(categorname);
					
						  language language=languageDao.findBylanguageName(lanId);
						  
					
						  int status = 1;
						  
						  Tutorial tutorial=tutorialdao.findByKeywordInQuality(topic,category,language);
						
						  topicName.add(tutorial.getKeyword());
						  
						  
						return topicName;
						  
					 }		
			
				//Accept Video By Quality
					
					  @RequestMapping("/acceptVideoByQuality")
					  public @ResponseBody List<String> acceptVideoByQuality(@RequestParam(value = "categorname") String categorname,
							  @RequestParam(value = "topicid") String topicid,
							  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
					{
					
						  
						  List<String> slideStatusByQuality = new ArrayList<String>();
						  
						  User user=userRepository.findByUsername(authentication.getName());
						  
						  topic topic = topicRepositary.findBytopicname(topicid);		  
						  
						  Category category=categoryDao.findBycategoryname(categorname);
					
						  language language=languageDao.findBylanguageName(lanId);
					  
						  //Admin set to need to improvement
						
						  int QualittyStatus=4;
						  
						  tutorialService.upadateVideoByQuality(QualittyStatus,topic, category,language);
						  
						  slideStatusByQuality.add("Video Status Update  successfully");
						  
						  return slideStatusByQuality;

					}	
					
					
					
	
}
