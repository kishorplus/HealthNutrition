package com.health.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Remote;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.metadata.MethodType;

import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking.RemoveCommand;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Consaltantant;
import com.health.model.Event;
import com.health.model.Question;
import com.health.model.Testimonial;
import com.health.model.TraningInformation;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.category_Tutorial;
import com.health.model.contributor_Role;
import com.health.model.feedback;
import com.health.model.feedbackMasterTrainer;
import com.health.model.newRole;
import com.health.model.partipantDeatil;
import com.health.model.topic;
import com.health.repository.CategoryDao;
import com.health.repository.CategoryTutorialDao;
import com.health.repository.ConsaltantDao;
import com.health.repository.EventDao;
import com.health.repository.Questionreposiatry;
import com.health.repository.RoleRepository;
import com.health.repository.TestimonialDao;
import com.health.repository.TraninigInformationRespositary;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.repository.contributor_RoleDao;
import com.health.repository.feedbackRespositary;
import com.health.repository.languagedao;
import com.health.repository.participantDao;
import com.health.repository.topicRepositary;
import com.health.service.ConsaltantService;
import com.health.service.categoryService;
import com.health.service.eventService;
import com.health.service.participantService;
import com.health.service.testimonialService;
import com.health.service.tutorialService;
import com.health.service.impl.catgoryServiceImpl;


@Controller
public class ControllerHealth 
{
	static final String ROLE_APPROVE_SUCCESS_MSG = "Role Approved Successfully !" ;
	static final String RECORD_SAVE_SUCCESS_MSG = "Record Saved Successfully !" ;

	public static String uploadDirectoryConsaltant = "src/main/resources/static" + "/Media/content" + "/Consaltant";

	public static String uploadDirectory = "src/main/resources/static" + "/Media/content" + "/Testimonial";

	public static String uploadDirectorOutLine = "src/main/resources/static" + "/Media/content" + "/Tutorial/Outline";
	
	public static String uploadDirectorScript = "src/main/resources/static" + "/Media/content" + "/Tutorial/Script";
	public static String uploadDirectorTimeScript = "src/main/resources/static" + "/Media/content"+ "/Tutorial/TimeScript";
			
	public static String uploadDirectorVideo = "src/main/resources/static" + "/Media/content" + "/Tutorial/Video";
	public static String uploadDirectorKeyWord = "src/main/resources/static" + "/Media/content" + "/Tutorial/KeyWord";
	
	public static String uploadMasterTrainer = "src/main/resources/static" + "/Media/content" + "/MasterTrainer/ParicipantsDeatail";
	public static String uploadMasterTrainerPhoto = "src/main/resources/static" + "/Media/content" + "/MasterTrainer/Photo";
	
	public static String uploadQusetion= "src/main/resources/static" + "/Media/content" + "/Question";	

	public String pathfile = uploadDirectory;
	
	@Autowired
	private ConsaltantService consaltantservice;

	@Autowired
	private ConsaltantDao consalttantDao;

	@Autowired
	private testimonialService testimonialService;

	@Autowired
	private TestimonialDao testimonialDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private categoryService categoryService;

	@Autowired
	private eventService eventService;

	@Autowired
	private EventDao eventDao;

	@Autowired
	private TutorialDao tutorialDao;

	@Autowired
	private CategoryTutorialDao categoryTutorialDao;

	@Autowired
	private RoleRepository rolerespositary;

	@Autowired
	private UserRoleRepositary userRoleRepositary;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private TraninigInformationRespositary traninigInformationRespositary;
	
	@Autowired
	private categoryService categoryservice;
	
	@Autowired 
	private Questionreposiatry questionreposiatryDao;
	
	@Autowired
	private participantService participantService;
	
	@Autowired
	private topicRepositary topicRepositarydao;
	
	@Autowired
	private feedbackRespositary feedbackRespositary;

	@Autowired 
	private  participantDao participantDao;
	
	@Autowired
	private topicRepositary topicdao;
	
	@Autowired
	private languagedao languageDao;
	
	@Autowired
	private contributor_RoleDao contributorRoleDao;

	
	
	@RequestMapping("/showListTutorial")
	public String  showListTutorial(Model model, @RequestParam(value ="categoryName") String categoryname,@RequestParam(name="inputLanguage") String inputLanguage)		
	{
		
		//List<Category> categoryDropDown=categoryservice.findAll();
		
		/*
		 * List<Category> category=CategoryDao.findByHomeAllCategory();
		 */
		
		List<Tutorial> categoryDropDown=tutorialDao.finBystatus();
		
		
		model.addAttribute("categorys",categoryDropDown);
		
		Category category=categoryDao.findBycategoryname(categoryname);
		 
		int status=1;
		
		com.health.model.language language=languageDao.findBylanguageName(inputLanguage);
		
		//List<Tutorial> tutorialResource=tutorialDao.findByCategoryLan(category);
		
		List<Tutorial> tutorialResources=tutorialDao.findByLan(language);
		
	    List<Tutorial> tutorialRes=tutorialDao.findByLanAndCat(category,language,status);
	   
	    for (Tutorial tutorial : tutorialRes)
	    {	
	    	
	    	String video=tutorial.getVideo(); 
	    	model.addAttribute("tutorialList",video);	
	    
	    }
	    
	    	model.addAttribute("list",tutorialRes);
	    
	    	return "showListOfTutorial";	    
	}
	//contributor list who assign by Admin

	@RequestMapping("/listContributor")
	public String  listContributor(Model model)
	{
		
			int status=1;	
			int id=5;			
			Role role=rolerespositary.findOne(id);	
			
			List<UserRole> userByContributor=(List<UserRole>) userRoleRepositary.finbyRoleUser(status,role);
		
			
			ArrayList<String> userName=new ArrayList<>();
 			
		  for (UserRole userRole : userByContributor) {
		  
		
		  System.err.println(userRole.getUser().getUsername());
		  
		  userName.add(userRole.getUser().getUsername());
		  
		  	}
		  
		  Set<String> setInfo=new HashSet<String>(userName);
	
		  model.addAttribute("userByContributors",setInfo);	
		  
		
		return "showAdminContributorList";		
	}
	
	
	////
	/*
	 * @RequestMapping(value="/contributerSelectionLanguage", method =
	 * RequestMethod.GET) public ModelAndView addClassget(HttpServletRequest
	 * req,ModelAndView mv) {
	 * 
	 * HttpSession session=req.getSession(false); // checking the last alive session
	 * 
	 * 
	 * ArrayList<com.health.model.langu
	 * age>
	 * standard=(ArrayList<com.health.model.language>) languageDao.findAll(); //
	 * fetching Class Tuple list
	 * 
	 * 
	 * 
	 * ArrayList<String> newNonExistClass=new ArrayList<String>();
	 * newNonExistClass.add("Class 1"); newNonExistClass.add("Class 2");
	 * newNonExistClass.add("Class 3"); newNonExistClass.add("Class 4");
	 * newNonExistClass.add("Class 5"); newNonExistClass.add("Class 6");
	 * newNonExistClass.add("Class 7"); newNonExistClass.add("Class 8");
	 * newNonExistClass.add("Class 9"); newNonExistClass.add("Class 10");
	 * newNonExistClass.add("Class 11"); newNonExistClass.add("Class 12");
	 * 
	 * 
	 * 
	 * for(com.health.model.language s:standard) { // Validating each class tuple
	 * against its non availability in database(Class)
	 * if(newNonExistClass.contains(s.getLanguageName()))
	 * newNonExistClass.remove(s.getLanguageName()); }
	 * 
	 * mv.addObject("classExist", newNonExistClass); // Setting view Variable to
	 * available class not included in database till now.
	 * mv.setViewName("addClass");
	 * 
	 * 
	 * 
	 * 
	 * return mv; }
	 * 
	 * 
	 */	
	

