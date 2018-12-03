package com.cg.capbook.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Users {
@Id
private String userName;
private String password;
@OneToOne(cascade=CascadeType.ALL)
private Profile profile;

@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
private List<Profile> friends;

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Profile getProfile() {
	return profile;
}
public void setProfile(Profile profile) {
	this.profile = profile;
}
//delete 
public void addFriend(Profile profile) {
	this.friends.add(profile);
}
public Users(String userName, String password, Profile profile) {
	super();
	this.userName = userName;
	this.password = password;
	this.profile = profile;
}
public Users() {
	super();
}


	
}
