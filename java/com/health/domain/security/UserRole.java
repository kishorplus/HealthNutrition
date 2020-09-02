package com.health.domain.security;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.health.model.User;
import com.health.model.language;

@Entity
@Table(name="user_role")
public class UserRole 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long userRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	public language getLanguage() {
		return language;
	}

	public void setLanguage(language language) {
		this.language = language;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="lan_id")
	private language language;

	private int status;


	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	private String created;

	public UserRole(){		
}
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}
	
	public UserRole(User user,int status) {
		this.user = user;
		this.status = status;
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

	public Role getRole() {
		return role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
