package com.health.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedbackForm")
public class FeedbackForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;	
	private String  mastertTrainerName;
	private String email;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMastertTrainerName() {
		return mastertTrainerName;
	}
	public void setMastertTrainerName(String mastertTrainerName) {
		this.mastertTrainerName = mastertTrainerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
