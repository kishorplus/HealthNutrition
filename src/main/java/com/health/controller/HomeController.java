package com.health.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.health.domain.security.PasswordResetToken;
import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Consaltantant;
import com.health.model.Event;
import com.health.model.Testimonial;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.state;
import com.health.repository.CategoryDao;
import com.health.repository.ConsaltantDao;
import com.health.repository.EventDao;
import com.health.repository.TestimonialDao;
import com.health.repository.TutorialDao;
import com.health.repository.stateRespositary;
import com.health.service.UserService;
import com.health.service.categoryService;
import com.health.service.impl.UserSecurityService;
import com.health.utility.MailConstructor;
import com.health.utility.SecurityUtility;

@Controller
public class HomeController {

	
	private static final List<Consaltantant> List = null;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private UserSecurityService userSecurityService;

	@Autowired
	private categoryService categoryservice;
	
	@Autowired
	private stateRespositary statedao;
	
	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private TestimonialDao testimonialdao;
	
	@Autowired
	private ConsaltantDao consalatantDao;
	
	@Autowired
	private TutorialDao tutorialDao;
	
	
	@RequestMapping("/viewVideo/view/{id}")
	public String viewVideo(Model model,@PathVariable Integer id)
	{
	
		Tutorial tutorials=tutorialDao.findOne(id);
		
		int status=1;
		
		List<Tutorial> tutorialRes=tutorialDao.findByLanAndCat(tutorials.getCategory(),tutorials.getLan(),status);

		 model.addAttribute("list",tutorials);
		 model.addAttribute("listOfTutorial",tutorialRes);
		
		 
		return "showVideo";
	}	
	
	@RequestMapping("/viewVideoList/view/{id}")
	public String viewVideoList(Model model,@PathVariable Integer id)
	{
	
		Tutorial tutorials=tutorialDao.findOne(id);
		
		tutorials.getTopic().getTopicname();
		int status=1;
		
		List<Tutorial> tutorialRes=tutorialDao.findByLanAndCat(tutorials.getCategory(),tutorials.getLan(),status);

		 model.addAttribute("list",tutorials);
		 model.addAttribute("listOfTutorial",tutorialRes);
		
		return "showVideo";
	}	
	
	
	
	@RequestMapping("/")
	public String index(Model model)
	{

		//List<Category> category=categoryservice.findAll();
		
		List<Tutorial> category=tutorialDao.finBystatus();
		
		ArrayList<String> tutorialRes=new ArrayList<String>();
		
		for (Tutorial tutorial : category){
			
			tutorialRes.add(tutorial.getCategory().getCategoryname());
			
		}
		
		Set<String> categoryList=new LinkedHashSet<String>(tutorialRes);
		
	   System.err.println("Prit list"+categoryList);
		
		
		
		model.addAttribute("categorys",categoryList);
		
		List<Event> event=eventDao.getAllEvent();
			  
		model.addAttribute("events",event);

		List<Consaltantant> consalatant=consalatantDao.findByConsaltantantDate();

		for (Consaltantant consaltantant : consalatant) 
		{			
			System.err.println(consaltantant.getNameConsaltant());	
		}		
		List<Testimonial> testimonial=testimonialdao.findBydate();

		
		for (Testimonial videotestimonial : testimonial) 
		{	
			System.err.println(videotestimonial.getUploadTestiminial());	
		}
		
		
		model.addAttribute("listofConsalatatnt",consalatant);
		model.addAttribute("listofTestimonial",testimonial);
		
		
		
		return "index";
		
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		
		
		return "myAccount";
		
	}
	@RequestMapping("/HomeRemove")
	public String homeLogin(){

		return "HomeRemove";
	}
	

	
	@RequestMapping("/forgetPassword")
	public String forgetPassword(
			HttpServletRequest request,
			@ModelAttribute("email") String email,
			Model model
			) {

		model.addAttribute("classActiveForgetPassword", true);
		
		User user = userService.findByEmail(email);
		
		if (user == null) {
			model.addAttribute("emailNotExist", true);
			return "myAccount";
		}
		
		String password = SecurityUtility.randomPassword();
		
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		
		userService.save(user);
		
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		SimpleMailMessage newEmail = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);
		
		mailSender.send(newEmail);
		
		model.addAttribute("forgetPasswordEmailSent", "true");
		
		
		return "myAccount";
	}
	
	@RequestMapping(value="/newUser", method = RequestMethod.POST)
	public String newUserPost(
			HttpServletRequest request,
			
			@ModelAttribute("username") String username,
			@ModelAttribute("firstName")  String firstName,
			@ModelAttribute("lastName") String lastName,
			@ModelAttribute("email") String userEmail,
			@ModelAttribute("password") String password,
			@ModelAttribute("address") String address,
			@ModelAttribute("phone") String phone,
			
			
			
 			Model model
			) throws Exception{
		model.addAttribute("classActiveNewAccount", true);
		model.addAttribute("email", userEmail);
		model.addAttribute("username", username);
		
		
		if (userService.findByUsername(username) != null) {
			model.addAttribute("usernameExists", true);
			
			return "myAccount";
		}
		
		if (userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);
			
			return "myAccount";
		}
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setPhone(phone);
		
		
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		
		 userService.save(user);
		 

		
		
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		/*
		 * SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl,
		 * request.getLocale(), token, user, password);
		 * 
		 * mailSender.send(email);
		 */
		model.addAttribute("emailSent", "true");
		
		return "myAccount";
	
	}
	
	@RequestMapping("/newUser")
	public String newUser(Locale locale, @RequestParam("token") String token, Model model) {
		PasswordResetToken passToken = userService.getPasswordResetToken(token);

		if (passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("message", message);
			return "redirect:/badRequest";
		}

		User user = passToken.getUser();
		String username = user.getUsername();

		UserDetails userDetails = userSecurityService.loadUserByUsername(username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("user", user);

		model.addAttribute("classActiveEdit", true);
		return "myProfile";
	}
}
