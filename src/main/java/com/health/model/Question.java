package com.health.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	private String Quetionpath;

	
	@ManyToOne		
	private Tutorial tutorial;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="topic_id")
	private topic topic;
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cat_id")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="lan_id")
	private language lan;
	

	public String getQuetionpath() {
		return Quetionpath;
	}

	public void setQuetionpath(String quetionpath){
		
		Quetionpath = quetionpath;
	
	}
	
	public Question(com.health.model.topic topic) {
		super();
		this.topic = topic;
	}

	public Question(String quetionpath, Tutorial tutorial) {
		super();
		Quetionpath = quetionpath;
		this.tutorial = tutorial;
	}

	public topic getTopic() {
		return topic;
	}

	public void setTopic(topic topic) {
		this.topic = topic;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public language getLan() {
		return lan;
	}

	public void setLan(language lan) {
		this.lan = lan;
	}

	

	/*
	 * @OneToMany(mappedBy = "question",
	 * cascade=CascadeType.ALL,fetch=FetchType.LAZY) private Set<category_Tutorial>
	 * category_Tutorials=new HashSet<>();
	 */
	
	
	/*
	 * 
	 * public Set<category_Tutorial> getCategory_Tutorials() { return
	 * category_Tutorials; }
	 * 
	 * public void setCategory_Tutorials(Set<category_Tutorial> category_Tutorials)
	 * { this.category_Tutorials = category_Tutorials; }
	 * 
	 */
	
}
