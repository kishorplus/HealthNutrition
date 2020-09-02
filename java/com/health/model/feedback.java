package com.health.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
	
	private String name;
	private String email;
	private String description;

	private String datetime; 
	
	//private Date vardates;
	
	public int getId() {
		return id;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String currentTime) {
		this.datetime = currentTime;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
