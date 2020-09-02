
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
  public class partipantDeatil 
  
  {
	  
			  @Id
			  @GeneratedValue(strategy = GenerationType.AUTO)
			  private int participantId; 
			  
		/*
		 * @EmbeddedId private participantDeatailId participantDeatailId;
		 */
			  private String firstname; 
			  private String lastname;
			  private String email;
			  private String gender;
			  private String adharNumber;
			  private String language;
			  private String titleName;
			  private String age;
			  public String getAge() {
				return age;
			}
			public void setAge(String age) {
				this.age = age;
			}
			private String qualification;
			  private String exprience;
			  private String organization;
			  
			
		    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
			 @JoinColumn(name="partipantDeatil_id")
			 private TraningInformation traningInformation;
		  
		 
			public String getQualification() {
				return qualification;
			}
			public void setQualification(String qualification) {
				this.qualification = qualification;
			}
			public String getExprience() {
				return exprience;
			}
			public void setExprience(String exprience) {
				this.exprience = exprience;
			}
			public String getOrganization() {
				return organization;
			}
			public void setOrganization(String organization) {
				this.organization = organization;
			}
			@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
			 @JoinColumn(name="category_id")
			 private Category category;
		  
		    
		    
		    
			  public Category getCategory() {
				return category;
			}
			public void setCategory(Category category) {
				this.category = category;
			}
			public String getTitleName() {
				return titleName;
			}
			public void setTitleName(String titleName) {
				this.titleName = titleName;
			}
			public TraningInformation getTraningInformation() {
				return traningInformation;
			}
			public void setTraningInformation(TraningInformation traningInformation) {
				this.traningInformation = traningInformation;
			}
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
			  getFirstname() { return firstname; } public void setFirstname(String
			  firstname) { this.firstname = firstname; } public String getLastname() {
			  return lastname; }
			  
			 public void setLastname(String
			  lastname) { this.lastname = lastname; } public String getEmail() { return
			  email; } public void setEmail(String email) { this.email = email; } public
			  String getGender() { return gender; } public void setGender(String gender) 
			  {
			  this.gender = gender; } 
			  
			  
			  }
		 