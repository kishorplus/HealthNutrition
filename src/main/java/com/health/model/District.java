package com.health.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class District {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "district_id", nullable = false)
	int id;
	private String districtName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="state_id")
	private state state;
	
	
	@OneToMany(mappedBy = "district",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<City> city;
	
	public int getId() {
		return id;
	}
	public state getState() {
		return state;
	}
	public void setState(state state) {
		this.state = state;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}


}
