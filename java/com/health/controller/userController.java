package com.health.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.TraningInformation;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.feedbackMasterTrainer;
import com.health.model.language;
import com.health.model.partipantDeatil;
import com.health.model.state;
import com.health.model.trainingInformationDao;
import com.health.repository.RoleRepository;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.repository.feedbackRespositary;
import com.health.repository.languageAssignDao;
import com.health.repository.languagedao;
import com.health.repository.participantDao;
import com.health.repository.stateRespositary;
import com.health.service.UserService;
import com.health.service.categoryService;
import com.health.service.roleService;
import com.health.service.tutorialService;

@Controller
public class userController {

	@Autowired
	private roleService roleservice;

	@Autowired
	private RoleRepository rolerespositary;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepositary userRoleRepositary;

	@Autowired
	private categoryService categoryservice;

	@Autowired
	private tutorialService tutorialService;

	@Autowired
	private TutorialDao tutorialDao;

	@Autowired
	private participantDao participantDao;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private languagedao languagedao;

	@Autowired
	private languageAssignDao languageAssignDao;

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDeny() {

		return "accessDeny";

	}

	@Autowired
	private stateRespositary statedao;

	@Autowired
	private languagedao languageDao;

	@Autowired
	private trainingInformationDao trainingInformationDao;

	@Autowired
	private feedbackRespositary feedbackRespositaryDao;

	@RequestMapping(value = "/adminDeatail", method = RequestMethod.GET)
	public String adminDeatail(Model model, Authentication authentication) {

		List<Category> category = categoryservice.findAll();

		model.addAttribute("categorys", category);

		List<Tutorial> tutorial = tutorialService.findAll();

		List<Category> cats = categoryservice.findAll();

		List<String> catInformation = new ArrayList<String>();

		for (Category catInfo : cats) {

			catInformation.add(catInfo.getCategoryname());

		}

		ArrayList<String> feedbakMasTra = new ArrayList<String>();

		List<feedbackMasterTrainer> feedbackMasterTrainerList = (List<feedbackMasterTrainer>) feedbackRespositaryDao
				.findAll();

		for (feedbackMasterTrainer feedbackMasterTrainer : feedbackMasterTrainerList) {

			feedbakMasTra.add(feedbackMasterTrainer.getCategory().getCategoryname());

		}

		feedbakMasTra.removeAll(catInformation);

		model.addAttribute("listOfcategory", feedbakMasTra);

		model.addAttribute("categorys", category);

//		List<Tutorial> tutorial=tutorialService.findAll();

		List<language> languageAll = languageDao.findAll();

		List<partipantDeatil> participantdeatail = (List<partipantDeatil>) participantDao.findAll();

		model.addAttribute("tutorials", tutorial);

		model.addAttribute("parcipantDeatails", participantdeatail);

		List<state> state = (List<com.health.model.state>) statedao.findAll();

		model.addAttribute("stateInfo", state);

		User user = userDao.findByUsername(authentication.getName());

		/*
		 *
		 * UserRole userRole=userRoleRepositary.findByUserInfo(user);
		 *
		 */

		List<TraningInformation> traningInformation = trainingInformationDao.findByCategoryOnUser(user);

		model.addAttribute("traningInformation", traningInformation);
		model.addAttribute("languagesDisplay", languageAll);

		model.addAttribute("userInfo", user);
		
		return "roleAdminDetail";

	}

	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public String userDetail(Model model, Authentication authentication) {

		return "roleUserDetail";
	}

	@RequestMapping(value = "/addMeAsContributer", method = RequestMethod.POST)
	public String aaddMeAsContributer(Authentication authentication, Model model,
			@RequestParam(value = "contributerLanguage") String languageName) {

		language lan = languagedao.findBylanguageName(languageName);

		int languageId = lan.getId();

		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);

		User user = userService.findByClassname(authentication.getName());

		String name = "Contributer";

		Role role = rolerespositary.findByname(name);

		int status = 0;

		UserRole userRoles = new UserRole(user, role);

		userRoles.setLanguage(lan);
		userRoles.setCreated(currentTime);
		userRoles.setStatus(status);

		userRoleRepositary.save(userRoles);

		model.addAttribute("request", "Request Send Successfully");

