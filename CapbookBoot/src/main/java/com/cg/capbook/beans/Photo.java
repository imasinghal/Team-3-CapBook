package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Photo {
	@Id
	@SequenceGenerator(name="photo_seq",sequenceName="photo_seq",initialValue=1001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="photo_seq")
	private int photoId;
	
	@Lob
	private byte[] photo;
	private String type;
	
	@ManyToOne
	Users user;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Photo(int photoId, byte[] photo, String type, Users user) {
		super();
		this.photoId = photoId;
		this.photo = photo;
		this.type = type;
		this.user = user;
	}
		
}
