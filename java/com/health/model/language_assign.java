package com.health.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="language_assign")
public class language_assign {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long userRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="language_id")
	private language lan;


	public language getLan() {
		return lan;
	}


	public void setLan(language lan) {
		this.lan = lan;
	}


	public Long getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	
	
}

