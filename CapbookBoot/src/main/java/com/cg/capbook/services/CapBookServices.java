package com.cg.capbook.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Notification;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;
import com.cg.capbook.exceptions.CapBookServicesDownException;
import com.cg.capbook.exceptions.FriendNotFoundException;
import com.cg.capbook.exceptions.NotificationNotFoundException;
import com.cg.capbook.exceptions.PostNotFoundException;
import com.cg.capbook.exceptions.ProfileNotFoundException;
import com.cg.capbook.exceptions.UserNotFoundException;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;



public interface CapBookServices {
	public List<Post> removePost(int postId);
	
	public Users acceptUserDetails(Users user) throws CapBookServicesDownException;
	public Profile addUserProfile(Profile profile) throws CapBookServicesDownException;
	public List<Users> getAllUserDetails() throws UserNotFoundException,CapBookServicesDownException;
	public Users getUserDetails(String emailId) throws UserNotFoundException,CapBookServicesDownException;
	public Users loginUser(String userName, String password) throws UserNotFoundException,CapBookServicesDownException;
	public List<Profile> getAllProfiles(String name) throws ProfileNotFoundException,CapBookServicesDownException;
	public List<Profile> getAllFriendsProfiles(String emailId) throws ProfileNotFoundException,CapBookServicesDownException;
	public Users updateUserDetails(Users user) throws UserNotFoundException,CapBookServicesDownException;
	public Users addFriend(String emailId,String userName) throws UserNotFoundException,CapBookServicesDownException,ProfileNotFoundException;
	public List<String> getAllFriends(String emailId) throws FriendNotFoundException,CapBookServicesDownException;
	public Post addPost(String emailId,String post) throws CapBookServicesDownException;
	public List<String> getAllPosts(String emailId) throws PostNotFoundException,CapBookServicesDownException;
	public List<String> getMyPosts(String emailId) throws PostNotFoundException,CapBookServicesDownException;
	public Notification addNotification(String emailId,String message,String type,String status,String msgTo)  throws CapBookServicesDownException;
	public List<Notification> getAllNotification(String emailId) throws NotificationNotFoundException,CapBookServicesDownException;
	public Profile getProfileDetails(String userName) throws ProfileNotFoundException,CapBookServicesDownException;
	public String getUserName(String emailId);
	public String getEmailId(String userName);
	public String getName(String emailId);
	public Notification removeNotification(int notId);
	public Users addFriendRequest(String emailId,String userName);
	public int addPhoto(String emailId);
	public int getMaxPhotoId();
	public int getUserPhotoId(String emailId);
	public List<BigDecimal> getAllUserPhotoId(String emailId);
	

}
