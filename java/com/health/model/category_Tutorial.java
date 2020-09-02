package com.health.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.health.domain.security.Role;

@Entity
@Table(name="cat_tutorial")
public class category_Tutorial {

	public category_Tutorial(Category cat) {
		super();
		this.cat = cat;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long catLanId;
	

	public Long getCatLanId() {
		return catLanId;
	}

	public void setCatLanId(Long catLanId) {
		this.catLanId = catLanId;
	}

	public category_Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	public category_Tutorial(Category cat, Tutorial tutorial){
		this.cat = cat;
		this.tutorial = tutorial;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="category_id")
	private Category cat;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="topicresourese_id")
	private Tutorial tutorial;
	
	

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="lan_id")
	private language language;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="topic_id")
	private topic topic;


	public language getLanguage() {
		return language;
	}


	public void setLanguage(language language) {
		this.language = language;
	}


	public topic getTopic() {
		return topic;
	}


	public void setTopic(topic topic) {
		this.topic = topic;
	}


	public category_Tutorial(Category cat,  com.health.model.topic topic) {
		super();
		this.cat = cat;
		this.topic = topic;
	}

	
	/*
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	 * 
	 * @JoinColumn(name="question-id") private Question question;
	 * 
	 * 
	 * public Question getQuestion() { return question; }
	 * 
	 * 
	 * public void setQuestion(Question question) { this.question = question; }
	 * 
	 * 
	 */
	

}