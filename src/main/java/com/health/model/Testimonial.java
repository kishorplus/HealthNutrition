package com.health.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Testimonial {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private  int id;
		private String testimonialName;
		@Column(length = 3000)
		private String testimoniaqlDescription;
		private String uploadTestiminial;
		private java.sql.Timestamp timedate;



		public java.sql.Timestamp getTimedate() {
			return timedate;
		}
		public void setTimedate(java.sql.Timestamp timedate) {
			this.timedate = timedate;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTestimonialName() {
			return testimonialName;
		}
		public void setTestimonialName(String testimonialName) {
			this.testimonialName = testimonialName;
		}
		public String getUploadTestiminial() {
			return uploadTestiminial;
		}
		public void setUploadTestiminial(String uploadTestiminial) {
			this.uploadTestiminial = uploadTestiminial;
		}
		public String getTestimoniaqlDescription() {
			return testimoniaqlDescription;
		}
		public void setTestimoniaqlDescription(String testimoniaqlDescription) {
			this.testimoniaqlDescription = testimoniaqlDescription;
		}



}


