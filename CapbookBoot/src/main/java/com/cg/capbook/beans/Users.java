package com.cg.capbook.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Users {
	@Id
	private String emailId;
	private String password;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Profile profile;
	private String securityQuestion;


	@JsonManagedReference
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)  //mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Friend> friends;

	@JsonManagedReference
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)  //mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Post> posts ;

	@JsonManagedReference
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true) 
	private List<Notification> notes ;

	public String getEmailId() {
		return emailId;
	}

	public List<Notification> getNotes() {
		return notes;
	}

	public void setNotes(List<Notification> notes) {
		this.notes = notes;
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Friend> getFriends() {
		return friends;
	}
	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public Users(String emailId, String password, Profile profile, List<Friend> friends, List<Post> posts,
			List<Notification> notes) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.profile = profile;
		this.friends = friends;
		this.posts = posts;
		this.notes = notes;
	}
	
	public Users(String emailId, String password, Profile profile, String securityQuestion, List<Friend> friends,
			List<Post> posts, List<Notification> notes) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.profile = profile;
		this.securityQuestion = securityQuestion;
		this.friends = friends;
		this.posts = posts;
		this.notes = notes;
	}

	
	
	@Override
	public String toString() {
		return "Users [emailId=" + emailId + ", password=" + password + ", profile=" + profile + ", securityQuestion="
				+ securityQuestion + ", friends=" + friends + ", posts=" + posts + ", notes=" + notes + "]";
	}

	public Users() {
		super();
	}




}
