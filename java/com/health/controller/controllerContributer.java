package com.health.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.District;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.commentOnComponent;
import com.health.model.language;
import com.health.model.state;
import com.health.model.topic;
import com.health.repository.CategoryDao;
import com.health.repository.RoleRepository;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.repository.commentOnComponentDao;
import com.health.repository.contributor_RoleDao;
import com.health.repository.languagedao;
import com.health.repository.stateRespositary;
import com.health.repository.topicRepositary;
import com.health.service.categoryService;
import com.health.service.tutorialService;

@Controller
public class controllerContributer {

	public static final String RECORD_SAVED_SUCCESS_MSG = "Record Saved Successfully !" ;
	public static final String DOMAIN_REV_STATUS_MSG = "Waiting for Domain Review" ;
	public static final String ADMIN_REV_STATUS_MSG = "Waiting for Admin Review" ;
	public static final String QUALITY_REV_STATUS_MSG = "Waiting for Quality Review" ;
	public static final String WAITING_PUBLISH_MSG = "Waiting for publish" ;
	public static final String NEED_IMPROVEMENT_MSG = "Need for improvement";
	public static final String PENDING = "Pending";

	public static final int NO_CONTENT_ADDED = 0;
	public static final int WAITING_FOR_DOMAIN_REV = 1;

	public static String uploadDirectoryCreation = "src/main/resources/static" + "/Media/content" + "/Creation/Slide";

	public static String uploadDirectoryCreationScripts = "src/main/resources/static" + "/Media/content" + "/Creation/Script";

	public static String uploadDirectoryCreationVideo = "src/main/resources/static" + "/Media/content" + "/Creation/Video";

	public static String uploadDirectoryCreationVideo1 = "/Media/content" + "/Creation/Video";

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
	private commentOnComponentDao commentOnComponentDao;


	@Autowired
	private tutorialService tutorialService;

	@Autowired
	private CategoryDao categoryDao;
	

	@RequestMapping("/addContributerLanguage")
	public String RevokeRequest(Model model)
	{

		List<language> language = languageDao.findAll();

		model.addAttribute("lan", language);


		return "AddContributerLanguage";

	}

	/* show languages */
	@RequestMapping("/rovekeRequest")
	public String  revokelanguage(Model model,Authentication authentication)
	{

		int status=1;
		User user=userRepository.findByUsername(authentication.getName());

		List<UserRole> userRole=userRoleRepositary.findByStatusAndUser(status,user);

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


		int outlineStatusUpdate=1;

		tutorialService.updateOutline(outlineMessagae,outlineStatusUpdate, user,topic,category);

		topicName.add("Save Outline successfully");

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


			  topicName.add(RECORD_SAVED_SUCCESS_MSG);

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
		  topicName.add(file.getOriginalFilename());

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


			topicName.add(substring);

			topicName.add(RECORD_SAVED_SUCCESS_MSG);

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
		  topicName.add(file.getOriginalFilename());

		  try {


			  Files.write(fileNameAndPath, file.getBytes());

		  fileconversion =fileNameAndPath.toString();


		  } catch (IOException e) { e.printStackTrace(); } }


		  String substring = fileconversion.substring(26);
		  String slide = substring.toString();


				int slideStatus = 1;

		tutorialService.updateSlide(slide,slideStatus,user,topic,category);
		topicName.add(slide);
			 topicName.add(RECORD_SAVED_SUCCESS_MSG);


