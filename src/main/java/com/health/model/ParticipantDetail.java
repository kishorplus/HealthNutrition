
  package com.health.model;
  
  import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
  
  
  @Entity 
  @Table(name="parcipantsDeatail")
  public class ParticipantDetail 
  
  {
	  
			  @Id
			  @GeneratedValue(strategy = GenerationType.AUTO)
			  private int participantId; 
			  
		/*
		 * @EmbeddedId private participantDeatailId participantDeatailId;
		 */
			  private String firstName; 
			  private String lastName;
			  private String email;
			  private String gender;
			  private String adharNumber;
			  private String language;
		    
		    
		  
		    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
			 @JoinColumn(name="partipantDeatil_id")
			 private TraningInformation traningInformation;
		  
		  
			  public int getId() { 
				  
				  return participantId; 
			  
					  } 
			  public int getParticipantId() {
				return participantId;
			}
			public void setParticipantId(int participantId) {
				this.participantId = participantId;
			}
			public String getAdharNumber() {
				return adharNumber;
			}
			public void setAdharNumber(String adharNumber) {
				this.adharNumber = adharNumber;
			}
			public void setId(int id) {
			  this.participantId = id; } 
	
			
			public String getLanguage() {
				return language;
			}
			public void setLanguage(String language) {
				this.language = language;
			}
				public String
			  getFirstname() { return firstName; } public void setFirstname(String
			  firstname) { this.firstName = firstname; } public String getLastname() {
			  return lastName; }
			  
			 public void setLastname(String
			  lastname) { this.lastName = lastname; } public String getEmail() { return
			  email; } public void setEmail(String email) { this.email = email; } public
			  String getGender() { return gender; } public void setGender(String gender) 
			  {
			  this.gender = gender; } 
			  
			  
			  }
		 