		return "redirect:/contributerSelectionLanguage";
//		return "addContributerRoleRequest";
//		return "roleAdminDetail";

	}

	@RequestMapping(value = "/addMeAsDomainRevieweer", method = RequestMethod.POST)
	public String addMeAsDomainRevieweer(Authentication authentication, Model model,
			@RequestParam(value = "contributerLanguage") String languageName) {

		language lan = languagedao.findBylanguageName(languageName);

		User user = userService.findByClassname(authentication.getName());

		// List<UserRole> findAlreadyPresent=(List<UserRole>)
		// userRoleRepositary.findByuser_id(user.getId());

		/*
		 * for (UserRole exitRole : findAlreadyPresent) {
		 *
		 * if(exitRole.getRole().getRoleId()==3) {
		 *
		 * model.addAttribute("requestSend",true);
		 *
		 * return "roleAdminDetail";
		 *
		 * }
		 *
		 * }
		 */

		String name = "DomainReviweer";

		Role role = rolerespositary.findByname(name);

		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);

		int status = 0;
		UserRole userRoles = new UserRole(user, role);

		userRoles.setStatus(status);
		userRoles.setLanguage(lan);
		userRoles.setCreated(currentTime);
		userRoleRepositary.save(userRoles);

		return "redirect:/domainLanguage";
//		return "roleAdminDetail";

	}

	@RequestMapping(value = "/addMeAsAdminReviwer", method = RequestMethod.GET)
	public String addMeAsAdminReviwer(Authentication authentication, Model model) {

		User user = userService.findByClassname(authentication.getName());

		List<UserRole> findAlreadyPresent = userRoleRepositary.findByuser_id(user.getId());

		for (UserRole exitRole : findAlreadyPresent) {

			if (exitRole.getRole().getRoleId() == 6) {

				model.addAttribute("requestSend", true);

				return "roleAdminDetail";

			}

		}

		String name = "VideoReviwer";

		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);

		Role role = rolerespositary.findByname(name);

		int status = 0;
		UserRole userRoles = new UserRole(user, role);
		userRoles.setStatus(status);
		userRoles.setCreated(currentTime);

		userRoleRepositary.save(userRoles);

		return "redirect:/roleAdminDetail";
