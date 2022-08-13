package com.garage.gerbackg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="admin")
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int adminid;
	
	@Column
	private String email;
	
	@Column
	private String password;


//	Declaring getters, setters and constructor
	
	public Admin() {
	
	}


	public int getAdminid() {
		return adminid;
	}


	public void setAdminid(int adminid) {
		this.adminid = adminid;
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
	
	
}
