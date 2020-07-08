
  package com.health.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
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

import com.health.domain.security.UserRole;
import com.health.service.impl.catgoryServiceImpl;

@Entity 
public class Language 
{
  
  @Id  
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id", nullable = false, updatable = false)
  		
  	private int id;
	private  String languageName ;
	private Timestamp dateAdded;
	
	public Timestamp getTimedate() {
		return dateAdded;
	}

	public void setTimedate(Timestamp timedate) {
		this.dateAdded = timedate;
	}

	private String createdBy;
	
	  public String getCreatedBy() {
		  return createdBy;
	  }

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/*
	 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="user_id") private User user;
	 */

	@OneToMany(mappedBy = "lan",cascade =CascadeType.ALL) 
	private List<Tutorial> tutorials;
	
	@OneToMany(mappedBy = "lan", cascade = CascadeType.ALL)
	private List<contributor_Role> contributor_Roles;
	 
	@OneToMany(mappedBy = "language", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<UserRole> userRoles = new HashSet<>();

	
	@OneToMany(mappedBy = "lan", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<language_assign> languages= new HashSet<>();
	
	@OneToMany(mappedBy = "language", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<commentOnComponent>  commentOnComponent= new HashSet<>();
	
	
	public Set<UserRole> getUserRoles() {
		
		return userRoles;
	}

	public List<contributor_Role> getContributor_Roles() {
		return contributor_Roles;
	}

	public void setContributor_Roles(List<contributor_Role> contributor_Roles) {
		this.contributor_Roles = contributor_Roles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public Set<language_assign> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<language_assign> languages) {
		this.languages = languages;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}


		public int getId() { 
		  return id; }
	  
	  public void setId(int id) { 
		  this.id = id; }
	  
	 
	  public String getLanguageName() { 
		  return languageName; }
	  
	
	
	  public void setLanguageName(String languageName) 
	  { this.languageName =
	  languageName; }
	  

 
  }
 