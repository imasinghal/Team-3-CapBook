package com.cg.capbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Notification;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;
import com.cg.capbook.dao.FriendDAO;
import com.cg.capbook.dao.NotificationDAO;
import com.cg.capbook.dao.PostDAO;
import com.cg.capbook.dao.ProfileDAO;
import com.cg.capbook.dao.UsersDAO;
import com.cg.capbook.exceptions.UserNotFoundException;
import com.sun.jna.platform.win32.Netapi32Util.User;

import antlr.collections.impl.LList;

@Component("service")
public class CapBookServicesImpl implements CapBookServices {

	@Autowired
	UsersDAO usersDAO;
	@Autowired
	ProfileDAO profileDAO;
	@Autowired
	FriendDAO friendDAO;
	@Autowired
	PostDAO postDAO;
	@Autowired
	NotificationDAO notificationDAO;
	
	@Override
	public Users acceptUserDetails(Users user) {
		System.out.println(user);
			return usersDAO.save(user);
	}

	@Override
	public Profile addUserProfile(Profile profile) {
		return profileDAO.save(profile);
	}

	@Override
	public List<Users> getAllUserDetails() {
		return usersDAO.findAll();
	}

	@Override
	public Users loginUser(String emailId, String password) {
		Users user = usersDAO.findById(emailId).get();
		if(user.getPassword().equals(password))
			return user;
		return null;
	}

	@Override
	public Users getUserDetails(String emailId) throws UserNotFoundException {
	
		System.out.println(emailId);
		return usersDAO.findById(emailId).get();
	}

	@Override
	public List<Profile> getAllProfiles(String name) {
		System.out.println(name);
		System.out.println(profileDAO.getProfiles(name));
		return profileDAO.getProfiles(name);
	}

	@Override
	public Users updateUserDetails(Users user) {
		Users temp = usersDAO.findById(user.getEmailId()).get();
		usersDAO.delete(user);
		return usersDAO.save(user);
	}

	@Override
	public Users addFriend(String emailId, String userName) {
		
		Users temp = usersDAO.findById(emailId).get();
		Profile pro =profileDAO.findById(userName).get();
		List<Friend> friends=new ArrayList<Friend>();
		List<Post> posts=new ArrayList<Post>();
		List<Notification> notes=new ArrayList<Notification>();
		Friend fr=new Friend();
		fr.setBio(pro.getBio()); 	fr.setDateOfBirth(pro.getDateOfBirth());	fr.setName(pro.getName());	fr.setUserName(pro.getUserName());	fr.setPhoneNo(pro.getPhoneNo());	fr.setGender(pro.getGender());
		fr.setUser(new Users(emailId, "", new Profile(), friends, posts,notes));
		friends.add(fr);
		temp.getFriends().addAll(friends);
		friendDAO.save(fr);
		temp=usersDAO.save(temp);
		return temp;
	}

	@Override
	public List<String> getAllFriends(String emailId) {
		System.out.println("EHLLO");
	return friendDAO.getFriends(emailId);
	}

	@Override
	public Post addPost(String emailId,String post) {
		Post postMsg = new Post();
		postMsg.setPostContent(post);
		List<Friend> friends=new ArrayList<Friend>();
		List<Post> posts=new ArrayList<Post>();
		List<Notification> notes=new ArrayList<Notification>();
		postMsg.setUser(new Users(emailId, "", new Profile(),friends , posts,notes));
		return postDAO.save(postMsg);
	}

	@Override
	public List<String> getMyPosts(String emailId) {
		return postDAO.getPosts(emailId);
	}

	@Override
	public Notification addNotification(String emailId, String message, String type, String status,String msgTo) {
		Notification note = new Notification();
		List<Friend> friends=new ArrayList<Friend>();
		List<Post> posts=new ArrayList<Post>();
		List<Notification> notes=new ArrayList<Notification>();
		note.setNotMsg(message);
		note.setStatus(status);
		note.setType(type);
		note.setUser(new Users(emailId, "", new Profile(),friends , posts,notes));
		note.setMsgTo(msgTo);
		return notificationDAO.save(note);
	}

	@Override
	public List<String> getAllNotification(String emailId) {
		return notificationDAO.getNotification(emailId);
	}

	@Override
	public List<String> getAllPosts(String emailId) {
		List<String> list = friendDAO.getFriendsUserName(emailId);
		
		List<String> flist = new ArrayList<String>();
		
		for (String string : list) {
			System.out.println(string);
			String email=usersDAO.getEmailId(string);
			System.out.println(email);
			flist.add(email);
		}
		
		List<String> posts = new ArrayList<String>();
		List<String> tempPosts = new ArrayList<String>();
		for (String email : flist) {
			String userName=usersDAO.getUserName(email);
			String name=profileDAO.getName(userName);
			posts=postDAO.getPosts(email);
			for (String post : posts) {
				tempPosts.add(name+" - "+post);
			}		
		}
		return tempPosts;
	}
	@Override
	public Profile getProfileDetails(String userName) {
		Profile profile = profileDAO.findById(userName).get();
		if(profile!= null) return profile;
		
		return null;
	}
}
