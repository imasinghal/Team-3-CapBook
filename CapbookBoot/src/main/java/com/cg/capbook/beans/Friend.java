package com.cg.capbook.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Friend {
	
	@Id
	@SequenceGenerator(name="friend_seq",sequenceName="friend_seq",initialValue=123,allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="friend_seq")
	private int id;
	private String name;
	private String gender;
	private String phoneNo;
	private String dateOfBirth;
	private String bio;
	private String userName;

	@JsonBackReference
	@ManyToOne
	private Users user;
		public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
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

	public Friend() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", gender=" + gender + ", phoneNo=" + phoneNo + ", dateOfBirth="
				+ dateOfBirth + ", bio=" + bio + ", userName=" + userName + ", user=" + user + "]";
	}
	public Friend(int id, String name, String gender, String phoneNo, String dateOfBirth, String bio, String userName,
			Users user) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
		this.userName = userName;
		this.user = user;
	}
	
/*	public Friend(String name, String gender, String phoneNo, String dateOfBirth, String bio, String userName) {
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
		return "Friend [name=" + name + ", gender=" + gender + ", phoneNo=" + phoneNo + ", dateOfBirth=" + dateOfBirth
				+ ", bio=" + bio + ", userName=" + userName + "]";
	}*/
	

}