	@RequestMapping(value="/contributerSelectionLanguage",method = RequestMethod.GET)
	  public String getlanguage(Model model,Authentication authetication)
	{
		
		User user=userRepository.findByUsername(authetication.getName());
		
		Role role=rolerespositary.findOne(5);
		
		ArrayList<String> languageExit=new ArrayList<String>();
		
		List<UserRole> userRoles=(List<UserRole>) userRoleRepositary.findByuserAndRole(user, role);//findByUser(user);
		
		for(UserRole ur :userRoles)
		{	
			languageExit.add(ur.getLanguage().getLanguageName());
		}		
		ArrayList<com.health.model.language> lanDeatail=(ArrayList<com.health.model.language>) languageDao.findAll();
	
		ArrayList<String> languageId=new ArrayList<String>();
		
		for(com.health.model.language language : lanDeatail)
		{
			languageId.add(language.getLanguageName());				
		}
		 languageId.removeAll(languageExit); 
		 
		for (String integer : languageId) 
		{
			
			System.err.println("language All"+integer);
			
		}
			
		for (String integer : languageExit) {
			
			System.err.println("language Exits"+integer);
		}
	
		model.addAttribute("languages",languageId);
	
		return "addContributerRoleRequest";			
}
	
	//Here is code for  selection  language of contributor
		
	@RequestMapping(value="/domainLanguage",method = RequestMethod.GET)
	  public String languagesByDomain(Model model,Authentication authetication)
	{
		
		User user=userRepository.findByUsername(authetication.getName());
		
		Role role=rolerespositary.findOne(3);
				
		ArrayList<String> languageExit=new ArrayList<String>();
		
		List<UserRole> userRoles=(List<UserRole>) userRoleRepositary.findByuserAndRole(user,role);
		
		for(UserRole ur :userRoles)
		{	
			
			languageExit.add(ur.getLanguage().getLanguageName());
			
		}		
		ArrayList<com.health.model.language> lanDeatail=(ArrayList<com.health.model.language>) languageDao.findAll();
	
		 ArrayList<String> languageId=new ArrayList<String>();
		
		for(com.health.model.language language : lanDeatail)
		{
			languageId.add(language.getLanguageName());
			
		}
		
		 languageId.removeAll(languageExit); 
	
		model.addAttribute("languages",languageId);
		
	
		return "addDomainRoleRequest";			
}
 

	

	
	  @RequestMapping(value="/hdajkshdj",method =RequestMethod.POST) 
	  public String addContributerLanguage(Model model,ModelAndView mv,Authentication autheticationm, 
			  @RequestParam(value ="languageName") String languagName) 
	  {
	  
	  System.err.println(languagName);
	  
	  List<com.health.model.language> language= (List<com.health.model.language>) languageDao.findAll();
	  
	  
	  
	  ArrayList<String> newNonExit=new ArrayList<>();
	  
	  newNonExit.add("Marathi"); newNonExit.add("English");
	  newNonExit.add("Hindi");
	  
	  for(com.health.model.language s: language) {
	   
	  // Validating each class tuple against its non availability in
	 if(newNonExit.contains(s.getLanguageName()))
	  newNonExit.remove(s.getLanguageName());
	 
	 System.err.println("langua is"+s.getLanguageName());
	 
	  }
	 
	  
	  		model.addAttribute("languages",newNonExit);
		 
	  		
	  		System.err.println(newNonExit.toString());
	
		  return "addContributerRoleRequest";
	  
	  }
	 
	
	/*	 
	 * @RequestMapping("/contributerSelectionLanguage") public String
	 * addContributerLanguage(Model model,Authentication authetication) {
	 * 
	 * User user=userRepository.findByUsername(authetication.getName());
	 * 
	 * List<UserRole> userRole= (List<UserRole>)
	 * userRoleRepositary.findByUserInfo(user);
	 * 
	 * ArrayList<String> newNonExit=new ArrayList<>();
	 * 
	 * for(UserRole userrole : userRole) {
	 * newNonExit.add(userrole.getLanguage().getLanguageName()); }
	 * 
	 * 
	 * List<com.health.model.language> lan= (List<com.health.model.language>)
	 * languageDao.findAll();
	 * 
	 * 
	 * for (com.health.model.language language : lan){
	 * 
	 * 
	 * System.err.println("laguage name"+language.getLanguageName());
	 * 
	 * if(newNonExit.contains(language.getLanguageName()));
	 * newNonExit.remove(language.getLanguageName());
	 * 
	 * }
	 * 
	 * System.err.println("newNonExit is"+ userRole);
	 * 
	 * 
	 * 
	 * model.addAttribute("languages",lan);
	 * 
	 * return "addContributerRoleRequest";
	 * 
	 * }
	 */
	
	@RequestMapping("/homeContraoller")
	public String  language(){ 
		
		 	 return "homecontroller";
		 	 
		
	}		
	@RequestMapping("/roleNew")
	public String role(){
		
		return "addNewRole";
		
		
	}
	
	  
	@RequestMapping("/listparicipant")
	public String participantDeatail(Model model){
		
		
		
		List<partipantDeatil> participantDeatail=(List<partipantDeatil>) participantDao.findAll();
		

		model.addAttribute("parcipantDeatails", participantDeatail);
		
		return "showparticipantdeatail";
	}
	

	@RequestMapping("/Consaltant")
	public String Consaltant() {

		return "addConsaltant";

	}
	
	@RequestMapping("/show_language")
	public String show_language(Model model,HttpServletRequest request) {
		
		
		Iterable<com.health.model.language> language=languageDao.findAll();
		
		model.addAttribute("lan",language);
		
		/*
		 * String language=request.getParameter("languageName");
		 * 
		 * com.health.model.language lan=new com.health.model.language();
		 * 
		 * lan.setLanguageName(language);
		 * 
		 * languageDao.save(lan);
		 * 
		 * System.err.println(language);
		 */
		
		return "showLanguage";
		
		

	}
	
	

	@RequestMapping("/language")
	public String language(Model model,HttpServletRequest request)
	{

		List<com.health.model.language> language=(List<com.health.model.language>) languageDao.findAll();
		
		model.addAttribute("languageAll",language);
		
		return "addlanguage";
		
		
	}
		
	
	/*
	    * here code display code for Topic
	 */
		@RequestMapping("/displaytopiform")
		public String addtopic(Model model) 
		{
		
		
			List<Category> category=categoryservice.findAll();
			
			model.addAttribute("categorys",category);
			
			
	
			return "addTopic";
		
		}

		public static Timestamp getCurrentTime() 
		{																	// Current Date
			
		java.util.Date date =new java.util.Date();
					
			long t=date.getTime();
			Timestamp st=new Timestamp(t);
			
			return st;
		}

		
	/*
	 * Here code for adding topic into database
	 */
	
	


	@RequestMapping("/addTopic")
	public String addtopic(Model model,HttpServletRequest request,@RequestParam(name="categoryName") String categoryName,Authentication authentication,@RequestParam(value = "checkboxName", required = false) String checkboxValue) 
	{
	

		String topicName=request.getParameter("topicName");
		System.err.println("Topic name"+topicName);
		System.err.println("categor name"+categoryName);
		
		System.err.println(authentication.getName());
		
		int categoryid=Integer.parseInt(categoryName);
		
		
		
		User user=userRepository.findByUsername(authentication.getName());
		System.err.println(user.getId());
		
		
		Category  category=categoryDao.findByid(categoryid);//findBycategoryname(categoryName);
		System.err.println("cat Id"+category.getId());
	
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
			
		topic topic=new topic(category,user);

		topic.setTopicname(topicName);
		
		 if(checkboxValue != null)
		  {
				topic.setStatus(1);
		  }
		  else
		  {
			  category.setStatus(0);
		  }
	
		/*
		 * topic.setCategory(category); topic.setUser(user);
		 */
		 
		topic.setTimedate(getCurrentTime());
		
		topicRepositarydao.save(topic);
	
		model.addAttribute("msg",RECORD_SAVE_SUCCESS_MSG);


		return "addTopic";
	
	}
	
			

	
	@RequestMapping("/show_consalantant")
	public String show_consalantant() {

		return "Show_Consaltant";

	}