			return topicName;

		 }
		  
		  
	/* Here is code for graphics upload */

		  @RequestMapping(value = "/graphicsUpload",method =RequestMethod.POST)
		  public @ResponseBody List<String>
		  getGraphicsUpload(@RequestParam(value = "uploadGraphicUpload") MultipartFile [] graphicsFile,
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
			  
				
				new File(abc).mkdir();

				StringBuilder fileNames = new StringBuilder();
				for (MultipartFile file : graphicsFile) {
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
				
				int status=1;

			tutorialService.updateSlide(var,status,user,topic,category);
			
			topicName.add(var);
			
				 topicName.add(RECORD_SAVED_SUCCESS_MSG);


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


//			  String abc = uploadDirectoryCreationVideo + "/" + categorname + "/"+ lanId + "/"+ topicid;


			  Path currentPath = Paths.get(System.getProperty("user.dir"));
//			  String filePath = String.join(File.pathSeparator, currentPath.toString(), categorname,lanId,topicid);

			  Path filePath = Paths.get(currentPath.toString(), uploadDirectoryCreationVideo,categorname,lanId,topicid);
			  String fp=  filePath.toString();
//		      Path videoFilePath = Paths.get(currentPath.toString(), filePath);
//			  String file= csvFilePath.toString();

			  new File(fp).mkdirs();

			  StringBuilder fileNames = new StringBuilder();
			  for (MultipartFile file : videofile)

			  { Path fileNameAndPath = Paths.get(fp,
			  file.getOriginalFilename()); fileNames.append(file.getOriginalFilename() + " ");
			  topicName.add(file.getOriginalFilename());

			  try {
				  Files.write(fileNameAndPath, file.getBytes());
			  fileconversion =fileNameAndPath.toString();


			  } catch (IOException e) { e.printStackTrace(); } }



			  Path filePath1 = Paths.get(uploadDirectoryCreationVideo1,categorname,lanId,topicid);

//			  String substring = fileconversion.substring(26);
			  int firstIndex = fileconversion.indexOf("/Media");
			  String substring = fileconversion.substring(firstIndex);
			  String videopath = substring.toString();
//			  String videopath = filePath1.toString();


			  System.err.println("path is"+videopath.toString());

			  int videoStatus = 1;


			  topicName.add(videopath);
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



		    topicName.add(RECORD_SAVED_SUCCESS_MSG);

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


		    topicName.add(RECORD_SAVED_SUCCESS_MSG);

			return topicName;

		 }



			/* selectFossTopic
			 * Access the topic according to category  */


			@RequestMapping("/loadTopicByCategoryContributor")
			public @ResponseBody  Set<String> getTopicByCategoryContributor(@RequestParam(value="id") String categoryname,Authentication autheticateion)
			{

			    ArrayList<String> topicName=new ArrayList<String>();

			    User user=userRepositorydao.findByUsername(autheticateion.getName());

				Category category=categoryService.findBycategoryname(categoryname);

			//	List<contributor_Role> contributor=contributor_RoleDao.findByContributorTopic(user,category);

				List<Tutorial>  tutiorial=tutorialDao.findByContributorTopic(user,category);

				  for(Tutorial s: tutiorial)
				  {
					  topicName.add(s.getTopic().getTopicname());

				  }

				  Set<String> disticttopic=new HashSet<>(topicName);


				  return disticttopic;


			}

			//load  Topic by catgory inTutorial Upload Index


			@RequestMapping("/loadLanguageByTopicId")
			public @ResponseBody  Set<String> getLanguageByTopic(@RequestParam(value="id") String TopicName,Authentication authetication)
			{

			System.err.println("TopicName is"+TopicName);

			    ArrayList<String> topicName=new ArrayList<String>();


			    User user=userRepositorydao.findByUsername(authetication.getName());

			    topic topic=topicRepositarydao.findBytopicname(TopicName);

				List<Tutorial> tutorialByTopic=tutorialDao.findByTopicByLanguage(user,topic);



				 for(Tutorial s : tutorialByTopic)
				  {

					 topicName.add(s.getLan().getLanguageName());
				  }

				 Set<String> topicnameDistict=new HashSet<String>(topicName);

				return topicnameDistict;

			}


		/* Tutorial index page redirected to upload individual content page */

		@RequestMapping("/submitTutorial")
		public String submitTutorial(Model model,@RequestParam(value="categoryName") String categoryId,@RequestParam(name="inputTopic") String inputTopic,@RequestParam(name="inputLanguage") String inputLanguage,Authentication authetication)	
		{
		
		      	List<Category> catAll=(List<Category>) categoryDao.findAll();
				
				Category catgory=categoryDao.findBycategoryname(categoryId);
				topic topic=topicRepositarydao.findBytopicname(inputTopic);
				com.health.model.language language=languageDao.findBylanguageName(inputLanguage);

				List<Tutorial> tutorial=tutorialDao.findByCategoryTutorialAndlanguage(catgory,language,topic);
				for (Tutorial t : tutorial)
				{
//					set status of outline, script, slide and keyword
					String[] outlineStatus = {PENDING, DOMAIN_REV_STATUS_MSG,"" ,QUALITY_REV_STATUS_MSG,WAITING_PUBLISH_MSG ,NEED_IMPROVEMENT_MSG};
					model.addAttribute("statusOutline",outlineStatus[t.getOutlineStatus()]);
					model.addAttribute("statusScript", outlineStatus[t.getScriptStatus()]);
					model.addAttribute("statusSlide",outlineStatus[t.getSlideStatus()]);
					model.addAttribute("statusKeyword",outlineStatus[t.getKeywordStatusSet()]);

//					set status of video
					String[] videoStatus = {PENDING, ADMIN_REV_STATUS_MSG,DOMAIN_REV_STATUS_MSG,QUALITY_REV_STATUS_MSG,WAITING_PUBLISH_MSG ,NEED_IMPROVEMENT_MSG};
					model.addAttribute("statusVideo",videoStatus[t.getVideoStatus()]);


					boolean[] uploadIcon = new boolean[6]; //default value is false
					uploadIcon[NO_CONTENT_ADDED] = true;
					uploadIcon[WAITING_FOR_DOMAIN_REV] = true;
					Boolean[] statusOutlineTrue = new Boolean[6];
					Arrays.fill(statusOutlineTrue, Boolean.TRUE);
					statusOutlineTrue[NO_CONTENT_ADDED] = false;
					statusOutlineTrue[2] = false;



					/* outline */

					model.addAttribute("uploadIcon",uploadIcon[t.getOutlineStatus()]);
					model.addAttribute("statusOutlineTrue",statusOutlineTrue[t.getOutlineStatus()]);

					/* script */
					boolean[] scriptUploadIcon = new boolean[6]; //default value is false
					scriptUploadIcon[NO_CONTENT_ADDED] = true;

					model.addAttribute("uploadIcon",scriptUploadIcon[t.getScriptStatus()]);
					model.addAttribute("statusScriptTrue",statusOutlineTrue[t.getScriptStatus()]);

					/* slide */
					boolean[] slideUploadIcon = new boolean[6]; //default value is false
					slideUploadIcon[NO_CONTENT_ADDED] = true;

					model.addAttribute("uploadIcon",slideUploadIcon[t.getSlideStatus()]);
					model.addAttribute("statusSlideTrue",statusOutlineTrue[t.getSlideStatus()]);

					/* video */

					boolean[] videoUploadIcon = new boolean[6]; //default value is false
					videoUploadIcon[NO_CONTENT_ADDED] = true;
					Boolean[] statusVideoTrue = new Boolean[6];
					Arrays.fill(statusVideoTrue, Boolean.TRUE);
					statusVideoTrue[NO_CONTENT_ADDED] = false;

					model.addAttribute("uploadIcon",videoUploadIcon[t.getVideoStatus()]);
					model.addAttribute("statusVideoTrue",statusVideoTrue[t.getVideoStatus()]);

					/* keyword */
					boolean[] keywwordUploadIcon = new boolean[6]; //default value is false
					keywwordUploadIcon[NO_CONTENT_ADDED] = true;

					model.addAttribute("uploadIcon",keywwordUploadIcon[t.getKeywordStatusSet()]);
					model.addAttribute("statusKeywordTrue",statusOutlineTrue[t.getKeywordStatusSet()]);




//								if(t.getOutlineStatus()==0)
//								{
//									model.addAttribute("statusOutline","Pending");
//									model.addAttribute("uploadIcon",true);
//
//								}else if (t.getOutlineStatus()==1)
//								{
//									model.addAttribute("statusOutline",DOMAIN_REV_STATUS_MSG);
//									model.addAttribute("statusOutlineTrue", true);
//									model.addAttribute("uploadIcon",true);
//
//
//
//								}else if(t.getOutlineStatus()==3){
//									model.addAttribute("statusOutline",QUALITY_REV_STATUS_MSG);
//									model.addAttribute("statusOutlineTrue", true);
//
//
//
//								}else if(t.getOutlineStatus()==5)
//								{
//
//									model.addAttribute("statusOutline",NEED_IMPROVEMENT_MSG);
//									model.addAttribute("statusOutlineTrue", true);
//
//								}else if (t.getOutlineStatus()==4) {
//
//									model.addAttribute("statusOutline","Waiting For Publish");
//									model.addAttribute("statusOutlineTrue", true);
//
//								}




//								if(t.getScriptStatus()==0)
//								{
//
//									model.addAttribute("statusScript", "Pending");
//									model.addAttribute("uploadIcon",true);
//
//								}else if (t.getScriptStatus()==1)
//								{
//
//									model.addAttribute("statusScript",DOMAIN_REV_STATUS_MSG);
//									model.addAttribute("statusScriptTrue", true);
//
//								}else if(t.getScriptStatus()==3){
//
//									model.addAttribute("statusScript",QUALITY_REV_STATUS_MSG);
//									model.addAttribute("statusScriptTrue", true);
//
//
//								}else if(t.getScriptStatus()==4){
//
//									model.addAttribute("statusScript",WAITING_PUBLISH_MSG);
//									model.addAttribute("statusScriptTrue", true);
//
//
//								}
//								else if(t.getScriptStatus()==5)
//								{
//									model.addAttribute("statusScript","Need To Impprovement");
//									model.addAttribute("statusScriptTrue", true);
//
//
//								}

			/* script */

//								if(t.getSlideStatus()==0)
//								{
//
//									model.addAttribute("statusSlide", "Pending");
//									model.addAttribute("uploadIcon",true);
//
//								}else if (t.getSlideStatus()==1)
//
//								{
//
//									model.addAttribute("statusSlide",DOMAIN_REV_STATUS_MSG);
//									model.addAttribute("statusSlideTrue", true);
//
//								}else if(t.getSlideStatus()==3){
//
//									model.addAttribute("statusSlide",QUALITY_REV_STATUS_MSG);
//									model.addAttribute("statusSlideTrue", true);
//
//								}
//
//								else if(t.getSlideStatus()==5){
//
//									model.addAttribute("statusSlide",NEED_IMPROVEMENT_MSG);
//									model.addAttribute("statusSlideTrue", true);
//
//								}else if (t.getOutlineStatus()==4) {
//
//
//									model.addAttribute("statusSlide",WAITING_PUBLISH_MSG);
//									model.addAttribute("statusSlideTrue", true);
//
//								}


			/*	Video	*/


//								if(t.getVideoStatus()==0)
//								{
//
//									model.addAttribute("statusVideo", "Pending");
//									model.addAttribute("uploadIcon",true);
//
//								}
//								else if (t.getVideoStatus()==1)
//								{
//
//									model.addAttribute("statusVideo","Wating for Admin Review");
//									model.addAttribute("statusVideoTrue", true);
//
//								}else if (t.getVideoStatus()==2)
//								{
//
//										model.addAttribute("statusVideo",DOMAIN_REV_STATUS_MSG);
//										model.addAttribute("statusVideoTrue", true);
//
//								}
//								else if (t.getVideoStatus()==3)
//								{
//
//									model.addAttribute("statusVideo",QUALITY_REV_STATUS_MSG);
//									model.addAttribute("statusVideoTrue", true);
//
//								}
//								else if(t.getVideoStatus()==5)
//								{
//
//									model.addAttribute("statusVideo",NEED_IMPROVEMENT_MSG);
//									model.addAttribute("statusVideoTrue", true);
//
//								}else if (t.getOutlineStatus()==4)
//								 {
//
//									 model.addAttribute("statusVideo",WAITING_PUBLISH_MSG);
//									 model.addAttribute("statusVideoTrue", true);
//								}

			/*	keyword*/

//								if(t.getKeywordStatusSet()==0)
//								{
//
//									model.addAttribute("statusKeyword", "Pending");
//									model.addAttribute("uploadIcon",true);
//
//								}else if (t.getKeywordStatusSet()==1)
//
//								{
//									model.addAttribute("statusKeyword",DOMAIN_REV_STATUS_MSG);
//									model.addAttribute("statusKeywordTrue", true);
//
//								}else if (t.getKeywordStatusSet()==3) {
//
//									model.addAttribute("statusKeyword",QUALITY_REV_STATUS_MSG);
//									model.addAttribute("statusKeywordTrue", true);
//
//
//								}else if (t.getOutlineStatus()==4)
//								{
//
//									model.addAttribute("statusKeyword",WAITING_PUBLISH_MSG);
//									model.addAttribute("statusKeywordTrue", true);
//
//								}
//
//								else if(t.getKeywordStatusSet()==5)
//								{
//
//									model.addAttribute("statusKeyword",NEED_IMPROVEMENT_MSG);
//									model.addAttribute("statusKeywordTrue", true);
//
//								}


				}

		for (Tutorial tutorial2 : tutorial) {

		Tutorial tutorialobject=tutorialDao.findOne(tutorial2.getTutorialid());

		List<commentOnComponent> commentComponent=commentOnComponentDao.findBytutorial_id(tutorialobject);


			  for (commentOnComponent mesComment : commentComponent) {


				if(mesComment.getCommentId()!=0)
				{

				  System.err.println(mesComment.getCommentId());
				  System.err.println(mesComment.getCommentInfo());
				  System.err.println(mesComment.getComponenenetDeatail());


				  model.addAttribute("title",mesComment.getComponenenetDeatail());
				  model.addAttribute("messageBody",mesComment.getCommentInfo());


				  model.addAttribute("msg",mesComment.getCommentId());


				  }

			  }

			model.addAttribute("CommentMsg",commentComponent);


		}


				model.addAttribute("tutorial",tutorial.get(0));
				model.addAttribute("catAll",catAll);
				model.addAttribute("tutorials",tutorial);


				model.addAttribute("categoryName",catgory);

				model.addAttribute("inputTopic",topic);

				model.addAttribute("inputLanguage",language);

				String authticationName=authetication.getName();

				User user=userRepository.findByUsername(authticationName);

				return "addContent";

				
			}

		/* Here is code for pre Requistic */
		
		
		
		@Autowired
		private stateRespositary stateRespositaryDao;
		
		
		@Autowired
		private languagedao languagedao; 
		
		
		@RequestMapping("/loadTopicByPreRequistic")
		public @ResponseBody List<String> getPrerequistic(@RequestParam(value = "id") int id,@RequestParam(value="lanId") String lanName) {

			
		ArrayList<String> file=new ArrayList<String>();	

		Category category=categoryDao.findByid(id);
		
		language languaage=languagedao.findBylanguageName(lanName);
		
		
		List<Tutorial> tutorial=tutorialDao.findByCatAndLan(category, languaage);
		
		for (Tutorial tutorial2 : tutorial){
			
			 file.add(tutorial2.getTopic().getTopicname());
			
		}
		
		return file;

		}
		
		
		
		
		
		
		
		/* write code for keyword view  addcontent*/

		@RequestMapping("/viewKeyword")
		  public @ResponseBody List<String>
		  viewKeywordContent(
				  @RequestParam(value = "categorname") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
		 {

			  System.err.println(categorname);

			  List<String> topicName = new ArrayList<String>();

			  User user=userRepository.findByUsername(authentication.getName());

			  topic topic = topicRepositaryDao.findBytopicname(topicid);

			  Category category=categoryDao.findBycategoryname(categorname);

			  language language=languageDao.findBylanguageName(lanId);

			  int status = 1;

			  Tutorial tutorial=tutorialDao.finByKeywordContent(user,topic,category,language);

			  topicName.add(tutorial.getKeyword());

			return topicName;

		 }

			/* here is view Video into contributor Side */

		@RequestMapping("/viewVideo")
		  public @ResponseBody List<String>
		  viewVideoContent(
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

			  Tutorial tutorial=tutorialDao.finByKeywordContent(user,topic,category,language);


			  videoframe.add(tutorial.getVideo());


			return videoframe;

		 }

	/*
	 * Contributor View for outline View
	 */

		@RequestMapping("/outlineView")
		  public @ResponseBody List<String>
		  viewOutlineContent(
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

			  Tutorial tutorial=tutorialDao.finByKeywordContent(user,topic,category,language);

			  videoframe.add(tutorial.getOutlin());

			return videoframe;

		 }



		@RequestMapping("/scriptPdf")
		  public @ResponseBody List<String>
		  viewScriptPdf(
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

			  Tutorial tutorial=tutorialDao.finByKeywordContent(user,topic,category,language);

			  script.add(tutorial.getScript());

			  return script;

		}
		@RequestMapping("/sliedPdf")
		  public @ResponseBody List<String>
		  viewSlidePdf(
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

			  Tutorial tutorial=tutorialDao.finByKeywordContent(user,topic,category,language);

			  script.add(tutorial.getSlide());


			  	return script;

		 }


		@RequestMapping("/contributorComponenentStatus")
		public String contributorStausComponenent(Model model,Authentication authentication)
		{

			User user=userRepository.findByUsername(authentication.getName());
			List<Tutorial> tutorial=(List<Tutorial>) tutorialDao.findAll();

			List<Tutorial> contributorRole= tutorialDao.findByContributorRole(user);

//			model.addAttribute("listContributorListAcceptOrNeeToImp",tutorial);
			model.addAttribute("listContributorListAcceptOrNeeToImp",contributorRole);




			return "listTutorialContributorAccepOrNeedToImprovement";

		}
		

		// Here is code for pre-requistic
		
		@RequestMapping("/savePathTutorial")
		public String savePathTutorial(@RequestParam(value="catAllID") String categoryName,@RequestParam(value="inputTopicPre") String[] inputTopic)		
		{
				System.err.println(inputTopic.toString());
				System.err.println(categoryName);
			
				
			return "listTutorialContributorAccepOrNeedToImprovement";
			

		}
		
		
		
		
		
						
		







}
