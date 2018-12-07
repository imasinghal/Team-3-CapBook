package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Post {
	@Id
	@SequenceGenerator(name="post_seq",sequenceName="post_seq",initialValue=101,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="post_seq")
	private int postId;
	private String postContent;
	@JsonBackReference
	@ManyToOne
	private Users user;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postContent=" + postContent + ", user=" + user + "]";
	}
	public Post(int postId, String postContent, Users user) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.user = user;
	}
	public Post() {
		super();
	}
	
}
