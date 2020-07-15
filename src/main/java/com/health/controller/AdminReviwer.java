package com.health.controller;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.health.service.tutorialService;

@Controller
public class AdminReviwer 
{

	public static final String RECORD_SAVED_SUCCESS_MSG = "Record Saved Successfully !" ;
	public static final String DOMAIN_REV_STATUS_MSG = "Waiting for Domain Review" ;
	public static final String ADMIN_REV_STATUS_MSG = "Waiting for Admin Review" ;
	public static final String QUALITY_REV_STATUS_MSG = "Waiting for Quality Review" ;
	
	@Autowired
	private  TutorialDao tutorialdao;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private com.health.repository.topicRepositary topicRepositary;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired	
	private languagedao languageDao;
	
	@Autowired
	private tutorialService tutorialService;
	
	@Autowired
	private commentOnComponentDao commentOnComponentdao;
	
	
	@RequestMapping("/listTutorialAdminReviwer")
	public String listTutorialAdmin(Model model) 
	{	
		
		List<Tutorial> tutorial=(List<Tutorial>) tutorialdao.finByVideoStatus();

		model.addAttribute("AdminListTutorias",tutorial);
	
		return "listTutorialAdminReviwer";

		
	}
	
	@RequestMapping("/adminreview/review/{id}")
	public String componenettutorialReview(@PathVariable Integer id, Model model,HttpServletRequest req) 
	{	
		
					Tutorial tutorial=tutorialdao.findOne(id);

						if(tutorial.getOutlineStatus()==0)
						{		
							model.addAttribute("statusOutline","Pending");

						}	
						else if(tutorial.getOutlineStatus()==1)
						{ 
					
							model.addAttribute("statusOutline",DOMAIN_REV_STATUS_MSG);
							model.addAttribute("statusOutlineTrue",true);
						} 
						
					
						if(tutorial.getScriptStatus()==0) 
						{
							
							model.addAttribute("statusScript", "Pending");
							

						}else if (tutorial.getScriptStatus()==1) 								
						{

							model.addAttribute("statusScript",DOMAIN_REV_STATUS_MSG);
							model.addAttribute("statusScriptTrue", true);
							
						}
						
						if(tutorial.getSlideStatus()==0) 
						{
							
							model.addAttribute("statusSlide", "PelistTutorialAdminReviwernding");

						}else if (tutorial.getSlideStatus()==1) 
						
						{

							model.addAttribute("statusSlide",DOMAIN_REV_STATUS_MSG);
							model.addAttribute("statsuSlideTrue", true);
							
						}
						
						if(tutorial.getVideoStatus()==0) 
							
						{
							
							model.addAttribute("statusVideo", "Pending");

						}else if (tutorial.getVideoStatus()==1) 
						
						{

							model.addAttribute("statusVideo",ADMIN_REV_STATUS_MSG);
							model.addAttribute("statusVideoTrue", true);
							
						}else if (tutorial.getVideoStatus()==2){
							
							model.addAttribute("statusVideo",DOMAIN_REV_STATUS_MSG);
							
						}else if (tutorial.getVideoStatus()==3) {
							model.addAttribute("statusVideo",QUALITY_REV_STATUS_MSG);
							
						}else if (tutorial.getVideoStatus()==5)
						{
							
							model.addAttribute("statusVideo","Need To Improvemenet");
							
						}
					
						if(tutorial.getKeywordStatusSet()==0)
						{
							
							model.addAttribute("statusKeyword", "Pending");

						}else if (tutorial.getKeywordStatusSet()==1) 
						
						{
							model.addAttribute("statusKeyword",DOMAIN_REV_STATUS_MSG);	
							model.addAttribute("statusKeywordTrue", true);
						}
						
						
						
			
						
								model.addAttribute("tutorialComponenet",tutorial);
						
							return "addContentAdminReview";
							
		}
	
	
		@RequestMapping("/viewVideoAdmin")
	  public @ResponseBody List<String> viewVideoContentAdmin(@RequestParam(value = "categorname") String categorname,
			  @RequestParam(value = "topicid") String topicid,
			  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
			  
	 {
	    
		  List<String> videoframe = new ArrayList<String>();
		  
		  User user=userRepository.findByUsername(authentication.getName());
		  
		  topic topic = topicRepositary.findBytopicname(topicid);		  
		  
		  Category category=categoryDao.findBycategoryname(categorname);
	
		  language language=languageDao.findBylanguageName(lanId);
	
		  int status = 1;
		
		 Tutorial tutorial=tutorialdao.finByKeywordContentDomain(topic,category, language);
			
		  videoframe.add(tutorial.getVideo());
		   
		return videoframe;
		  
	 }
	/*
	 * here is code Video accept
	 */
		
		  @RequestMapping("/acceptAdminVideo")
		  public @ResponseBody List<String> acceptVideoReviewr(@RequestParam(value = "categorname") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
		  
		{
			  
			  List<String> videoStatusUpdate = new ArrayList<String>();
			  
			  User user=userRepository.findByUsername(authentication.getName());
			  
			  topic topic = topicRepositary.findBytopicname(topicid);		  
			  
			  Category category=categoryDao.findBycategoryname(categorname);
		
			  language language=languageDao.findBylanguageName(lanId);
		  
			  int AdminStatus=2;
			  
			  tutorialService.updateVideoStatusByAdmin(AdminStatus, topic, category,language);
			  
			  videoStatusUpdate.add("Video Status Update Succefully");
			  
			  return videoStatusUpdate;

		}
		  	/* here code need to improvements */
		  
		  @RequestMapping("/needToImprovemenetByAdmin")
		  public @ResponseBody List<String> needToImprovemenetByAdmin(@RequestParam(value = "categorname") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,
				  @RequestParam(value = "msg") String msgCommentVideo,
				  Authentication authentication)	  
		{
			  
			  String video="Video";
			
			  List<String> videoStatusUpdate = new ArrayList<String>();
			  
			  User user=userRepository.findByUsername(authentication.getName());
			  
		
			  topic topic = topicRepositary.findBytopicname(topicid);		  
			  
			  Category category=categoryDao.findBycategoryname(categorname);
		
			  language language=languageDao.findBylanguageName(lanId);
			  
			  Tutorial tutorial=tutorialdao.findByTutorialForComment(topic, category, language);
		
			  //Admin set to need to improvement
			  
			  int AdminStatus=5;
			  
			  tutorialService.updateVideoStatusByAdmin(AdminStatus, topic, category,language);
			 
			  
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
						 commentonComponet.setCommentInfo(msgCommentVideo);
						 commentonComponet.setComponenenetDeatail(video);
						
					
			   commentOnComponentdao.save(commentonComponet);
		
			  videoStatusUpdate.add("Video Stauts Update successfully");
			  
			  return videoStatusUpdate;

		}
		  
		 /* here is code admin review*/
		  
			@RequestMapping("/listAdminVideoAceeptOrNeToImp")
			public String listTutorialAdminreview(Model model) 
			{	
			
				
				List<Tutorial> tutorial=(List<Tutorial>) tutorialdao.findByVideoStatusByAdmin();
			
			

					for (Tutorial StatusVideo : tutorial) 
					{				
				//admin 2=approve 3=domain 5=Quality approve 
				
			
					if( StatusVideo.getVideoStatus()==5)
					{
										
											System.err.println("reject");
											model.addAttribute("statusVideoTrue","Reject");
									
					} 
					if(StatusVideo.getVideoStatus()==3 || StatusVideo.getVideoStatus()== 2 || StatusVideo.getVideoStatus()== 4)
					{
								
								
											System.err.println("Accept");			
											model.addAttribute("statusVideoTrue","Accept");
										
					} if(StatusVideo.getStatus()==0) {
							  
									  model.addAttribute("mainStatus","Pending");
									  
					 }else if(StatusVideo.getStatus()==1){
										  
									
									  model.addAttribute("mainStatus","Accept");
									  
									  
					 }
			 
					
					
			}
						
					model.addAttribute("listVideoAdminAcceptOrNeeToImp",tutorial);
				
			
				return "listTutorialAdminAccepOrNeedToImprovement";

				
			}
		  
		  
		
		
		

	
	
}
