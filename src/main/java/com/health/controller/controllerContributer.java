package com.health.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ReplaceOverride;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Question;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.contributor_Role;
import com.health.model.language;
import com.health.model.topic;
import com.health.repository.CategoryDao;
import com.health.repository.RoleRepository;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.repository.contributor_RoleDao;
import com.health.repository.languagedao;
import com.health.repository.topicRepositary;
import com.health.service.categoryService;
import com.health.service.tutorialService;
import com.health.service.impl.catgoryServiceImpl;

@Controller
public class controllerContributer {

	public static String uploadDirectoryCreation = "src/main/resources/static" + "/Media/content" + "/Creation/Slide";
	
	public static String uploadDirectoryCreationScripts = "src/main/resources/static" + "/Media/content" + "/Creation/Script";
	
	public static String uploadDirectoryCreationVideo = "src/main/resources/static" + "/Media/content" + "/Creation/Video";
	

	@Autowired
	private languagedao languageDao;

	@Autowired
	private UserRepository userRepositorydao;

	@Autowired
	private TutorialDao tutorialDao;

	@Autowired
	private CategoryDao CategoryDao;

	@Autowired
	private topicRepositary topicRepositarydao;
	
	
	@Autowired
	private RoleRepository rolerespositary;
	
	@Autowired
	private UserRoleRepositary  userRoleRepositary;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private categoryService categoryService;
	
	@Autowired
	private topicRepositary topicRepositaryDao;
	
	@Autowired
	private contributor_RoleDao contributor_RoleDao;
	
	
	@Autowired
	private tutorialService tutorialService;

	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping("/addContributerLanguage")
	public String RevokeRequest(Model model) 
	{

		List<language> language = (List<com.health.model.language>) languageDao.findAll();

		model.addAttribute("lan", language);
		
		return "AddContributerLanguage";
		
	}

	/* show languages */
	@RequestMapping("/rovekeRequest")
	public String  revokelanguage(Model model,Authentication authentication)
	{
	
		int status=1;	
		User user=userRepository.findByUsername(authentication.getName());
		
		List<UserRole> userRole=(List<UserRole>)userRoleRepositary.findByStatusAndUser(status,user);	
		
		model.addAttribute("languages",userRole);
		
		return "revokeLanguages";	
	}	
	
	@RequestMapping("/revokeSubmition")
	public String revokeSubmition(Model model,Authentication authentications,@RequestParam(name="languageName") String languagename)
	{
		
		language language=languageDao.findBylanguageName(languagename);
		
		User user = userRepository.findByUsername(authentications.getName());
		
		int status =0 ;

		UserRole userRole = userRoleRepositary.findByLanguageAnduser(user,language);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		/* return "showContributer"; */
		
		return "revokeLanguages";	
	}
	
	@RequestMapping("/addScript")
	public String addScript(Model model, Authentication authentication, HttpServletRequest request) 
	{

		return "addContent";

	}

	@RequestMapping(value = "/addkeyword", method = RequestMethod.POST)
	public String addkeyword(Model model, Authentication authentication, HttpServletRequest request) {

		String keywordArea = request.getParameter("keywordArea");

		System.err.println(keywordArea);
		String autheticationName = authentication.getName();
		User user = userRepositorydao.findByUsername(autheticationName);

		return "addContent";

	}

