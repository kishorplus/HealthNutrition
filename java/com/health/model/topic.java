
  package com.health.model;
  
  import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
  
	  import javax.persistence.CascadeType;
	  import javax.persistence.Column;
	import javax.persistence.Entity; import
	  javax.persistence.FetchType; import javax.persistence.GeneratedValue; import
	  javax.persistence.GenerationType; import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import
	  javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;
	  
  @Entity
  @Table(name="topic")
  public class topic {
  
  @Id 
  @GeneratedValue(strategy=GenerationType.AUTO) 
  @Column(name="topicid", nullable = false, updatable = false)
  private int topicid;
  private Timestamp timedate;
  

	public Timestamp getTimedate() {
	return timedate;
}


public void setTimedate(Timestamp timedate) {
	this.timedate = timedate;
}

	private String topicname;
	
	  private int status;
		
	
     @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="category_id")
	 private Category category;
		 
	 
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User  user;
	
	 

		 @OneToMany(mappedBy = "topic",cascade =CascadeType.ALL) 
		 private List<Tutorial> tutorials;
		 
		 @OneToMany(mappedBy = "topic",cascade =CascadeType.ALL) 
		 private List<contributor_Role> contributor_Roles;
		                                                                                                     
		
		 @OneToMany(mappedBy = "topics",cascade = CascadeType.ALL)
		 private List<TraningInformation> traningInformations;
		 
	
		 @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL)
		 private List<Question> question; 
		 
		 
		 @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL)
		 private List<commentOnComponent> commentOnComponent;
		 
	
		 
		  public List<Question> getQuestion() {
			return question;
		}


		public void setQuestion(List<Question> question) {
			this.question = question;
		}




		public topic(Category category, User user) {
				super();
				this.category = category;
				this.user = user;
			}
		  
	  
 
  
		  public int getTopicid() { 
			  return topicid; } 
		  
		  public String getTopicname() {
		  
			  return topicname;
			  } 
		
		  public void setTopicname(String topicname) 
		  
		  { this.topicname = topicname; }
		  
		
		  public Category getCategory() {
				return category;
			}

			public void setCategory(Category category) {
				this.category = category;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			public List<Tutorial> getTutorials() {
				return tutorials;
			}

			public void setTutorials(List<Tutorial> tutorials) {
				this.tutorials = tutorials;
			}
			public void setStatus(int status) {
				this.status = status;
			}
			
			
			
			public void setTopicid(int topicid) {
				this.topicid = topicid;
			}
			  
			  public int getStatus() {
				return status;
			}

				public topic() {
				super();
			}

			
		  
		  
		  
		  }
 