//		return "roleAdminDetail";

	}

	@RequestMapping(value = "/addMeAsQualityRevieweer", method = RequestMethod.GET)
	public String addMeAsQualityRevieweer(Authentication authentication, Model model) {

		User user = userService.findByClassname(authentication.getName());

		List<UserRole> findAlreadyPresent = userRoleRepositary.findByuser_id(user.getId());

		for (UserRole exitRole : findAlreadyPresent) {

			if (exitRole.getRole().getRoleId() == 1) {

				model.addAttribute("requestSend", true);

				return "roleAdminDetail";

			}

		}

		String name = "QualityReviweer";

		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);

		Role role = rolerespositary.findByname(name);

		int status = 0;
		UserRole userRoles = new UserRole(user, role);
		userRoles.setStatus(status);
		userRoles.setCreated(currentTime);
		userRoleRepositary.save(userRoles);

		return "roleAdminDetail";

	}

	@RequestMapping(value = "/addMeAsMasterTrainer", method = RequestMethod.GET)
	public String addMeAsMasterTrainer(Authentication authentication, Model model) {

		User user = userService.findByClassname(authentication.getName());

		List<UserRole> findAlreadyPresent = userRoleRepositary.findByuser_id(user.getId());

		for (UserRole exitRole : findAlreadyPresent) {

			if (exitRole.getRole().getRoleId() == 4) {

				model.addAttribute("requestSend", true);

				return "roleAdminDetail";

			}

		}

		String name = "MasterTrainer";

		Role role = rolerespositary.findByname(name);

		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);

		int status = 0;

		UserRole userRoles = new UserRole(user, role);
		userRoles.setStatus(status);
		userRoles.setCreated(currentTime);

		userRoleRepositary.save(userRoles);

		return "roleAdminDetail";

	}

	/* approve the domain Revieweer */

	@RequestMapping(value = "/approveMeAsDomainRevieweer", method = RequestMethod.GET)
	public String approveMeAsDomainRevieweer(Model model, Authentication autheticate) {

		int rolId = 3;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("statusByApprov", userAddInformation);

		return "showDomainReviweer";
	}

	@RequestMapping(value = "/approveMeAsContributer", method = RequestMethod.GET)
	public String approveMeAsContributer(Model model, Authentication autheticate) {

		int rolId = 5;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();
		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);
		}

		model.addAttribute("statusByApprov", userByStatus);
		/* model.addAttribute("statusByApprov", userAddInformation); */

		return "showContributer";

	}

	/* Here is code for Contributor Approve */

	@RequestMapping("/addContributerRoleById/add/{id}")
	public String addContributerRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		// User user=-userRepository.findByUserId(id);

		User user = userRepository.findOne(id);

		String name = "Contributer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		/* return "showContributer"; */

		return "redirect:/approveRole";

	}

	/* here is code reject Contributor */
	@RequestMapping("/addRejectRoleById/reject/{id}")
	public String rejectContributorById(@PathVariable Long id, Model model, HttpServletRequest req) {

		User user = userRepository.findOne(id);

		UserRole userRoles = userRoleRepositary.findByRejectElement(user);

		System.err.println("print value" + userRoles.getUserRoleId());

		String name = "Contributer";
		Role role = rolerespositary.findByname(name);

		int status = 0;
		UserRole userRole = userRoleRepositary.findByContributorId(userRoles.getUserRoleId(), role);
		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		return "redirect:/approveRole";

	}

	@RequestMapping("/addDomainRoleById/add/{id}")
	public String addDomainRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		User user = userRepository.findOne(id);

		String name = "DomainReviweer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		model.addAttribute("viewActive", "active");

		return "approveRoleLink";

	}

	@RequestMapping("/addAdminRoleById/add/{id}")
	public String addAdminRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		// User user=-userRepository.findByUserId(id);

		User user = userRepository.findOne(id);

		String name = "VideoReviwer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		return "redirect:/approveRole";

	}

	/* add the Quality Revieweer */

	@RequestMapping(value = "/approveMeAsQualityRevieweer", method = RequestMethod.GET)
	public String approveMeAsQualityRevieweer(Model model, Authentication autheticate) {

		int rolId = 1;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("statusByApprov", userAddInformation);

		return "showQualityReviweer";

	}

	/* fetching information by Id */

	@RequestMapping("/addQualityRoleById/add/{id}")
	public String addQualityRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		// User user=-userRepository.findByUserId(id);

		User user = userRepository.findOne(id);

		String name = "QualityReviweer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		return "redirect:/approveRole";
		/* return "showQualityReviweer"; */

	}

	@RequestMapping("/addQualityRoleRejectById/add/{id}")
	public String addQualityRoleRejectById(@PathVariable Long id, Model model, HttpServletRequest req) {

		return "redirect:/approveRole";
		/* return "showQualityReviweer"; */

	}

	/* approve the master Trainer */

	@RequestMapping(value = "/approveMeAsMasterTrainer", method = RequestMethod.GET)
	public String approveMeAsMasterTrainer(Model model, Authentication autheticate) {

		int rolId = 4;

		Role role = rolerespositary.findByIdRoles(rolId);
		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("statusByApprov", userAddInformation);

		return "showMasterTrainer";

	}

	/* fetching information by Id */

	@RequestMapping("/addMasterTrainerRoleById/add/{id}")
	public String addMasterTrainerRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		// User user=-userRepository.findByUserId(id);

		User user = userRepository.findOne(id);

		String name = "MasterTrainer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		return "redirect:/approveRole";

		/* return "showMasterTrainer"; */

	}

	@RequestMapping("/addmasterRoleRejectById/add/{id}")
	public String addMasterRoleRejectById(@PathVariable Long id, Model model, HttpServletRequest req) {

		return "redirect:/approveRole";
		/* return "showQualityReviweer"; */
	}

	/*
	 * here approve request from user like Domain reviewer
	 */
	@RequestMapping("/approveRole")
	public String approveRole(Model model) {

		int rolId = 3;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {
			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);
			System.out.println(userInformation.getFirstName());

		}

		model.addAttribute("statusByApprovDomain", userByStatus);

		int rolIdMaster = 4;

		Role roleMaster = rolerespositary.findByIdRoles(rolIdMaster);
		// int status = 0;
		List<UserRole> userByStatusMaster = userRoleRepositary.findByStatus(status, roleMaster);

		List<User> userAddInformationMaster = new ArrayList<>();

		for (UserRole ur : userByStatusMaster) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformationMaster.add(userInformation);

		}

		model.addAttribute("statusByApprovMaster", userByStatusMaster);

		int rolIdContributer = 5;
		Role roleContributer = rolerespositary.findByIdRoles(rolIdContributer);

		/* int status = 0; */
		List<UserRole> userByStatusContributer = userRoleRepositary.findByStatus(status, roleContributer);

		List<User> userAddInformationContributer = new ArrayList<>();

		for (UserRole ur : userByStatusContributer) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformationContributer.add(userInformation);
		}
		model.addAttribute("statusByApprovContributer", userByStatusContributer);

		int rolIdQuality = 1;
		Role roleQuality = rolerespositary.findByIdRoles(rolIdQuality);

		/* int status = 0; */
		List<UserRole> userByStatusQuality = userRoleRepositary.findByStatus(status, roleQuality);

		List<User> userAddInformationQuality = new ArrayList<>();

		for (UserRole ur : userByStatusQuality) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformationQuality.add(userInformation);
		}

		model.addAttribute("statusByApprovQuality", userByStatusQuality);

		int rolIdVideo = 6;
		Role roleVideo = rolerespositary.findByIdRoles(rolIdVideo);

		List<UserRole> userByStatusVideo = userRoleRepositary.findByStatus(status, roleVideo);

		List<User> userAddInformationVideo = new ArrayList<>();

		for (UserRole ur : userByStatusVideo) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformationVideo.add(userInformation);
		}
		model.addAttribute("statusByApprovAdmin", userByStatusVideo);

		return "approveRoleLink";

	}

}