	@RequestMapping("/outline")
	public @ResponseBody List<String> getTopicByCategory(@RequestParam(value = "saveOutline") String outlineMessagae,				
			  @RequestParam(value = "categorname") String categorname,
			  @RequestParam(value = "topicid") String topicid,
			  @RequestParam(value = "lanId") String lanId,
			  Model model,Authentication authentication) 
	{	
		
		List<String> topicName = new ArrayList<String>();
		
		System.err.println(outlineMessagae);
		
		User user=userRepository.findByUsername(authentication.getName());
		
		topic topic=topicRepositaryDao.findBytopicname(topicid);
		
		Category category=CategoryDao.findBycategoryname(categorname);
	
		int outlineStatus=1;
		
		tutorialService.updateOutline(outlineMessagae,outlineStatus, user,topic,category);
		
		topicName.add("Save Outline Succefully");
		
		return topicName;

	}
		  @RequestMapping("/keyword")
		  public @ResponseBody List<String>
		  getTopicByKeyword(@RequestParam(value = "id") String keywordMessgae,
				  @RequestParam(value = "categorname") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
		 {
	  	  
			  System.err.println(categorname);
			  
			  List<String> topicName = new ArrayList<String>();
			  
			  User user=userRepository.findByUsername(authentication.getName());
			  
			  topic topic = topicRepositaryDao.findBytopicname(topicid);		  
			  
			  Category category=categoryDao.findBycategoryname(categorname);
			  
			  
		
			  System.err.println(topic);		  
		
			  int status = 1;
			  
			  tutorialService.updateKeyword(keywordMessgae,status,user,topic,category);
			  
			  
			  topicName.add("Update Keyword Succefully");
  			  
			return topicName;
			  
		 }
		 
		  /* Here is code for script */
		  String fileconversion;
		  
		  @RequestMapping(value = "/scriptUpload",method =RequestMethod.POST)		  
		  public @ResponseBody List<String>
		  getScriptUpload(@RequestParam(value = "uploadsScriptFile") MultipartFile [] scriptFiles,
				  @RequestParam(value = "categoryid") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)		  
		{
			  
			  
			  System.err.println("Hello");
			  
			  System.err.println(scriptFiles);
			  			  
			  List<String> topicName = new ArrayList<String>();			  
		
		  User user=userRepository.findByUsername(authentication.getName()); 
		  
		  topic topic = topicRepositaryDao.findBytopicname(topicid); 
		  Category category=categoryDao.findBycategoryname(categorname);
		 
	
		  String abc = uploadDirectoryCreationScripts + "/" + categorname + "/"+ lanId + "/"+ topicid;
		 
		  new File(abc).mkdirs();
		  
		  StringBuilder fileNames = new StringBuilder(); 
		  for (MultipartFile file : scriptFiles)
		  { Path fileNameAndPath = Paths.get(abc,file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename() + " ");
		  
		  
		  try { Files.write(fileNameAndPath, file.getBytes());
		  fileconversion =fileNameAndPath.toString();
		  
		  } catch (IOException e) {
			  e.printStackTrace(); 
			  } 
		  }
		  
		  String substring = fileconversion.substring(26);
		  String script = substring.toString();
			    
		  	int slideStatus = 1;
		
		  	System.err.println(substring+"s\n"+slideStatus+"u\n"+user+"t\n"+topic+"c\n"+category);
		  	
			tutorialService.updateScript(substring,slideStatus,user,topic,category);
			 
			topicName.add("Update Script Succefully");
		  
			return topicName;
			  
		 }
		  
 
		  /* Here write code for slide upload code */
		  
		 
		  
		  @RequestMapping(value = "/slideUpload",method =RequestMethod.POST)		  
		  public @ResponseBody List<String>
		  getSlideUpload(@RequestParam(value = "uploadsSlideFile") MultipartFile [] slidefile,
				  @RequestParam(value = "categoryid") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)		  
		{
			  
		  List<String> topicName = new ArrayList<String>();			  
		
		  User user=userRepository.findByUsername(authentication.getName()); 
		  topic topic = topicRepositaryDao.findBytopicname(topicid); 
		  Category category=categoryDao.findBycategoryname(categorname);
		  
		  System.err.println("u"+ user+"t"+topic+"c"+category);
	
		  String abc = uploadDirectoryCreation + "/" + categorname + "/"+ lanId + "/"+ topicid;
		 
		  new File(abc).mkdirs();
		  
		  StringBuilder fileNames = new StringBuilder(); 
		  for (MultipartFile file :
		  slidefile) { Path fileNameAndPath = Paths.get(abc,
		  file.getOriginalFilename()); fileNames.append(file.getOriginalFilename() + " ");
		  
		  
		  try { 
			  
			  
			  Files.write(fileNameAndPath, file.getBytes()); 
		  fileconversion =fileNameAndPath.toString();
		  
		  
		  } catch (IOException e) { e.printStackTrace(); } }
		 
		  
		  String substring = fileconversion.substring(26);
		  String slide = substring.toString();
				
		   
				int slideStatus = 1;
	
		tutorialService.updateSlide(slide,slideStatus,user,topic,category);
	  
			 topicName.add("Update Slide Succefully");
  			  
			return topicName;
			  
		 }
		  
		/* Here is code to generate image from video and upload Video */ 
		  
		  
		  String fileconversionvideo;
		  
		  public static Timestamp getCurrentTime() {								// Current Date
				
				Date date=new Date();
				long t=date.getTime();
				Timestamp st=new Timestamp(t);
				
				return st;
			}
		  
		  
		  
		  @RequestMapping(value = "/videoUpload",method =RequestMethod.POST)		  
		  public @ResponseBody List<String>
		  getVideoUpload(@RequestParam(value = "videoFileName") MultipartFile [] videofile,
				  @RequestParam(value = "categoryid") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)		  
		{
			  System.err.println(categorname+""+topicid+""+lanId);

			  List<String> topicName = new ArrayList<String>();			  
			
			  User user=userRepository.findByUsername(authentication.getName()); 
			  topic topic = topicRepositaryDao.findBytopicname(topicid); 
			  Category category=categoryDao.findBycategoryname(categorname);
		
			  
			  String abc = uploadDirectoryCreationVideo + "/" + categorname + "/"+ lanId + "/"+ topicid;
				
			  new File(abc).mkdirs();
			  
			  StringBuilder fileNames = new StringBuilder(); 
			  for (MultipartFile file : videofile)
				  
			  { Path fileNameAndPath = Paths.get(abc,
			  file.getOriginalFilename()); fileNames.append(file.getOriginalFilename() + " ");
			  
			  
			  try { 
				  Files.write(fileNameAndPath, file.getBytes()); 
			  fileconversion =fileNameAndPath.toString();
			  
			  
			  } catch (IOException e) { e.printStackTrace(); } }
			 
			  
			
			  
			  String substring = fileconversion.substring(26);
			  String videopath = substring.toString();
			  
		  
			  System.err.println("path is"+videopath.toString());
		
			  int videoStatus = 1;
		    
		   tutorialService.updateVideo(videopath,videoStatus,user,topic,category);

		   
		   
		   
		   
		   
		/*
		 * try { File input = new File(videopath); BufferedImage inputBuffer =
		 * ImageIO.read(input); File outputimage = new File("thumbnail.jpg");
		 * 
		 * //Output image as File Thumbnails.of(inputBuffer).size(100,
		 * 100).outputFormat("jpg").toFile(outputimage);
		 * 
		 * 
		 * 
		 * //Output image as BufferedImage BufferedImage outputBuffer =
		 * Thumbnails.of(inputBuffer).size(100,
		 * 100).outputFormat("png").asBufferedImage(); File outputBufferedImage = new
		 * File("thumbnail.png"); ImageIO.write(outputBuffer, "png",
		 * outputBufferedImage);
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
		   
	   
		   
		    topicName.add("Update Video Succefully");
	  			  
			return topicName;
			  
		 }
		  
		  /* Here write code for preRequistic */
		 
		  @RequestMapping(value = "/prerequisite",method =RequestMethod.POST)		  
		  public @ResponseBody List<String> getRequistic(@RequestParam(value = "videoFileName") MultipartFile [] prerequestics,
				  
				  @RequestParam(value = "categoryid") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)		  
		{
			 
			  System.err.println(categorname+""+topicid+""+lanId);

			  List<String> topicName = new ArrayList<String>();			  
			
			  User user=userRepository.findByUsername(authentication.getName()); 
			  topic topic = topicRepositaryDao.findBytopicname(topicid); 
			  Category category=categoryDao.findBycategoryname(categorname);
			  
		  
			  String abc = uploadDirectoryCreationVideo + "/" + categorname + "/"+ lanId + "/"+ topicid;				
			  new File(abc).mkdirs();
		
			  
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
			  
			  
			  StringBuilder fileNames = new StringBuilder(); 
			  for (MultipartFile file : prerequestics)
				  
			  { Path fileNameAndPath = Paths.get(abc,
			  file.getOriginalFilename()); fileNames.append(file.getOriginalFilename() + " ");
			  
			  
			  try { 
				  Files.write(fileNameAndPath, file.getBytes()); 
			  fileconversion =fileNameAndPath.toString();
			  
			  
			  } catch (IOException e) { e.printStackTrace(); } }
			 
			  
			
			  
			  String substring = fileconversion.substring(26);
			  String videopath = substring.toString();
			  
		  
			  System.err.println("path is"+videopath.toString());
		
			  int videoStatus = 1;
		    
		   tutorialService.updateVideo(videopath,videoStatus,user,topic,category);

	   
		    topicName.add("Update Video Succefully");
	  			  
			return topicName;
			  
		 }
		  
		  
		
			/* selectFossTopic
			 * Access the topic according to category  */
			
				  
			@RequestMapping("/loadTopicByCategoryContributor")
			public @ResponseBody  List<String> getTopicByCategoryContributor(@RequestParam(value="id") String categoryname,Authentication autheticateion)
			{  
		
			    List<String> topicName=new ArrayList<String>();
			   
			    User user=userRepositorydao.findByUsername(autheticateion.getName());
			    
				Category category=categoryService.findBycategoryname(categoryname);
			
			//	List<contributor_Role> contributor=contributor_RoleDao.findByContributorTopic(user,category);
		
				List<Tutorial>  tutiorial=tutorialDao.findByContributorTopic(user,category);
			
				  for(Tutorial s: tutiorial) 
				  {
					  topicName.add(s.getTopic().getTopicname());
												    
				  }
				  
				  
				  
				  return topicName;  
		
						
			}
				
			@RequestMapping("/loadLanguageByTopicId")
			public @ResponseBody  List<String> getLanguageByTopic(@RequestParam(value="id") String TopicName,Authentication authetication)
			{  
		
			System.err.println("TopicName is"+TopicName);
				
			    List<String> topicName=new ArrayList<String>();
			    
			    
			    
			    
			    
			    User user=userRepositorydao.findByUsername(authetication.getName());
			   
			    //Category category=categoryService.findBycategoryname(categoryname);
			    
			    topic topic=topicRepositarydao.findBytopicname(TopicName);
			    
				 System.err.println("Helo1");

				List<Tutorial> tutorialByTopic=tutorialDao.findByTopicByLanguage(user,topic);
				
				 System.err.println("Hel2");
				 
				 

				 for(Tutorial s : tutorialByTopic) 
				  {			
		
					 topicName.add(s.getLan().getLanguageName());
					  		  
				  }  
			
				return topicName;  
		
			}
			
			
			/* Tutorial index page redirected to upload individual content page */

		@RequestMapping("/submitTutorial")
		public String submitTutorial(Model model,@RequestParam(value="categoryName") String categoryId,@RequestParam(name="inputTopic") String inputTopic,@RequestParam(name="inputLanguage") String inputLanguage,Authentication authetication)
		{

			
				Category catgory=categoryDao.findBycategoryname(categoryId);
				
				topic topic=topicRepositarydao.findBytopicname(inputTopic);
				
				com.health.model.language language=languageDao.findBylanguageName(inputLanguage);
							
				//List<Tutorial> tutorial= (List<Tutorial>) tutorialDao.finByCategoryAndlanguage(catgory, topic);
				
				List<Tutorial> tutorial=(List<Tutorial>) tutorialDao.findByCategoryAndlanguage(catgory,language);

				for (Tutorial t : tutorial) 
				{
				
								if(t.getOutlineStatus()==0)
								{		
									model.addAttribute("statusOutline","Pending");

								}else if (t.getOutlineStatus()==1)
								{
							
									model.addAttribute("statusOutline","Wating for Domain Review");
								} 
								
								if(t.getScriptStatus()==0) 
								{
									
									model.addAttribute("statusScript", "Pending");
	
								}else if (t.getScriptStatus()==1) 
								
								{

									model.addAttribute("statusScript","Wating for Domain Review");
									
								}
								
								if(t.getSlideStatus()==0) 
								{
									
									model.addAttribute("statusSlide", "Pending");
	
								}else if (t.getSlideStatus()==1) 
								
								{

									model.addAttribute("statusSlide","Wating for Domain Review");
									
								}
								
								if(t.getVideoStatus()==0) 
								{
									
									model.addAttribute("statusVideo", "Pending");
	
								}else if (t.getVideoStatus()==1) 
								
								{

									model.addAttribute("statusVideo","Wating for Domain Review");
									
								}
								
								
								if(t.getKeywordStatusSet()==0)
								{
									
									model.addAttribute("statusKeyword", "Pending");
	
								}else if (t.getKeywordStatusSet()==1) 
								
								{
									model.addAttribute("statusKeyword","Wating for Domain Review");	
								}
								
								
				}
				model.addAttribute("tutorials",tutorial);
						
				model.addAttribute("categoryName",catgory);
				
				model.addAttribute("inputTopic",topic);
				
				model.addAttribute("inputLanguage",language);
				
				String authticationName=authetication.getName();
				
				User user=userRepository.findByUsername(authticationName);
		
				return "addContent";
			
				
			}




}
