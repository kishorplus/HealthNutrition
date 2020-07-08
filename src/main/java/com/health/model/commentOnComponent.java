package com.health.model;

import java.security.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class commentOnComponent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int commentId;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentInfo() {
		return commentInfo;
	}
	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}
	private String commentInfo;
	
	private String commentdate;
	
	private  String componenenetDeatail;
	
	
	
	public String getComponenenetDeatail() {
		return componenenetDeatail;
	}
	public void setComponenenetDeatail(String componenenetDeatail) {
		this.componenenetDeatail = componenenetDeatail;
	}
	public String getCommentdate(){
		return commentdate;
	}
	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}
	
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="tutorial_id")
	 private Tutorial tutorial;
	 
	 
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="user_id")
	 private User user;
	 
	 
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="topic_id")
	 private topic topic;
	 
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="category_id")
	 private Category category;
	 
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="language_id")
	 private Language language;
	 
	 
	public Tutorial getTutorial() {
		return tutorial;
		}
	public void setTutorial(Tutorial tutorial) {
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
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 
	 
	
	 
	
	

}
