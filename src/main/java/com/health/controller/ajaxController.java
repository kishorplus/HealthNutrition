package com.health.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.Category;
import com.health.model.Tutorial;

import com.health.repository.CategoryTutorialDao;
import com.health.repository.TutorialDao;
import com.health.service.categoryService;

@Controller
public class ajaxController {

	@Autowired
	private categoryService categoryService;

	@Autowired
	private CategoryTutorialDao categoryTutorialDao;
	
	
	/*
	 * 
	 * 
	 * @RequestMapping("/loadByLangugaeTopic") public @ResponseBody List<String>
	 * getAllSubcategoriesDeatail(@RequestParam(name="id") String languageName) {
	 * 
	 * List<String> topicName=new ArrayList<String>();
	 * 
	 * //Category
	 * cat=categoryService.findBycategoryname(category.getCategoryname());
	 * 
	 * Tutorial totorial=
	 * 
	 * 
	 * 
	 * System.err.println("category_id"+cat.getId());
	 * 
	 * List<category_Tutorial> catTut=(List<category_Tutorial>)
	 * categoryTutorialDao.findByCategory(cat);
	 * 
	 * 
	 * //List<category_Tutorial>
	 * categoryTuthttp://localhost:8080/indexorials=(List<category_Tutorial>)
	 * categoryTutorialDao.findOne(cat);
	 * 
	 * 
	 * for(category_Tutorial s:catTut) {
	 * 
	 * topicName.add(s.getTutorial().getTopicname());
	 * 
	 * 
	 * } return topicName;
	 * 
	 * }
	 */
	 

}
