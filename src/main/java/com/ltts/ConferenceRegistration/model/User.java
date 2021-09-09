package com.ltts.ConferenceRegistration.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	
	private String name;
	private LocalDate dob;
	@Id
	private String emailId;
	private String password;
	private String mobile;
	private String photo;
	private String userRole;

	public User() {
		super();
	}

	
	public User(String name, LocalDate dob, String emailId, String mobile, String photo) {
		super();
		this.name = name;
		this.dob = dob;
		this.emailId = emailId;
		this.mobile = mobile;
		this.photo = photo;
	}


	public User(String name, LocalDate dob, String emailId, String password, String mobile, String photo,
			String userRole) {
		super();
		this.name = name;
		this.dob = dob;
		this.emailId = emailId;
		this.password = password;
		this.mobile = mobile;
		this.photo = photo;
		this.userRole = userRole;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", dob=" + dob + ", emailId=" + emailId + ", password=" + password + ", mobile="
				+ mobile + ", photo=" + photo + ", userRole=" + userRole + "]";
	}
}
