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

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="contributor_Role")
public class contributor_Role 
{
	
	
	public Long getContribution_id() 
	{
		return contribution_id;
	}
	public void setContribution_id(Long contribution_id) {
		this.contribution_id = contribution_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public topic getTopic()
	{
		return topic;
	}

	public void setTopic(topic topic) {
		this.topic = topic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contribution_id;
	
	 private long status;
	 private String date;
	 
	
	 public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="user_id")
	 private User user;
	
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="category_id")
	 private Category category;
	 
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="langaueg_id")
	 private language lan;

	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="topic_id")
	 private topic topic;
	 
 
		
}
