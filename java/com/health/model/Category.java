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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name="id")
	@Column(name="id", nullable = false, updatable = false)
	private int id;
	private String categoryname;
	private int status;
	private Timestamp created;
	

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	private Long userid;

	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) private
	  List<Tutorial> tutorials;
	  
	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) private
	  List<contributor_Role> contributor_Roles;

	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) 
	  private List<topic>  topic;
	 
	  @OneToMany(mappedBy = "category",cascade =CascadeType.ALL) 
	  private List<commentOnComponent>  commentOnComponent;
	  
	  
	  
	  @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
		 private List<TraningInformation> traningInformations;
		 
	  
		public List<topic> getTopic() {
			return topic;
		}

		public void setTopic(List<topic> topic) {
			this.topic = topic;
		}
	 
	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

}
