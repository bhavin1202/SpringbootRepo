package com.stsjpaexample.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Userdata {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int userId;

	private String name;
	
	@Override
	public String toString() {
		return "Userdata [userId=" + userId + ", Name=" + name + ", city=" + city + ", status=" + status + "]";
	}

	public Userdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String city;
	
	private String status;

	public Userdata(int userId, String name, String city, String status) {
		super();
		this.userId = userId;
		name = name;
		this.city = city;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
