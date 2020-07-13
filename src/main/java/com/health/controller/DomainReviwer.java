package com.health.controller;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.groovy.ast.stmt.IfStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Testimonial;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.commentOnComponent;
import com.health.model.language;
import com.health.model.topic;
import com.health.repository.CategoryDao;
import com.health.repository.RoleRepository;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.repository.commentOnComponentDao;
import com.health.repository.languagedao;
import com.health.repository.topicRepositary;
import com.health.service.languageService;
import com.health.service.tutorialService;

import ch.qos.logback.core.joran.conditional.IfAction;

@Controller
public class DomainReviwer {
	
	
	@Autowired
	private UserRoleRepositary UserRoleRepositary;
	
	@Autowired
	private TutorialDao tutorialdao;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private topicRepositary topicRepositaryDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private languagedao languageDao;
	
	@Autowired
	private TutorialDao tutorialDao;
	
	@Autowired
	private commentOnComponentDao commentOnComponentDao;
	
	@Autowired
	private topicRepositary topicRepositary;
	
	@Autowired
	private tutorialService tutorialService;
	
	
	@Autowired
	private RoleRepository RoleRepository;
	
	
			@RequestMapping("/listDomainReviewrTutorial")
			public String listTutorials(Model model,Authentication Authentication) 
			{
			
			 User user=userRepository.findByUsername(Authentication.getName());
		
		/*
		 * Role role=RoleRepository.findOne(3);
		 * 
		 * UserRole userRole= UserRoleRepositary.findByuserAndRoles(user, role);
		 */
		    
		//List<Tutorial> tutorial=(List<Tutorial>) tutorialdao.findByLan(user.get);
            

			 List<Tutorial> tutorial=(List<Tutorial>) tutorialdao.findAll();
            	 
	
		  //List<Tutorial> tutorial=(List<Tutorial>) tutorialdao.findByOutlineScriptVideo(outlineStatus,scriptStatus,videoStatus);
		
			model.addAttribute("DomainLisTutorias",tutorial);
			
			
			return "listTutorialDomainReview";
			
				
		}
	
			@RequestMapping("componenettutorial/review/{id}")
			public String componenettutorialReview(@PathVariable Integer id, Model model,HttpServletRequest req) 
			{	
				
				
							Tutorial tutorial=tutorialdao.findOne(id);

							
								if(tutorial.getOutlineStatus()==0)
								{		
									model.addAttribute("statusOutline","Pending");
	
								}	
								else if(tutorial.getOutlineStatus()==1)
								{ 
									
									model.addAttribute("statusOutline","Wating for Domain Review");
									model.addAttribute("statusOutlineTrue",true);
									
								
								}else if (tutorial.getOutlineStatus()==3){
									
									model.addAttribute("statusOutline","Waiting for Quality Review");
									
									
								}else if (tutorial.getOutlineStatus()==5) {
									
									model.addAttribute("statusOutline","Need To Improvement");
									
								}	
								
								else if (tutorial.getOutlineStatus()==4) {
									
									model.addAttribute("statusOutline","Waiting For Publish");
									
								}	
								
							
								
		/* Keyword */
								
								
								if(tutorial.getKeywordStatusSet()==0) 
								{
									
									model.addAttribute("statusKeyword", "Pending");
	
								}else if (tutorial.getKeywordStatusSet()==1) 				  

								{

									model.addAttribute("statusKeyword","Wating for Domain Review");
									model.addAttribute("statusKeywordTrue", true);
									
								}
								else if (tutorial.getKeywordStatusSet()==3) 
								{

										model.addAttribute("statusKeyword","Wating for Quality Review");
										
								}
								else if (tutorial.getKeywordStatusSet()==4) 
								{
								
									model.addAttribute("statusKeyword","Wating for Publish");
							
								}
								else if (tutorial.getKeywordStatusSet()==5) 
								{
								
									model.addAttribute("statusKeyword","Need To Improvement");
							
								}

								
				/* outline */		
								
								if(tutorial.getScriptStatus()==0) 
								{
									
									model.addAttribute("statusScript", "Pending");
									
								}else if (tutorial.getScriptStatus()==1) 								
								{

									model.addAttribute("statusScript","Wating for Domain Review");
									model.addAttribute("statusScriptTrue", true);
									
								}else if (tutorial.getScriptStatus()==3)
								{
									
									model.addAttribute("statusScript","Waiting For Quality Review");

								}
								else if (tutorial.getScriptStatus()==4) 
								{
									
										model.addAttribute("statusScript","Waiting for Publish");
								}
								
								else if(tutorial.getScriptStatus()==5)
								{
									
									model.addAttribute("statusScript","Need To Improvement");
								
									
								}
								
								
		/* slide */					
								
								if(tutorial.getSlideStatus()==0) 
								{
									
									model.addAttribute("statusSlide", "Pending");
	
								}else if (tutorial.getSlideStatus()==1) 				  

								
								{

									model.addAttribute("statusSlide","Wating for Domain Review");
									model.addAttribute("statsuSlideTrue", true);
									
								}
								else if (tutorial.getSlideStatus()==3) 
								{

										model.addAttribute("statusSlide","Wating for Quality Review");
										
								}else if (tutorial.getSlideStatus()==5) 
								{
								
									model.addAttribute("statusSlide","Need To Improvement");
							
								}
								else if (tutorial.getSlideStatus()==4) 
								{
								
									model.addAttribute("statusSlide","Wating for Publish");
							
								}
								
								
								
								if(tutorial.getVideoStatus()==0) 
								{
									
									model.addAttribute("statusVideo", "Pending");
	
								}
								else if (tutorial.getVideoStatus()==2) 
								
								{

									model.addAttribute("statusVideo","Wating for Domain Review");
									model.addAttribute("statusVideoTrue", true);
									
								}
								else if (tutorial.getVideoStatus()==1){
									
									
									model.addAttribute("statusVideo","Wating for Admin Review");
									
									
								}else if (tutorial.getVideoStatus()==3){
									
									model.addAttribute("statusVideo","Wating for Quality  Review");
									
								} else if (tutorial.getVideoStatus()==5) {
									
									
									model.addAttribute("statusVideo","Need To Improvement");
									
								}else if(tutorial.getVideoStatus()==4) {
									
									
									model.addAttribute("statusVideo","Waiting For Publish");
									
								}
								
				
			// here is code domain reviwer write comments
								
				Tutorial tutorialobject=tutorialDao.findOne(tutorial.getTutorialid());
									
					List<commentOnComponent> commentComponent=(List<commentOnComponent>) commentOnComponentDao.findBytutorial_id(tutorialobject);	
									
					model.addAttribute("CommentMsg",commentComponent);
									
						
					model.addAttribute("tutorialComponenet",tutorial);	
								
		
					return "addContentDomainReview";
					

	}
			
