package com.klef.jfsd.exam;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "department")
public class Department {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String name;
	private String location;
	private String hodName;
	

	public Department(String name, String location, String hodName) {
		super();
		this.name = name;
		this.location = location;
		this.hodName = hodName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
}
