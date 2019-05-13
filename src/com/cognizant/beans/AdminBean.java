package com.cognizant.beans;


	public class AdminBean {
	private int id;
	private String name,email,password,city,contact;

	public AdminBean() {
		super();
	}

	public AdminBean(String name, String email, String password, String city, String contact) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.contact = contact;
	}

	public AdminBean(int id, String name, String email, String password, String city, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	}