			/*
			 * Domain View for outline View
			 */
			
			@RequestMapping("/outlineViewDomain")
			  public @ResponseBody List<String>
			  viewOutlineContentDomain(
					  @RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
			 {

				  List<String> videoframe = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositaryDao.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			
				  int status = 1;
				 
			  
				  Tutorial tutorial=tutorialDao.finByKeywordContentDomain(topic,category,language);
				  
				  System.err.println("Outline is	"+tutorial.getOutlin());
				
				  videoframe.add(tutorial.getOutlin());
				  
				   
				return videoframe;
				  
			 }
			
			/*
			 * Domain View for Script View
			 */	
			
			
			@RequestMapping("/scriptPdfDomain")
			 public @ResponseBody List<String> viewScriptPdfDomain
			 (
					  @RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
			 {

				  List<String> script = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositaryDao.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			
				  int status = 1;
				 
				  Tutorial tutorial=tutorialDao.finByKeywordContentDomain(topic,category,language);
				  
				  script.add(tutorial.getScript());
				  
				
				return script;
				  
			}
			
			
			
			
			/*
			 * Domain View for Video View
			 */
			
			
			@RequestMapping("/viewVideoDomain")
			  public @ResponseBody List<String>
			  viewVideoContentDomain(
					  @RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
			 {
		  	  
				  System.err.println(categorname+""+topicid+""+lanId);
				
				  List<String> videoframe = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositaryDao.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			
				  int status = 1;
				
				  Tutorial tutorial=tutorialDao.finByKeywordContentDomain(topic,category, language);
				
				  videoframe.add(tutorial.getVideo());
				 
				   
				return videoframe;  		  
	}
			
				/* Comment on componenet outline*/
			
			@RequestMapping("/commentOnOutline")
			  public @ResponseBody List<String>
			  commentOnComponenet(
					  @RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,
					  @RequestParam(value = "commentOutlineMsg") String msgCommentOutline,Authentication authentication)		  
			 {

				System.err.println("hi");
				
				  List<String> CommentOnOutline = new ArrayList<String>();
				  
				  System.err.println("c1"+categorname+"c2"+topicid+"c3"+lanId); 
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositaryDao.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			
				  int status = 1;
				 
				 Tutorial tutorial=tutorialDao.finByKeywordContentDomain(topic,category,language);
				
				  
				  //CommentOnOutline.add(tutorial.getScript());
				  
					java.util.Date dt = new java.util.Date();
					java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-d				  \n" + 
					     		"d HH:mm:ss");

					String currentTime = sdf.format(dt);

					commentOnComponent commentOnComponenet=new commentOnComponent();
			
			
					 commentOnComponenet.setCommentdate(currentTime);
					 commentOnComponenet.setCommentInfo(msgCommentOutline);			 
					 commentOnComponenet.setUser(user);
					 commentOnComponenet.setCategory(category);
					 commentOnComponenet.setTopic(topic);
					 commentOnComponenet.setLanguage(language);
			
				 commentOnComponentDao.save(commentOnComponenet);
				 
				 
 
				 CommentOnOutline.add("Save Recored succefully");
				 
				  
				return CommentOnOutline;
				  
			}
			
	/* comment on script */
		
			
			
			@RequestMapping("/acommentOnScript")
			  public @ResponseBody List<String>
			  commentOnComponenetScript(
					  @RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,
					  @RequestParam(value = "msgScript") String msgCommentOutline,Authentication authentication)		  
		 {
				
				
				
				  List<String> CommentOnOutline = new ArrayList<String>();
		
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositaryDao.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			
				  int status = 1;
				 
				 Tutorial tutorial=tutorialDao.finByKeywordContentDomain(topic,category,language);
				
				  
				  //CommentOnOutline.add(tutorial.getScript());
				  
					java.util.Date dt = new java.util.Date();
					java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					String currentTime = sdf.format(dt);

					commentOnComponent commentOnComponenet=new commentOnComponent();
				  
					
					
					 commentOnComponenet.setCommentdate(currentTime);
					 commentOnComponenet.setCommentInfo(msgCommentOutline);			 
					 commentOnComponenet.setUser(user);
					 commentOnComponenet.setCategory(category);
					 commentOnComponenet.setTopic(topic);
					 commentOnComponenet.setLanguage(language);
			
				 commentOnComponentDao.save(commentOnComponenet);
				 
				 
 
				 CommentOnOutline.add("Save Recored succesfully");
				 
				  
				return CommentOnOutline;
				  
			}
			
			
			
			//comment on video
			
			@RequestMapping("/commentOnVideo")
			  public @ResponseBody List<String>
			  commentOnComponenetVideo(
					  @RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,
					  @RequestParam(value = "videoCommentMsg") String msgCommentVideo,Authentication authentication)		  
		 {
				
				
				  List<String> CommentOnOutline = new ArrayList<String>();
		
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositaryDao.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			
				  int status = 1;
				 
				 Tutorial tutorial=tutorialDao.finByKeywordContentDomain(topic,category,language);
				
				  
				  //CommentOnOutline.add(tutorial.getScript());
				  
					java.util.Date dt = new java.util.Date();
					java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					String currentTime = sdf.format(dt);

					commentOnComponent commentOnComponenet=new commentOnComponent();
				  
					
					
					 commentOnComponenet.setCommentdate(currentTime);
					 commentOnComponenet.setCommentInfo(msgCommentVideo);			 
					 commentOnComponenet.setUser(user);
					 commentOnComponenet.setCategory(category);
					 commentOnComponenet.setTopic(topic);
					 commentOnComponenet.setLanguage(language);
			
				 commentOnComponentDao.save(commentOnComponenet);
				
				 CommentOnOutline.add("Save Recored succesfully");
				 
				  
				return CommentOnOutline;
				  
			}
			
			/* Here is code fro domain video accept */
			
			
			  @RequestMapping("/acceptVideoByDomain")
			  public @ResponseBody List<String> needToImprovemenetByAdmin(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  List<String> videoStatusUpdate = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			  
				  //Admin set to need to improvement
				  
				  int AdminStatus=3;
				  
				  tutorialService.updateVideoStatusByAdmin(AdminStatus, topic, category,language);
				  
				  videoStatusUpdate.add("Video Stauts Update  successfully");
				  
				  return videoStatusUpdate;

			}
			  
			// Here is code for accept slide 
			  
			  @RequestMapping("/acceptSlideByDomain")
			  public @ResponseBody List<String> acceptSlideByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  List<String> videoStatusUpdate = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			  
				  //Admin set to need to improvement
				  
				  int AdminStatus=3;
				  
				  tutorialService.upadateSlideStatusByQuality(AdminStatus, topic, category,language);
				  
				  videoStatusUpdate.add("Slide Stauts Update  successfully");
				  
				  return videoStatusUpdate;

			}
			  
			  //End
			  
			  
			  
			
			  
				 //Here is code for View keyword information  
			  
				@RequestMapping("/viewKeywordInDomain")
				  public @ResponseBody List<String>
				  viewKeywordContentQuality(
						  @RequestParam(value = "categorname") String categorname,
						  @RequestParam(value = "topicid") String topicid,
						  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
				 {
						
					System.err.println("Print message");
					
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
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  @RequestMapping("/needToImprovemenetByDomain")
			  public @ResponseBody List<String> needToImprovemenetByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
			
				  List<String> videoStatusUpdate = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			  
				  //Admin set to need to improvement
				  
				  int DomainStatus=5;
				  
				  tutorialService.updateVideoStatusByAdmin(DomainStatus, topic, category,language);
				  
				  videoStatusUpdate.add("Video Status Update  successfully");
				  
				  return videoStatusUpdate;

			}
			  
			 // code for outline status into Domain  
				
			  @RequestMapping("/acceptOutlineByDomain")
			  public @ResponseBody List<String> acceptOutlineByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  List<String> outlineDomain = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			  
			  
				  int DomainStatus=3;
				  
				  tutorialService.updateOutlineStatusByDomain(DomainStatus, topic, category,language);
				  
				  outlineDomain.add("Outline Status Update  successfully");
				  
				  return outlineDomain;

			}
			  
			  @RequestMapping("/needToImpOutlineByDomain")
			  public @ResponseBody List<String> needToImprovementsOutlineByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "msg") String msgComment,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  List<String> outlineDomain = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
				  
				  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
				  
