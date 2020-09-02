package com.health.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.Category;
import com.health.model.Tutorial;

import com.health.repository.CategoryDao;
import com.health.repository.CategoryTutorialDao;
import com.health.repository.TutorialDao;
import com.health.service.categoryService;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	@Autowired
	public categoryService categoryService;
	
	
	@Autowired
	public TutorialDao tutorialDao;
	
	
	/*
	 * @Autowired private participantDeatailImpl cs;
	 * 
	 * @RequestMapping(path="feedcustomerdat") public void Setdata() {
	 * 
	 * cs.saveData();
	 * 
	 * 
	 * }
	 * 
	 * 
	 */
	/*
	 * @PostMapping("/loadByCategoryTuturial") public String
	 * postLoadByCategory(@PathVariable Integer id, Model model, HttpServletRequest
	 * req,@RequestParam(name = "categoryName") String categoryName){
	 * 
	 * 
	 * Category cat=categoryService.findBycategoryname(categoryName);
	 * 
	 * List<category_Tutorial> categoryTutorial=(List<category_Tutorial>)
	 * categoryTutorialDao.findOne(cat.getId());
	 * 
	 * List<Tutorial> userAddInformation = new ArrayList<>();
	 * 
	 * for (category_Tutorial ur : categoryTutorial) {
	 * 
	 * 
	 * Tutorial userInformation =
	 * tutorialDao.findOne(ur.getTutorial().getTutorialid());
	 * 
	 * userAddInformation.add(userInformation); }
	 * 
	 * model.addAttribute("languages", userAddInformation);
	 * 
	 * return "languages"; }
	 */
	
	
	/*
	 * @PostMapping("/loadByCategoryTuturial") public @ResponseBody List<String>
	 * postLoadByCategory(@Valid @RequestBody Category category,Model model){
	 * 
	 * 
	 * List<String> topicName=new ArrayList<String>();
	 * 
	 * //Category
	 * cat=categoryService.findBycategoryname(category.getCategoryname());
	 * 
	 * Category cat=categoryService.findByid(category.getId());
	 * 
	 * List<category_Tutorial> categoryTutorial=(List<category_Tutorial>)
	 * categoryTutorialDao.findOne(cat.getId());
	 * 
	 * 
	 * for(category_Tutorial s:categoryTutorial) {
	 * 
	 * topicName.add(s.getTutorial().getLanguage());
	 * 
	 * 
	 * 
	 * }
	 * 
	 * return topicName;
	 * 
	 * 
	 * }
	 */
	

	

}
