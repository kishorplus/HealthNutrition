package com.health.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consultant 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id                    ;
	private String name;
	private String description;
	private String uploadConsultantImage;
	private String currentdate;
	private java.sql.Timestamp dateAdded;
	private int showOnHomepage;
	public int getId() {
		return id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUploadConsultantImage() {
		return uploadConsultantImage;
	}
	public void setUploadConsultantImage(String uploadConsultantImage) {
		this.uploadConsultantImage = uploadConsultantImage;
	}
	public String getCurrentdate() {
		return currentdate;
	}
	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}
	public java.sql.Timestamp getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(java.sql.Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}
	public int getShowOnHomepage() {
		return showOnHomepage;
	}
	public void setShowOnHomepage(int showOnHomepage) {
		this.showOnHomepage = showOnHomepage;
	}
}
