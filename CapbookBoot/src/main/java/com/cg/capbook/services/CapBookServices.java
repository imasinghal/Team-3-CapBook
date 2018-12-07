package com.cg.capbook.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Notification;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;
import com.cg.capbook.exceptions.UserNotFoundException;
import com.sun.jna.platform.win32.Netapi32Util.User;

public interface CapBookServices {
	
	public Users acceptUserDetails(Users user);
	public Profile addUserProfile(Profile profile);
	public List<Users> getAllUserDetails();
	public Users getUserDetails(String emailId) throws UserNotFoundException;
	public Users loginUser(String userName, String password);
	public List<Profile> getAllProfiles(String name);
	public Users updateUserDetails(Users user);
	public Users addFriend(String emailId,String userName);
	public List<String> getAllFriends(String emailId);
	public Post addPost(String emailId,String post);
	public List<String> getAllPosts(String emailId);
	public List<String> getMyPosts(String emailId);
	public Notification addNotification(String emailId,String message,String type,String status,String msgTo);
	public List<String> getAllNotification(String emailId);
	public Profile getProfileDetails(String userName);

}