				  int DomainStatus=5;
				  
				  
				  String outline="Outline";
				  tutorialService.updateOutlineStatusByDomain(DomainStatus, topic, category,language);
			
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
				  
				  
				 outlineDomain.add("Outline Status Update  successfully");
				 
				  
				  return outlineDomain;

			}
			  
			  // here is code for accept or need to improvement

			  
				 // code for keyword status into Domain  
				
			  @RequestMapping("/acceptkeywordByDomain")
			  public @ResponseBody List<String> acceptkeywordByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  List<String> keywordDomain = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			  
			  
				  int DomainStatus=3;
				  
				  tutorialService.upadateKeywordByQuality(DomainStatus, topic, category,language);
				  
				  keywordDomain.add("Keyword Accept By Domain");
				  
				  return keywordDomain;

			}
			  
			  //need to imp for Domain
			  
			  @RequestMapping("/needToImpKeywordByDomain")
			  public @ResponseBody List<String> needToImpKeywordByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "msg") String msgComment,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  List<String> outlineDomain = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
				  
				  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
				  
				  int DomainStatus=5;
				  
				  
				  String keyword="keyword";
				  tutorialService.upadateKeywordByQuality(DomainStatus, topic, category,language);
			
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
							 
							 commentonComponet.setComponenenetDeatail(keyword);
							 					 
							 commentOnComponentDao.save(commentonComponet);
				  
				  
				 outlineDomain.add("Keyword Status Update  successfully");
				 
				  
				  return outlineDomain;

			}
			  
			 
			  //here is code Accept script for domain review
			  
			  @RequestMapping("/commentOnScript")
			  public @ResponseBody List<String> acceptScriptByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "lanId") String lanId,
					  Model model,Authentication authentication)	  
			{
				  
				  
				  List<String> outlineDomain = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
			    
				  int DomainStatus=3;
				  
					 
				  tutorialService.updateScriptStatusByDomain(DomainStatus, topic, category,language);
					 
				  
				  outlineDomain.add("Script Status Update  successfully");
				  
				  return outlineDomain;

			}
			  
			  //here is code needTo improvement script for domain review  
			  
			  @RequestMapping("/needToImpScriptByDomain")
			  public @ResponseBody List<String> needToImprovementsScriptByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "msgScript") String msgComment,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  	System.err.println("Need To improvement");
				  
				  
				  List<String> scriptDomain = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
				  
				  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
				 
				  
				  
				  int DomainStatus=5;
				  
			
				  tutorialService.updateOutlineStatusByDomain(DomainStatus, topic, category,language);
				  
				  String outline="Outline";
			
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
				  
							 scriptDomain.add("Script Status Update  successfully");
							 
							 
				 
				  return scriptDomain;

			}
			  
			  
			  
  //Here is need to imp for Domain
			  
			  @RequestMapping("/needToImpSlideByDomain")
			  public @ResponseBody List<String> needToImpSlideByDomain(@RequestParam(value = "categorname") String categorname,
					  @RequestParam(value = "topicid") String topicid,
					  @RequestParam(value = "msg") String msgComment,
					  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)	  
			{
				
				  List<String> outlineDomain = new ArrayList<String>();
				  
				  User user=userRepository.findByUsername(authentication.getName());
				  
				  topic topic = topicRepositary.findBytopicname(topicid);		  
				  
				  Category category=categoryDao.findBycategoryname(categorname);
			
				  language language=languageDao.findBylanguageName(lanId);
				  
				  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
				  
				  int DomainStatus=5;
				  
				  
				  String keyword="Slide";
				  tutorialService.upadateSlideStatusByQuality(DomainStatus, topic, category,language);
			
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
							 
							 commentonComponet.setComponenenetDeatail(keyword);
							 					 
							 commentOnComponentDao.save(commentonComponet);
				  
				  
				 outlineDomain.add("Slide Status Update  successfully");
				 
				  
				  return outlineDomain;

			}

		  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			
			
			

	

}
