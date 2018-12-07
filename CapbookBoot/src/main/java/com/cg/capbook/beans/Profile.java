package com.cg.capbook.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Profile {

	private String name;
	private String gender;
	private String phoneNo;
	private String dateOfBirth;
	private String bio;
	@Id
	private String userName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Profile() {
		super();
	}
	public Profile(String name, String gender, String phoneNo, String dateOfBirth, String bio, String userName) {
		super();
		this.name = name;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
		this.userName = userName;
		
		
	}
	@Override
	public String toString() {
		return "Profile [name=" + name + ", gender=" + gender + ", phoneNo=" + phoneNo + ", dateOfBirth=" + dateOfBirth
				+ ", bio=" + bio + ", userName=" + userName  + "]";
	}

	
	
}
