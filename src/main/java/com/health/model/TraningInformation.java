package com.health.model;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class TraningInformation 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String categoryname;
//	private String topicTraning;
	private String topic;
	private String language;
	private String state;
	private int pincode;
	private String participant;
	private String photo;
	private Date date;
	private Date endDate;
	private String districit;
	private String city;
	
	private String addressInformation;
	private String traingDetail;
	
	
	 public String getTraingDetail() {
		return traingDetail;
	}

	public void setTraingDetail(String traingDetail) {
		this.traingDetail = traingDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="user_id")
	 private User user;

	public String getAddressInformation() {
		return addressInformation;
	}

	public void setAddressInformation(String addressInformation) {
		this.addressInformation = addressInformation;
	}



	public String getDistricit() {
		return districit;
	}

	public void setDistricit(String districit) {
		this.districit = districit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<partipantDeatil> getPartipantDeatil() {
		return partipantDeatil;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setPartipantDeatil(List<partipantDeatil> partipantDeatil) {
		this.partipantDeatil = partipantDeatil;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public topic getTopics() {
		return topics;
	}

	public void setTopics(topic topics) {
		this.topics = topics;
	}

	@OneToMany(mappedBy = "traningInformation",cascade =CascadeType.ALL) 
	 private List<partipantDeatil> partipantDeatil;
	
		
		
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
			@JoinColumn(name="category_id")
		 private Category category;
	 
		
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
			@JoinColumn(name="topic_id")
		 private topic topics;
	 
	 
	 

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}



	public TraningInformation(Category category, com.health.model.topic topics) {
		super();
		this.category = category;
		this.topics = topics;
	}

	public TraningInformation() {
		// TODO Auto-generated constructor stub
	}

	public TraningInformation(Category category2) {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public String getTraningInformation() { return traningInformation; }
	 * 
	 */	public void setTraningInformation(String traningInformation) {
	}

	public int getId() {
		return id;	
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public String getTopicTraning() { return topicTraning; }
	 */
	/*
	 * public void setTopicTraning(String topicTraning) { this.topicTraning =
	 * topicTraning; }
	 */



	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}




	
	
	
	
}
