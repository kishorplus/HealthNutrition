package com.health.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class state {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "state_id", nullable = false)
	
	private int id;	
	private String  stateName;
	private Date date;
	
	@OneToMany(mappedBy = "state", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<District>  District;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	
	
}
