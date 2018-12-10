package com.cg.capbook.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

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
import com.sun.jna.platform.win32.Netapi32Util.User;

public interface CapBookServices {
	
	public Users acceptUserDetails(Users user) throws CapBookServicesDownException;
	public Profile addUserProfile(Profile profile) throws CapBookServicesDownException;
	public List<Users> getAllUserDetails() throws UserNotFoundException,CapBookServicesDownException;
	public Users getUserDetails(String emailId) throws UserNotFoundException,CapBookServicesDownException;
	public Users loginUser(String userName, String password) throws UserNotFoundException,CapBookServicesDownException;
	public List<Profile> getAllProfiles(String name) throws ProfileNotFoundException,CapBookServicesDownException;
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

}