	@RequestMapping("/Testimonial")
	public String Testimonial() {

		return "addTestimonial";

	}

	@RequestMapping("/Event")
	public String Event() {

		return "addEvent";

	}
	
	/* Here upload Question */	
	@RequestMapping("/addUploadQuestion")
	public String addQuestion(Model model)
	{
		
		List<Category> category=categoryservice.findAll();
		
		model.addAttribute("categorys",category);
	
		
		return  "addUploadQuestion";
	}
// change function name
	@RequestMapping("/adminShowDomainReviweer")
	public String adminShowQualityreviweer(Model model){

		int rolId = 3;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 1;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}
		model.addAttribute("statusByApprov", userAddInformation);

		return "adminShowDomainReviweer";

	}

	@RequestMapping("/adminShowQualityreviweer")
	public String adminshowDomainReviweer(Model model) {

		int rolId = 1;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 1;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

        
		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("statusByApprov", userAddInformation);

		return "adminShowQualityReviweer";

	}

	@RequestMapping("/adminShowMasterTrainer")
	public String showMasterTrainer(Model model) {

		int rolId = 4;

		Role role = rolerespositary.findByIdRoles(rolId);
		int status = 1;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("masterTrainerDetail", userAddInformation);

		return "adminShowMasterTrainer";
	}

	@RequestMapping("/Category")
	public String addCategory() {
		

		return "addCategory";
	}

	@RequestMapping("/TutorialAdd")
	public String tutorialAdd(Model model) {

		List<Category> categoryList = (List<Category>) categoryService.findAll();

		model.addAttribute("categorys", categoryList);
		return "adduploadTutorial";
	}

	@RequestMapping("/show_category")
	public String show_category(Model model) {

		List<Category> category = (List<Category>) categoryDao.findAll();

		model.addAttribute("products", category);

		return "showCategory";
	}

	/*****************************************************
	 * Here we write code for add conslantant
	 *************************************************************************/

	String fileconsalantant;

	@RequestMapping("/addConsaltant")
	public String uploadConsaltant(HttpServletRequest req, Model model,
			@RequestParam("uploadConsaltantImage") MultipartFile[] files)

	{

		String path = null;
		String nameConsaltant = req.getParameter("nameConsaltant");
		String descriptionConsaltant = req.getParameter("descriptionConsaltant");
		String abc = uploadDirectoryConsaltant + "/" + nameConsaltant;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());

				fileconsalantant = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	       java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);     
	               
		
		String substring = fileconsalantant.substring(26);

		Consaltantant consaltantant = new Consaltantant();

		consaltantant.setNameConsaltant(nameConsaltant);
		consaltantant.setDescriptionConsaltant(descriptionConsaltant);
		consaltantant.setUploadConsaltantImage(substring);
		
		consaltantant.setTimaedate(getCurrentTime());

		consalttantDao.save(consaltantant);

		System.err.println(uploadDirectory);

		model.addAttribute("msg", RECORD_SAVE_SUCCESS_MSG);

		return "addConsaltant";
		

	}

	/*****************************************************
	 * Here Start Write code to show consalantant
	 *************************************************************************/

	@RequestMapping(value = "/show_consalantant", method = RequestMethod.GET)

	public String showconsaltant(Model model) 
	{

		List<Consaltantant> name=consalttantDao.findBydateConsalant();
		
		for (Consaltantant consaltantant : name) {
			
			consaltantant.getUploadConsaltantImage();
			
		}
		
		
		model.addAttribute("products", name);

		return "Show_Consaltant";

	}

	/*****************************************************
	 * Here End Write code to show consalantant
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to consalantant delete
	 *************************************************************************/

	@RequestMapping("/consalantant/delete/{id}")
	public String deleteconsalantant(@PathVariable Integer id, Model model, ModelAndView mv) {

		consaltantservice.deleteProduct(id);

		return "redirect:/show_consalantant";

	}

	/*****************************************************
	 * Here End Write code to consalantant delete
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to consalantant select by id for Edit
	 *************************************************************************/

	/* Here we Edit information User by id */

	@RequestMapping("productconsalantant/edit/{id}")
	public String editconsalantant(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Consaltantant consaltantant = consaltantservice.getProductById(id);

		model.addAttribute("products", consaltantant);

		// return "Update_Consalantant"; categoryService

		return "Update _ConsalantantTwo";

	}

	/*****************************************************
	 * Here End Write code to consalantant select by id for Edit
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to update consalantant
	 *************************************************************************/

	String fileconversion;

	@RequestMapping(value = "/consalantantupdate", method = RequestMethod.POST)
	public String uploadConsaltantUpdate(HttpServletRequest req,
			@RequestParam("uploadConsaltantImage") MultipartFile[] files) {

		String id = req.getParameter("productId");

		String path = null;
		String nameConsaltant = req.getParameter("nameConsaltant");
		String descriptionConsaltant = req.getParameter("descriptionConsaltant");
		int consalantant_id = Integer.parseInt(id);
				

		System.out.println("hi" + consalantant_id);
		System.err.println("Hi" + consalantant_id);
		System.err.println(descriptionConsaltant);
		System.out.println(nameConsaltant);

		String abc = uploadDirectoryConsaltant + "/" + nameConsaltant;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");

			try {

				Files.write(fileNameAndPath, file.getBytes());
				fileconversion = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		String substring = fileconversion.substring(26);

		String var = substring.toString();
		System.out.println(var);

		consaltantservice.UpdateConsalantant(descriptionConsaltant, nameConsaltant, var, consalantant_id);

		System.err.println(uploadDirectory);

		return "redirect:/show_consalantant";

	}

	/*****************************************************
	 * Here End code update of consalantant
	 *************************************************************************/

	/*****************************************************
	 * Here we write code for add testimonial
	 *************************************************************************/

	String filepath;
	
	String mastertrainer;
	

	@RequestMapping("/addTestimonial")
	public String upload(HttpServletRequest req, Model model,
			@RequestParam("uploadTestiminial") MultipartFile[] files) 
	{

		String path = null;
		String testimonialName = req.getParameter("testimonialName");
		String testimoniaqlDescription = req.getParameter("testimoniaqlDescription");

		String abc = uploadDirectory + "/" + testimonialName;

		new File(abc).mkdir();
		
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
		String currentTime = sdf.format(dt);
		
		
		
		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());

			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		String substring = filepath.substring(26);
	
		Testimonial testimonial = new Testimonial();

		testimonial.setTestimonialName(testimonialName);
		testimonial.setTestimoniaqlDescription(testimoniaqlDescription);

		testimonial.setUploadTestiminial(substring);
		testimonial.setTimedate(getCurrentTime());
		
	
		testimonialDao.save(testimonial);

		model.addAttribute("msg", RECORD_SAVE_SUCCESS_MSG);

		return "addTestimonial";
	}

	/*****************************************************
	 * Here we End write code for add testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to Show Testimonial
	 *************************************************************************/

	@RequestMapping(value = "/show_testimonial", method = RequestMethod.GET)

	public String showtestimonial(Model model) 
	{

		  List<Testimonial> name=testimonialDao.findBydate();
		
		/*
		 * List<Testimonial> name
		 * =testimonialService.findAll(org.springframework.data.domain.Sort.by(org.
		 * springframework.data.domain.Sort.Direction.ASC, "timedate"));
		 * 
		 */	  
		  
	  

		model.addAttribute("testimonials", name);

		return "show_Testimonial";

	}

	/*****************************************************
	 * Here End Write code to End show testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to Edit Testimonial
	 *************************************************************************/

	@RequestMapping("productTesdtimonial/edit/{id}")
	public String editconsalantantDemo(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Testimonial testimonial = new Testimonial();

		testimonial = testimonialService.getProductById(id);

		model.addAttribute("testimonials", testimonial);

		return "updateTestimonial";

	}

	/*****************************************************
	 * Here Write code to End Edit Testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to update Testimonial
	 ****************************************************************************/

	@RequestMapping(value = "/updateTetimonial", method = RequestMethod.POST)
	public String updateTestimonial(HttpServletRequest req, @RequestParam("uploadTestiminial") MultipartFile[] files) {

		String id = req.getParameter("testimonialId");
		String path = null;
		String nametestimonial = req.getParameter("testimonialName");
		String descriptionTestimonial = req.getParameter("testimoniaqlDescription");
		int testimonial_id = Integer.parseInt(id);

		String abc = uploadDirectoryConsaltant + "/" + nametestimonial;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				fileconversion = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		String substring = fileconversion.substring(26);
		String var = substring.toString();
		System.out.println(var);
		testimonialService.updateTestimonial(nametestimonial, descriptionTestimonial, var, testimonial_id);

		System.err.println(uploadDirectory);

		return "redirect:/show_testimonial";

	}

	/*****************************************************
	 * Here End code update to Testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to delete Testimonial
	 *************************************************************************/

	@RequestMapping("testimonial/delete/{id}")
	public String deleteTestimonial(@PathVariable Integer id, Model model, ModelAndView mv) {

		testimonialService.deleteProduct(id);

		return "redirect:/show_testimonial";

	}

	/*****************************************************
	 * Here End Write code to Event delete
	 *************************************************************************/

	/*****************************************************
	 * Here we write code for add Event
	 *************************************************************************/

	@RequestMapping("/addEvent")
	public String addEvent(HttpServletRequest req, Model model) {

		System.out.println(req.getParameter("eventname"));

		String eventname = req.getParameter("eventname");
		String date = req.getParameter("date");
		String description = req.getParameter("description");
		String venuename = req.getParameter("venuename");
		String contactperson = req.getParameter("contactperson");
		String contactnumber = req.getParameter("contactnumber");
		String email = req.getParameter("email");

		System.out.println(eventname + "" + date + "" + description);

		Event event1 = new Event();

		event1.setEventname(eventname);
		event1.setDate(date);
		
		
		
		event1.setTimedate(getCurrentTime());
		
		event1.setDescription(description);
		event1.setVenuename(venuename);
		event1.setContactperson(contactperson);
		event1.setContactnumber(contactnumber);
		event1.setEmail(email);
		
		
		model.addAttribute("msg", "Succefully Add Event");

		eventDao.save(event1);
		
		model.addAttribute("msg", RECORD_SAVE_SUCCESS_MSG);


		return "addEvent";

	}

	/*****************************************************
	 * Here we end write code for add Event
	 **************************************************************************/

	/*****************************************************
	 * Here Start Write code to show Event
		  
		  
		  
		 
	 *************************************************************************/

	@RequestMapping(value = "/show_Event", method = RequestMethod.GET)
	public String showEvent(Model model) {

		/*
		 * List<Event> name = eventService.findAll();
		 */	

		List<Event> name = eventDao.findBylatestdate();
		
		
		model.addAttribute("events", name);
		
		
		return "Show_Event";

	}

	/*****************************************************
	 * Here End Write code to show event
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to Event delete
	 *************************************************************************/

	@RequestMapping("event/delete/{id}")

	public String deleteEvent(@PathVariable Integer id, Model model, ModelAndView mv) {

		eventService.deleteProduct(id);

		return "redirect:/show_Event";

	}

	/*****************************************************
	 * Here End Write code to Event delete
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to Event select by id for Edit
	 *************************************************************************/

	/* Here we Edit information User by id */

	@RequestMapping("event/edit/{id}")
	public String editEvent(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Event event = eventService.getProductById(id);

		model.addAttribute("events", event);

		System.err.println(event.getDate() + "" + event.getEmail() + "" + event.getDescription());

		return "Update_Event";

	}

	/*****************************************************
	 * Here End Write code to Event select by id for Edit
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to update Event
	 *************************************************************************/

	@RequestMapping(value = "/eventUpdate", method = RequestMethod.POST)
	public String eventUpdate(HttpServletRequest req) {
		
		String eventname = req.getParameter("eventname");
		String date = req.getParameter("date");
		String description = req.getParameter("description");
		String venuename = req.getParameter("venuename");
		String contactperson = req.getParameter("contactperson");
		String contactnumber = req.getParameter("contactnumber");
		String email = req.getParameter("email");

		String id_event = req.getParameter("eventId");

		int id = Integer.parseInt(id_event);

		System.err.println("hi" + id);

		eventService.UpdateEvent(eventname, date, description, venuename, contactperson, contactnumber, email, id);

		return "redirect:/show_Event";

	}

	/*****************************************************
	 * Here End code update of Event
	 *************************************************************************/

	/*****************************************************
	 * Here we write code save category
	 *************************************************************************/

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String add(HttpServletRequest req, Model model,Authentication authentication,
			@RequestParam(value = "checkboxName", required = false) String checkboxValue) 
	{
	
		String categoryName = req.getParameter("categoryname");

		if (categoryDao.findBycategoryname(categoryName)!=null){
			model.addAttribute("msg", true);
			
			return "addCategory";
			
		}
		User user=userRepository.findByUsername(authentication.getName());
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		String currentTime = sdf.format(dt);

	
		Category category = new Category();

		category.setCategoryname(categoryName);
		category.setCreated(getCurrentTime());	
		category.setUserid(user.getId());
			
			
			
			
			  if(checkboxValue != null)
		  {
		    category.setStatus(1);
		  }
		  else
		  {
			  category.setStatus(0);
		  }
		categoryDao.save(category);
		
		model.addAttribute("msg1", RECORD_SAVE_SUCCESS_MSG);

		return "addCategory";

	}

	/*****************************************************
	 * Here we write code End save category
	 *************************************************************************/

	/*****************************************************
	 * Here we write code Tutorial category
	 *************************************************************************/

	@RequestMapping(value = "/addTutorail", method = RequestMethod.POST)
	public String addTutorail(HttpServletRequest req, Model model, @RequestParam("outline") MultipartFile[] outline,
			@RequestParam("script") MultipartFile[] script, @RequestParam("timeScript") MultipartFile[] timeScript,
			@RequestParam("tutorial") MultipartFile[] video, @RequestParam(name = "categoryName") String categoryName

	) {
		System.err.println(categoryName);
		String topicname = req.getParameter("topicName");
		String languageName = req.getParameter("languageName");
		String keyword=req.getParameter("keyword");

		//OutLine	

		String path = null;
		String abc = uploadDirectorOutLine + "/" + topicname;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : outline) {

			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());

			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String outlinefile = filepath.substring(26);

		// script

		String pathScript = null;
		String Script = uploadDirectorScript + "/" + topicname;
		new File(Script).mkdir();

		StringBuilder Scriptname = new StringBuilder();
		for (MultipartFile file : script) {

			Path fileNameAndPath = Paths.get(Script, file.getOriginalFilename());

			Scriptname.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		String scriptfile = filepath.substring(26);

//TimeScript
		String pathTimeScript = null;
		String TimeScript = uploadDirectorTimeScript + "/" + topicname;
		new File(TimeScript).mkdir();

		StringBuilder TimeScriptname = new StringBuilder();
		for (MultipartFile file : timeScript) {

			Path fileNameAndPath = Paths.get(TimeScript, file.getOriginalFilename());

			Scriptname.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String TimeScriptfile = filepath.substring(26);

//Video
	
		String pathVideo = null;
		String Video = uploadDirectorVideo + "/" + topicname;
		new File(Video).mkdir();

		StringBuilder videoname = new StringBuilder();
		for (MultipartFile file : video) {

			Path fileNameAndPath = Paths.get(Video, file.getOriginalFilename());

			Scriptname.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String Videofile = filepath.substring(26);

		Category category = categoryService.findBycategoryname(categoryName);

		Set<category_Tutorial> category_Tutorials = new HashSet<>();

		Tutorial turorial = new Tutorial();
	
		
		/*
		 * turorial.setTopicname(topicname); turorial.setLanguage(languageName);
		 */
		turorial.setKeyword(keyword);
		turorial.setOutlin(outlinefile);
		turorial.setScript(scriptfile);
		turorial.setTimeScript(TimeScriptfile);
		turorial.setVideo(Videofile);	
		turorial.setStatus(0);

		category_Tutorial cate_tutorial = new category_Tutorial(category, turorial);
	
		/*
		 * category_Tutorials.add(new category_Tutorial(category, turorial));
		 * categoryTutorialDao.save(category_Tutorials);
		 */

		// userService.createUser(user1, userRoles);

		categoryTutorialDao.save(cate_tutorial);


		model.addAttribute("msg", RECORD_SAVE_SUCCESS_MSG);

		return "adduploadTutorial";

	}

	/*****************************************************
	 * Here we write code End Tutorial category
	 *************************************************************************/
	////

	/*****************************************************
	 * Here Start Write code to category delete
	 *************************************************************************/

	@RequestMapping("category/delete/{id}")

	public String deleteCategory(@PathVariable Integer id, Model model, ModelAndView mv) {

		categoryService.deleteProduct(id);

		return "redirect:/show_category";
		
	}

	/*****************************************************
	 * Here End Write code to category delete
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to category select by id for Edit
	 *************************************************************************/

	/* Here we Edit information User by id */

	@RequestMapping("category/edit/{id}")
	public String editCategory(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Category category = categoryService.getProductById(id);
		model.addAttribute("category", category);
		return "updateCategory";
	}

	/*****************************************************
	 * Here Start Write code to end category select by id for Edit
	 *************************************************************************/


	
	@RequestMapping(value = "/findTutorialByLanand", method = RequestMethod.GET)
	public String viewCoursesAvailable(@RequestParam(value="categoryName") int categoryNameId,@RequestParam(name="inputLanguage") String inputLanguage,Model model) 
	{
		
		Category categoryNamer=categoryDao.findByid(categoryNameId);
		
	
		System.err.println("cat Id:"+categoryNameId);
		
		List<Tutorial> addlanguage=new ArrayList<>();
		
		Category category=categoryDao.findByid(categoryNameId);
		
		 
		  Tutorial  tutorials=tutorialDao.findBylanguage(inputLanguage);
		  
		  System.err.println(tutorials.getTutorialid());
		
		 
		 List<category_Tutorial> categtory_tutorials=(List<category_Tutorial>)categoryTutorialDao.findBycategoryAndlanguageza(category,tutorials);
		
		 System.err.println(categtory_tutorials.size());
		  for(category_Tutorial s:categtory_tutorials) 
		  {
			 
		
			 Tutorial tutorial=tutorialDao.findOne(s.getTutorial().getTutorialid());
			 
			 addlanguage.add(tutorial);
		
			  System.err.println("Hiiii"+s.getCat().getCategoryname());
	
	 }
		  
			  model.addAttribute("cat_Tu",categtory_tutorials);
			
			  return "showTutorial";	
	
	}
	
	/*
	 * load by category return language
	 */
	

	@RequestMapping("/loadByCategoryTuturial")
	public @ResponseBody  Set<String> getAllSubcategories(@RequestParam(value="id") String id)
	{
	    List<String> languageName=new ArrayList<String>();

		Category cat=categoryService.findBycategoryname(id);
		
		
		
		int status=1;
		
		List<Tutorial> Tutorial = (List<Tutorial>) tutorialDao.findByCategoryLan(cat,status);
	
		
		  ArrayList<String> tutorialLanguageExits=new ArrayList<String>();
		 

		  for (Tutorial tutorialData : Tutorial) 
		  {
			  languageName.add(tutorialData.getLan().getLanguageName()); 
		  }

		  
		  Set<String> lanSet = new LinkedHashSet<String>(languageName); 
		  
		  
		return lanSet;  

	}
	/*
	 * load by category return by 
	 */
	
	@RequestMapping("/loadBycategorylanguage")
	public @ResponseBody  List<String> getAlllanguage(@RequestParam(value="id") int id)
	{

	   
	    
	    List<String> topicName=new ArrayList<String>();
		
		//Category cat=categoryService.findBycategoryname(category.getCategoryname());
		
		Category cat=categoryService.findByid(id);
		
	
		List<category_Tutorial> catTut=(List<category_Tutorial>) categoryTutorialDao.findByCategory(cat);
	
		
		//List<category_Tutorial> categoryTutorials=(List<category_Tutorial>) categoryTutorialDao.findOne(cat);
		
		/*
		 * for(category_Tutorial s:catTut) {
		 * 
		 * //System.err.println("Language is"+s.getTutorial().getLanguage());
		 * 
		 * topicName.add(s.getLanguage().getLanguageName());
		 * 
		 * 
		 * }
		 */
	
		return topicName;   

	}
	
	

	@RequestMapping(value = "/fetchInformation", method = RequestMethod.POST)
    public @ResponseBody  List<String> getAllSubcategories1(@RequestParam(value="id") int id) 
	{
				
			
			List<String> topicName=new ArrayList<String>();
			
			//Category cat=categoryService.findBycategoryname(category.getCategoryname());
			
			Category cat=categoryService.findByid(id);
			
			List<category_Tutorial> categoryTutorial=(List<category_Tutorial>) categoryTutorialDao.findOne(cat.getId());
			
			
			for(category_Tutorial s:categoryTutorial)
			{
				
				topicName.add(s.getTutorial().getLanguage());
	
			}
		
		return topicName;
		
    }
	
	/*
	 * Access value according to Topic calling from ajax
	 * 
	 */
	
	
	@RequestMapping("/masterTrainer")
	public @ResponseBody  List<String> masterTrainer(@RequestParam(value="id") int id)
	{
	

	    System.err.println("hjasdhgh");
	    
	    List<String> topicName=new ArrayList<String>();
		
		//Category cat=categoryService.findBycategoryname(category.getCategoryname());
		
		Category cat=categoryService.findByid(id);
		
		
		System.err.println("category_id"+cat.getId());
		
	
		List<category_Tutorial> catTut=(List<category_Tutorial>) categoryTutorialDao.findByCategory(cat);
	
		
		//List<category_Tutorial> categoryTutorials=(List<category_Tutorial>) categoryTutorialDao.findOne(cat);
		
		
		for(category_Tutorial s:catTut)
		{

			//System.err.println("Language is"+s.getTutorial().getLanguage());
			
			topicName.add(s.getTutorial().getLanguage());

			
		}
	
		return topicName;   

	}
	
	/*
	 * Access value according to category
	 */

	  
	 
	@RequestMapping("/loadByCategoryTuturialTopic")
	public @ResponseBody  List<String> getAllSubcategoriesDeatail(@RequestParam(value="id") int id)
	{

	
	    
	    List<String> topicName=new ArrayList<String>();
		
		//Category cat=categoryService.findBycategoryname(category.getCategoryname());
		
		Category cat=categoryService.findByid(id);
		
		
		System.err.println("category_id"+cat.getId());
	
		List<category_Tutorial> catTut=(List<category_Tutorial>) categoryTutorialDao.findByCategory(cat);
	
		
		//List<category_Tutorial> categoryTuthttp://localhost:8080/indexorials=(List<category_Tutorial>) categoryTutorialDao.findOne(cat);
		
		
		for(category_Tutorial s:catTut)
		{

			topicName.add(s.getTopic().getTopicname());
		
		
		}
		return topicName;   

	}
	
	/*      master Traning Informtion    save */
	 
	
	  @RequestMapping(value = "/traninigMasterInformation")
	  public String addeMaqsterTranierInformation(HttpServletRequest req, Model model, 
	
			  @RequestParam("paricipantsDeatail") MultipartFile[] paricipantsDeatail,
			  @RequestParam("paricipantsPhoto") MultipartFile[] paricipantsPhoto,
			  @RequestParam(name="stateName") String stateName,
			  @RequestParam(value="categoryName") int categoryId,
			/* @RequestParam(name="inputTopic") String inputTopic, */
			   @RequestParam(name="inputTopic") String inputTopic 
		) throws ParseException, IOException
	  
	  {
		  
		  
			String date=req.getParameter("date"); 
			SimpleDateFormat sd1=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateUtil=sd1.parse(date);
			Date dataofCamp=new Date(dateUtil.getTime());
		 
		  Category category=categoryDao.findByid(categoryId);
		  
		  topic topic=topicdao.findBytopicname(inputTopic);
		  
		   String categorName=category.getCategoryname();

		  System.err.println("Hi"+categoryId);
		/* System.err.println("Hi Topic"+inputTopic); */
		  System.err.println("Hi language"+inputTopic);
		  
  
	
		/* String date=req.getParameter("date"); */
		  String participants=req.getParameter("participants");
		  String traningInfo=req.getParameter("traningInformation");
		/* String stateName=req.getParameter("stateName"); */
		  int pincode=Integer.parseInt(req.getParameter("pinCode")); 
		
		  
		  
			String path = null;
			String abc = uploadMasterTrainer + "/" + dataofCamp + inputTopic ;
			
			new File(abc).mkdir();

			StringBuilder fileNames = new StringBuilder();
			for (MultipartFile file : paricipantsDeatail) {

				Path fileNameAndPath = Paths.get(abc,file.getOriginalFilename());

				fileNames.append(file.getOriginalFilename() + " ");

				try {
					Files.write(fileNameAndPath, file.getBytes());
					System.out.println(fileNameAndPath.toString());
					
					mastertrainer = fileNameAndPath.toString();

				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}

			String paricipantsDeatailFile = mastertrainer.substring(26);
			
		
			String masterTrainerPhotoPath = null;
			String masterTrainerPhoto = uploadMasterTrainerPhoto + "/" + dataofCamp + inputTopic;
			new File(masterTrainerPhoto).mkdir();

			StringBuilder fileNamesPhoto = new StringBuilder();
			for (MultipartFile file : paricipantsPhoto) {

				Path fileNameAndPath = Paths.get(masterTrainerPhoto, file.getOriginalFilename());

				fileNamesPhoto.append(file.getOriginalFilename() + " ");

				try {
					Files.write(fileNameAndPath, file.getBytes());
					System.out.println(fileNameAndPath.toString());

					filepath = fileNameAndPath.toString();

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				

			}
			
		
			String participantdeatailPhoto = filepath.substring(26); 
			
		  
		  
			  TraningInformation traningInformationObject=new TraningInformation(category,topic);
			
			  traningInformationObject.setDate(dataofCamp);
			  
			  traningInformationObject.setCategoryname(categorName);

			  
			  traningInformationObject.setTopic(inputTopic);
			 
			  traningInformationObject.setParticipant(participants);
			  traningInformationObject.setTraningInformation(traningInfo);
			  traningInformationObject.setState(stateName);
			  traningInformationObject.setPincode(pincode);
			  
				  traningInformationObject.setParticipant(paricipantsDeatailFile);
			  traningInformationObject.setPhoto(participantdeatailPhoto);
	
  
		  traninigInformationRespositary.save(traningInformationObject);
	
		
		  			
					      String filePath = mastertrainer;
					      String input = null;
					      //Instantiating the Scanner class
					      Scanner sc = new Scanner(new File(filePath));
					      //Instantiating the FileWriter class
					      FileWriter writer = new FileWriter(mastertrainer);
					      //Instantiating the Set class
					      Set set = new HashSet();
					      while (sc.hasNextLine()) {
					         input = sc.nextLine();
					         if(set.add(input)) {
					            writer.append(input+"\n");
					         }
					      }
					      writer.flush();
					      System.out.println("Contents added............");  
					      
					      
					      
		  
		  
					      	
	
				try {
					String line="";
						String file=filePath;
						
						BufferedReader br=new BufferedReader(new FileReader(file));
						
						
				//List<partipantDeatil> participDeatils=(List<partipantDeatil>) participantDao.findAll();
			
					
						while((line=br.readLine())!=null) {
								
							
								String [] data=line.split(",");
								
				
								partipantDeatil participantDeatail=new partipantDeatil();
								
								
								participantDeatail.setFirstname(data[0]);
								participantDeatail.setLastname(data[1]);
								participantDeatail.setEmail(data[2]);
							
								participantDeatail.setAdharNumber(data[3]);
								participantDeatail.setGender(data[4]);
								participantDeatail.setLastname(data[5]);
								
								participantDao.save(participantDeatail);
					
				//	participantService.deleteByQuery(participantDeatail.getParticipantId(),participantDeatail.getAdharNumber());
					
				//	participantDao.deleteByQuery();
			
					//participantDao.deleteByQuery();
			
			}
								
				
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		
		  
		 model.addAttribute("msg","Your record Save Succefully");
		 
		 
		 
	  return "redirect:/adminDeatail";
	
		  
	  }
	  
	  

		/* Here  Edit information UserDeatail id */

		@RequestMapping("editParticipantDeatail/edit/{id}")
		public String editParticipantDeatail(@PathVariable Integer id, Model model, HttpServletRequest req) {

			
			
			partipantDeatil participantDeatail=participantDao.findOne(id);
			

			model.addAttribute("parcipantDeatails", participantDeatail);

			// return "Update_Consalantant"; categoryService

			return "upadateParticipantDeatail";

		}
	 
		
			/* Here code for updation  of master trainer*/
		
	
		@RequestMapping(value = "/updateParticipateDeatail", method = RequestMethod.POST)
		public String updateTetimonial(HttpServletRequest req){
			
			
					String id=req.getParameter("participantId");
							
						int participant_id=Integer.parseInt(id);
						
						System.err.println(participant_id);
				
					   String firstname=req.getParameter("firstName");
				       String lastname=req.getParameter("lastName");
				       String email=req.getParameter("email");
				       String adharNumber=req.getParameter("aadharNumaber");
				     
				       String gender=req.getParameter("gender");
				       String language=req.getParameter("language");
					

				       
		 participantService.updateparticipantDeatail(firstname, lastname, email, adharNumber,gender,language,participant_id);

				
			

			return "redirect:/adminDeatail";
			
			

		}


	/*
	 * here code for feedback
	 */
		
		@RequestMapping("/feedback")
		public String feedbackForm(Model model,HttpServletRequest request){
			
			
			String name=request.getParameter("nameOfMasterTrainer");
			String email=request.getParameter("email");
			String messgae=request.getParameter("traningInformation");
		
				System.err.println(name+"dsds"+email+"jkdjkhasj"+messgae);
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);
			    
			
			feedbackMasterTrainer feedback=new feedbackMasterTrainer();
			
			feedback.setName(name);
			feedback.setEmail(email);
			feedback.setDescription(messgae);
			feedback.setDatetime(currentTime);
			
			feedbackRespositary.save(feedback);
			

			return "redirect:/adminDeatail";
		
	}

	/*
	 * Here we Show deatail information of participant deatail
	 */ 
	  
		@RequestMapping(value = "/show_participantDeatail", method = RequestMethod.GET)
		public String showparticipantDeatail(Model model) {
		
			List<partipantDeatil> participantdeatail=(List<partipantDeatil>) participantDao.findAll();
			
			
		

			model.addAttribute("parcipantDeatails", participantdeatail);

			return "Show_Consaltant";

		}
	  
	  
	/* here we are going to add Quetion */
	  
	  // continue...
	  String 	filequestion;
	  @RequestMapping(value = "/addQuestion")
	  public String addQuestionInformation(HttpServletRequest req, Model model, 
	
			  @RequestParam("questionName") MultipartFile[] questionName,
			  @RequestParam(value="categoryName") int categoryId,
			  @RequestParam(name="inputTopicName") String topicName 
			  ) 
	{
		  
		  topic topic=topicRepositarydao.findBytopicname(topicName);
		  
		  
		 // Tutorial tutorial=tutorialDao.findBylanguage(topicName);
		  	
		  		System.err.println(questionName);
		  		System.out.println("Hi category id"+categoryId);		
				
				
		  		System.err.println("Hi Language"+topicName);
	
		
			String path = null;
	
			String abc = uploadQusetion+"/" +topicName;
			new File(abc).mkdir();

			StringBuilder fileNames = new StringBuilder();
			
			for (MultipartFile file : questionName) {
				
				Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
				fileNames.append(file.getOriginalFilename() + " ");

				try {
					Files.write(fileNameAndPath, file.getBytes());

					filequestion = fileNameAndPath.toString();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			String substring = filequestion.substring(26);

	
			
			
		  Question question=new Question(topic);
		
		  question.setQuetionpath(substring);
	  
		  questionreposiatryDao.save(question);
		  
		  
			model.addAttribute("msg","Record saved successfully");

			
		  System.out.println(substring);
		
		 return "addUploadQuestion";
		 
	  }
	
	  
	  @RequestMapping("/downloadQuestion")
		public @ResponseBody  List<String> getAllQuestion(@RequestParam(name="id") String  topic)
	{

		  System.err.println("topic is"+topic);
		  
		    List<String> topicName=new ArrayList<String>();
		
			topic topicDemo=topicRepositarydao.findBytopicname(topic);
		
			List<Question> question=(List<Question>) questionreposiatryDao.findByTutorial(topicDemo);
			
		
			
			for(Question s:question)
			{

				//String substring=s.getQuetionpath().substring(23);
				
				topicName.add(s.getQuetionpath());
				
			}
		
			return topicName;   

		}
	  
	  
		@RequestMapping("reviewOnContenet/edit/{id}")
		public String editConsaltant(@PathVariable Integer id, Model model, HttpServletRequest req) 
		{

			Consaltantant consaltantant = consaltantservice.getProductById(id);

			model.addAttribute("products", consaltantant);

			// return "Update_Consalantant"; categoryService

			return "Update _ConsalantantTwo";
		}
		
		
		@RequestMapping("/uploadContributerTutorial")
		public String revokeRequest(Model model,Authentication authentication) 
	{
		
		  User user=userRepository.findByUsername(authentication.getName());
	 
		 List<Tutorial> contributorRole= tutorialDao.findByContributorRole(user);
		 
		 ArrayList<String> categoryAdd=new ArrayList<>();
		 
			 for(Tutorial tutorial : contributorRole) 
			 {				
				 categoryAdd.add(tutorial.getCategory().getCategoryname());	
			 }
			 
			 HashSet<String> setcategory=new HashSet<String>(categoryAdd); 
		
			 model.addAttribute("categorys",setcategory);
			
						
			return "selectFossTopicLan";
	
		}
		
		@RequestMapping("/addLanguage")
		public String addLanguage(Model model,HttpServletRequest req,Authentication authentication) 
		{
		
			String  language=req.getParameter("languageName");

			
			if (language==null){
				
				model.addAttribute("msg", true);
				return "addlanguage";
				
			}
			
			
			
		if(languageDao.findBylanguageName(language)!=null) {
					
				model.addAttribute("msg1", true);
					
					return "addlanguage";
					
		}

			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

			String currentTime = sdf.format(dt);
			
			com.health.model.language lan=new com.health.model.language();
			
					lan.setLanguageName(language);
				
					lan.setTimedate(getCurrentTime());
					
					lan.setCreatedBy(authentication.getName());
					
					languageDao.save(lan);
					
			System.err.println(language);
			
			model.addAttribute("msgSuccefull",RECORD_SAVE_SUCCESS_MSG);

			return "addlanguage";

			}
		
		//access topic accoring to category into master trainer
		
		@RequestMapping("/loadByCategoryByTopic")
		public @ResponseBody  List<String> getTopicByCategory(@RequestParam(value="id") int id)
		{  
			
			
	
		    List<String> topicName=new ArrayList<String>();
			

			Category cat=categoryService.findByid(id);
			
			
			System.err.println("category_id"+cat.getId());
			
		
		  List<topic> topic=(List<topic>) topicRepositarydao.findByCategory(cat);
		  
		  for(topic s:topic) 
		  {
		  
			  topicName.add(s.getTopicname());
			  System.err.println(s.getTopicname());
		  
		  }
			return topicName;  
			
	}
		
			/*
			 * load by languageBy topic 
			 */
		
		@RequestMapping("/loadByLangugaeTopic")
		public @ResponseBody  List<String> getLanguageByTopic(@RequestParam(value="id") int id)
		{  
			
			    List<String> topicName=new ArrayList<String>();
				
	
				topic topic=topicRepositarydao.findOne(id);
				topic.getTopicid();
		
				List<topic> listlanguage=(List<topic>) topicRepositarydao.findOne(topic.getTopicid());
		
		  
				for(topic s:listlanguage) 
				{
				
				  
				  
				}
		
			return topicName;  
		
		}
		
		@RequestMapping("/displayQuestion")
		public String displatQuestion(@RequestParam(name="inputLanguage") String  topic,Model model) 
		{
			
			System.err.println("hi");
			    List<String> topicName=new ArrayList<String>();
			
				topic topicDemo=topicRepositarydao.findBytopicname(topic);
				
				
				List<Question> question=(List<Question>) questionreposiatryDao.findByTutorial(topicDemo);

				for(Question s:question)
				{

					//String substring=s.getQuetionpath().substring(23);						
					topicName.add(s.getQuetionpath());					
				}			
				model.addAttribute("questions",question);
		
				return "questionInPdf";
		
		}
		
		/* Here load language according to contributor selectopn language */
		
		@RequestMapping("/loadlanguage")
		public @ResponseBody  List<String> getloadlanguage(@RequestParam(value="id") int id,Authentication authetication)
		{  
			
			
		/* UserRole userRole=UserRoleRepositary. */
			
				String contributorName=authetication.getName();
				
				List<com.health.model.language> loadlanguages= (List<com.health.model.language>) languageDao.findAll();
				
				
				System.err.println("Contributort Name"+contributorName);
				
			
			    List<String> topicName=new ArrayList<String>();
	    
			    List<com.health.model.language> language= (List<com.health.model.language>) languageDao.findAll();
			    
			    for(com.health.model.language  lan:language) 
			    {
			    
			    	topicName.add(lan.getLanguageName());
		
			    }			  	
			return topicName;  
		
		}
		  
	
		/* Add New Role into Role table */
		
		@RequestMapping(value = "/addRole", method = RequestMethod.POST)
		public String addRole(Model model,HttpServletRequest request) {
			
			String rolename=request.getParameter("roleName");
		
			if(rolerespositary.findByname(rolename)!=null) {
				model.addAttribute("msg", true);
				return "addNewRole";				
			}			
			Role role=new Role();
			
			role.setName(rolename);	
			rolerespositary.save(role);

			model.addAttribute("msgSucuploadContributerTutorialcefull",RECORD_SAVE_SUCCESS_MSG);	

			return "addNewRole";
		}
		
		
	/* Accessing the value for approve contributors */
		
		@RequestMapping("/addContributerRoleById")
		public @ResponseBody  List<String> approveContributor(@RequestParam(value="id") Long id,Model model)
		{
			
			
			List<String> topicName=new ArrayList<>();
		
			UserRole userRoles =userRoleRepositary.findOne(id);
		
			String name = "Contributer";
			
			Role role = rolerespositary.findByname(name);	
			int status = 1;
			
			UserRole userRole = userRoleRepositary.findByContributorId(userRoles.getUserRoleId(),role);	
				
			userRole.setStatus(status);	
			userRoleRepositary.save(userRole);
		
			topicName.add(ROLE_APPROVE_SUCCESS_MSG);
						
			return topicName;

		}
		
		
		@RequestMapping("/addDomainRoleById")
		public @ResponseBody  List<String> approveDomain(@RequestParam(value="id") Long id,Model model)
		{
			
			List<String> topicName=new ArrayList<>();
		
			UserRole userRoles =userRoleRepositary.findOne(id);
		
			String name = "DomainReviweer";
			
			Role role = rolerespositary.findByname(name);	
			int status = 1;
			
			UserRole userRole = userRoleRepositary.findByContributorId(userRoles.getUserRoleId(),role);	
				
			userRole.setStatus(status);	
			userRoleRepositary.save(userRole);
		
			topicName.add(ROLE_APPROVE_SUCCESS_MSG);
						
			return topicName;

		}
		
		@RequestMapping("/addAdminRoleById")
		public @ResponseBody  List<String> approveAdmin(@RequestParam(value="id") Long id,Model model)
		{
			
			List<String> topicName=new ArrayList<>();
		
			UserRole userRoles =userRoleRepositary.findOne(id);
		
			String name = "VideoReviwer";
			
			Role role = rolerespositary.findByname(name);	
			int status = 1;
			
			UserRole userRole = userRoleRepositary.findByContributorId(userRoles.getUserRoleId(),role);	
				
			userRole.setStatus(status);	
			userRoleRepositary.save(userRole);
		
			topicName.add(ROLE_APPROVE_SUCCESS_MSG);
						
			return topicName;

		}
		
		@RequestMapping("/addQualityRoleById")
		public @ResponseBody  List<String> addQualityRoleById(@RequestParam(value="id") Long id,Model model)
		{
			
			List<String> topicName=new ArrayList<>();
		
			UserRole userRoles =userRoleRepositary.findOne(id);
		
			String name = "QualityReviweer";
			
			Role role = rolerespositary.findByname(name);	
			int status = 1;
			
			UserRole userRole = userRoleRepositary.findByContributorId(userRoles.getUserRoleId(),role);	
				
			userRole.setStatus(status);	
			userRoleRepositary.save(userRole);
		
			topicName.add(ROLE_APPROVE_SUCCESS_MSG);
						
			return topicName;

		}
		
		@RequestMapping("/addMasterRoleById")
		public @ResponseBody  List<String> addMasterRoleById(@RequestParam(value="id") Long id,Model model)
		{
			
			List<String> topicName=new ArrayList<>();
		
			UserRole userRoles =userRoleRepositary.findOne(id);
		
			String name = "MasterTrainer";
			
			Role role = rolerespositary.findByname(name);	
			int status = 1;
			
			UserRole userRole = userRoleRepositary.findByContributorId(userRoles.getUserRoleId(),role);	
				
			userRole.setStatus(status);	
			userRoleRepositary.save(userRole);
		
			topicName.add(ROLE_APPROVE_SUCCESS_MSG);
						
			return topicName;

		}
		
		
		
		
		
		
		
		
		
		
		
		
		@RequestMapping("/rejectContributorById")
		public @ResponseBody  List<String> rejectContributor(@RequestParam(value="id") Long id,Model model)
		{
			
			System.err.println(id);			
			List<String> topicName=new ArrayList<>();
		
			UserRole userRoles =userRoleRepositary.findOne(id);
			
		
			String name = "Contributer";
			Role role = rolerespositary.findByname(name);
			
			int status = 0;
			UserRole userRole = userRoleRepositary.findByContributorId(userRoles.getUserRoleId(),role);		
			userRole.setStatus(status);	
			userRoleRepositary.save(userRole);
		
			topicName.add("Reject Role Successfully");
						
			return topicName;

		}
		
		/* Accesing language according to user contributor */
		
		@RequestMapping("/loadLanguageByUser")
		public @ResponseBody  List<String> getLanguageByUser(@RequestParam(value="id") String username)
		{
			
		User userExit=userRepository.findByUsername(username);	
			
		List<Tutorial> tutorial=tutorialDao.findByContributorRole(userExit);
			
		ArrayList<String> tutorialLanguageExits=new ArrayList<String>();
		
		
	 for (Tutorial tutoriaLanguage : tutorial)
		 {
			 
			 tutorialLanguageExits.add(tutoriaLanguage.getLan().getLanguageName());			
		 }
	 
	 
	 for (String string : tutorialLanguageExits) {
			
			
			System.err.println("alerecdy exit"+string);
			
		}
		 
		List<String> topicName=new ArrayList<String>();
		
		User user=userRepository.findByUsername(username);
		
		int status=1;
		
		List<UserRole> userrole=userRoleRepositary.findByUserAndStatuslanguages(status,user);
				
		for (UserRole ur : userrole) 
		{	
			
			topicName.add(ur.getLanguage().getLanguageName());		
		}
		
		
		//topicName.removeAll(tutorialLanguageExits);
		
			return topicName;  			
	}	
		
		
		/* Accesing category according to user contributor */	
		
		@RequestMapping("/loadCategoryByLanguage")
		public @ResponseBody  List<String> getCategoryByUser(@RequestParam(value="id") String id)
		{  
			int status=1;
			
			List<String> topicName=new ArrayList<String>();
			
			List<Category> category=(List<Category>)categoryDao.findBystatus(status);
		
			for (Category cat : category) 
			{				
				topicName.add(cat.getCategoryname());
				
			}
			
			return topicName;  	
		}
		
		@RequestMapping("/loadTopicByCategory")
		public @ResponseBody  List<String> getTopicByCategoryName(@RequestParam(value="id") String categoryName)
		{  		
			
		/* System.err.println(category name); */
			
		    List<String> topicName=new ArrayList<String>();
		    		
			Category cat=categoryService.findBycategoryname(categoryName);
			
			//System.err.println("category_id"+cat.getId());
		
			List<topic> topic=(List<topic>) topicRepositarydao.findByCategory(cat);
		  
			  for(topic s:topic) 
			  {
			  
				  topicName.add(s.getTopicname());
				 	  
			  }		
			  
			  return topicName;  
					
		}
		
		/*Contribution Role saving into foreign key */
		
		@RequestMapping(value = "/contribution_roles", method = RequestMethod.POST)
		public String contributionRole(Model model,@RequestParam(name="contributorName") String contributorId,
				@RequestParam(name="languageName") String inputLanguage,
				@RequestParam(name="contributorCategory") String contributorCategory,
				@RequestParam(name="inputTopic") String inputTopic,
				@RequestParam(value = "checkboxName", required = false) String checkboxValue)
	{
			
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String currentTime = sdf.format(dt);
		
			//User user=userRepository.findOne(contributorId);
			
		User user=userRepository.findByUsername(contributorId);
			
		com.health.model.language language=languageDao.findBylanguageName(inputLanguage);
		
		Category category=categoryDao.findBycategoryname(contributorCategory);
		
		topic topic=topicdao.findBytopicname(inputTopic);
		
		
		contributor_Role contributorRole=new contributor_Role();
		
		contributorRole.setUser(user);
		contributorRole.setLan(language);
		contributorRole.setCategory(category);
		contributorRole.setTopic(topic);
		
	
		contributorRole.setDate(currentTime);
		
		 if(checkboxValue != null)
		  {
			 contributorRole.setStatus(1);
		  }
		  else
		  {
			  contributorRole.setStatus(0);
		  }
		 
		contributorRoleDao.save(contributorRole);
		
		Tutorial tutorialDaoSave=new Tutorial();
		
		tutorialDaoSave.setUser(user);
		tutorialDaoSave.setLan(language);
		tutorialDaoSave.setCategory(category);
		tutorialDaoSave.setTopic(topic);
		tutorialDaoSave.setDate(currentTime);		
		
		tutorialDaoSave.setKeywordStatusSet(0);
		tutorialDaoSave.setOutlineStatus(0);
		tutorialDaoSave.setSlideStatus(0);
		

		tutorialDao.save(tutorialDaoSave);
		
		model.addAttribute("msg",RECORD_SAVE_SUCCESS_MSG);
			
			return "showAdminContributorList";
		
	}
		
	/*
	 * @RequestMapping("/loadCategoryAndLanguage") public @ResponseBody List<String>
	 * viewVideoContent(
	 * 
	 * @RequestParam(value = "categorname") String categorname,
	 * 
	 * @RequestParam(value = "topicid") String topicid,
	 * 
	 * @RequestParam(value = "lanId") String lanId,Model model,Authentication
	 * authentication) {
	 * 
	 * 
	 * List<Tutorial> tutorialRes=tutorialDao.findByLanAndCat(category,language);
	 * 
	 * return
	 * 
	 * }
	 */
		
		
	 

}
