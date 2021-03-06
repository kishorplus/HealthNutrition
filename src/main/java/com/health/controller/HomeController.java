package com.health.controller;

import java.util.ArrayList;
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
import com.health.model.Category;
import com.health.model.Consaltantant;
import com.health.model.Event;
import com.health.model.Testimonial;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.repository.CategoryDao;
import com.health.repository.ConsaltantDao;
import com.health.repository.EventDao;
import com.health.repository.TestimonialDao;
import com.health.repository.TutorialDao;
import com.health.repository.languagedao;
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

	@Autowired
	private languagedao languageDao;

	@Autowired
	private ConsaltantDao consultantDao;

	@Autowired
	private CategoryDao categoryDao;



	@RequestMapping("/viewVideo/view/{id}")
	public String viewVideo(Model model, @PathVariable Integer id) {
		Tutorial tutorials = tutorialDao.findOne(id);
		int status = 1;
		List<Tutorial> tutorialRes = tutorialDao.findByLanAndCat(tutorials.getCategory(), tutorials.getLan(), status);

		model.addAttribute("list", tutorials);
		model.addAttribute("listOfTutorial", tutorialRes);

		List<Tutorial> category = tutorialDao.finBystatus();
		ArrayList<String> tutorialRes1 = new ArrayList<String>();
		for (Tutorial tutorial : category) {
			tutorialRes1.add(tutorial.getCategory().getCategoryname());
		}
		Set<String> categoryList=new LinkedHashSet<String>(tutorialRes1);
		model.addAttribute("categorys",categoryList);

		return "showVideo";
	}

	@RequestMapping("/viewVideoList/view/{id}")
	public String viewVideoList(Model model, @PathVariable Integer id) {

		Tutorial tutorials = tutorialDao.findOne(id);
		tutorials.getTopic().getTopicname();
		int status = 1;
		List<Tutorial> tutorialRes = tutorialDao.findByLanAndCat(tutorials.getCategory(), tutorials.getLan(), status);
		model.addAttribute("list", tutorials);
		model.addAttribute("listOfTutorial", tutorialRes);

		return "showVideo";
	}

	@Autowired
	private CategoryDao CategoryDao;

	@RequestMapping("/")
	public String index(Model model) {
		List<Tutorial> category = tutorialDao.finBystatus();
		ArrayList<String> tutorialRes = new ArrayList<String>();
		for (Tutorial tutorial : category) {
			tutorialRes.add(tutorial.getCategory().getCategoryname());
		}
		Set<String> categoryList=new LinkedHashSet<String>(tutorialRes);
		model.addAttribute("categorys",categoryList);

		List<Event> event=eventDao.getAllEvent();

		model.addAttribute("events",event);

		List<Consaltantant> consalatant=consalatantDao.findByConsultantShowonHomepage(true);

		for (Consaltantant consaltantant : consalatant)
		{
			System.err.println(consaltantant.getNameConsaltant());
		}

		List<Testimonial> testimonial = testimonialdao.findBydate();
		for (Testimonial videotestimonial : testimonial) {
			System.err.println(videotestimonial.getUploadTestiminial());
		}

		List<Tutorial> tutorials = tutorialDao.finBystatus();

		long languageCount = languageDao.count();
		java.util.List<Tutorial> videos = tutorialDao.finBystatus();

		List<Category> categories = categoryDao.findBystatus(1);
		List<Category> categoriesDisplay = new ArrayList<>();
		int size = 4;
		if(categories.size()>=size) {
			for(int i = 0; i< size; i++) {
				categoriesDisplay.add(categories.get(i));
			}
			categories = categoriesDisplay;
		}
		List<Consaltantant> consultantDisplay = new ArrayList<>();
		size = 3;
		if(consalatant.size()>=size) {
			for(int i = 0; i< size; i++) {
				consultantDisplay.add(consalatant.get(i));
			}
			consalatant = consultantDisplay;
		}
		List<Testimonial> testimonialDisplay = new ArrayList<>();
		if(testimonial.size()>=size) {
			for(int i = 0; i< size; i++) {
				testimonialDisplay.add(testimonial.get(i));
			}
			testimonial = testimonialDisplay;
		}
		List<Event> eventDisplay = new ArrayList<>();
		size = 3;
		if(event.size()>=size) {
			for(int i = 0; i< size; i++) {
				eventDisplay.add(event.get(i));
			}
			event = eventDisplay;
		}
		int videoCount = videos.size();
		long consultantCount = consultantDao.count();

		model.addAttribute("tutorials", tutorials);
		model.addAttribute("listofConsalatatnt", consalatant);
		model.addAttribute("listofTestimonial", testimonial);
		model.addAttribute("languageCount", languageCount);
		model.addAttribute("videoCount", videoCount);
		model.addAttribute("consultantCount", consultantCount);
		model.addAttribute("categories", categories);
		model.addAttribute("event", event);

		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "myAccount";
	}

	@RequestMapping("/HomeRemove")
	public String homeLogin() {
		return "HomeRemove";
	}

	@RequestMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request, @ModelAttribute("email") String email, Model model) {
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
		String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		SimpleMailMessage newEmail = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user,
				password);
		mailSender.send(newEmail);
		model.addAttribute("forgetPasswordEmailSent", "true");
		return "myAccount";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUserPost(HttpServletRequest request,

			@ModelAttribute("username") String username, @ModelAttribute("firstName") String firstName,
			@ModelAttribute("lastName") String lastName, @ModelAttribute("email") String userEmail,
			@ModelAttribute("password") String password, @ModelAttribute("address") String address,
			@ModelAttribute("phone") String phone,

			Model model) throws Exception {
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

		String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
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
