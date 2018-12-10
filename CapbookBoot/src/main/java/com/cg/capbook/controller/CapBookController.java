package com.cg.capbook.controller;

import java.util.List;

import org.apache.commons.io.filefilter.NotFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capbook.beans.Notification;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;
import com.cg.capbook.dao.UsersDAO;
import com.cg.capbook.exceptions.CapBookServicesDownException;
import com.cg.capbook.exceptions.FriendNotFoundException;
import com.cg.capbook.exceptions.NotificationNotFoundException;
import com.cg.capbook.exceptions.PostNotFoundException;
import com.cg.capbook.exceptions.ProfileNotFoundException;
import com.cg.capbook.exceptions.UserNotFoundException;
import com.cg.capbook.services.CapBookServices;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;


@CrossOrigin
@RestController
public class CapBookController {

	@Autowired
	CapBookServices service;
	Users temp;
	@RequestMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("hi yoyo",HttpStatus.OK);
	}

	@RequestMapping(value="/acceptUserDetails",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> acceptUserDetails(@RequestBody Users user){
		try {
			user=service.acceptUserDetails(user);
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@RequestMapping(value="/updateProfile",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> updateProfile(@RequestBody Users user){
		try {
			user=service.updateUserDetails(user);
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@RequestMapping(value="/loginUser",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> loginUser(@RequestBody Users user){
		try {
			return new ResponseEntity<Users>(service.loginUser(user.getEmailId(), user.getPassword()),HttpStatus.OK);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/addFriend",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> addFriend(@RequestParam("emailId") String emailId,@RequestParam("userName") String userName){
		
		try {
			service.addFriend(service.getEmailId(userName),service.getUserName(emailId));
			return new ResponseEntity<Users>(service.addFriend(emailId,userName),HttpStatus.OK);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/addPost",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Post> addPost(@RequestParam("emailId") String emailId,@RequestParam("post") String post){
		try {
			return new ResponseEntity<Post>(service.addPost(emailId, post),HttpStatus.OK);
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/addNotification",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Notification> addNotification(@RequestParam("emailId") String emailId,@RequestParam("message") String message,@RequestParam("type") String type,@RequestParam("status") String status,@RequestParam("msgTo") String msgTo){
		try {
			
			return new ResponseEntity<Notification>(service.addNotification(emailId, message, type, status, msgTo),HttpStatus.OK);
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}
		
	@RequestMapping(value="/removeNotification",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Notification> removeNotification(@RequestParam("notId") String notId) throws CapBookServicesDownException{
		System.out.println("inside and string is "+notId);
		return new ResponseEntity<Notification>(service.removeNotification(Integer.valueOf(notId)),HttpStatus.OK);
	}
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Users>> getAllUsers(){
		try {
			return new ResponseEntity<List<Users>>(service.getAllUserDetails(),HttpStatus.OK);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	@RequestMapping(value="/getAllFriends",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<String>> getAllFriends(@RequestParam("emailId") String emailId){
		try {
			return new ResponseEntity<List<String>>(service.getAllFriends(emailId),HttpStatus.OK);
		} catch (FriendNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/getMyPosts",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<String>> getMyPosts(@RequestParam("emailId") String emailId){
		try {
			return new ResponseEntity<List<String>>(service.getMyPosts(emailId),HttpStatus.OK);
		} catch (PostNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/getAllPosts",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<String>> getAllPosts(@RequestParam("emailId") String emailId){
		
		try {
			return new ResponseEntity<List<String>>(service.getAllPosts(emailId),HttpStatus.OK);
		} catch (PostNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/getAllNotifications",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Notification>> getAllNotifications(@RequestParam("emailId") String emailId){
		try {
			//System.out.println(service.getName(service.getAllNotification(emailId).get(0).substring(0,service.getAllNotification(emailId).get(0).indexOf('-') )));
			return new ResponseEntity<List<Notification>>(service.getAllNotification(emailId),HttpStatus.OK);
		} catch (NotificationNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/searchFriend",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Profile>> searchFriend(@RequestParam("name") String name){
		try {
			return new ResponseEntity<List<Profile>>(service.getAllProfiles(name),HttpStatus.OK);
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/getProfileDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Profile> getProfileDetails(@RequestParam("userName") String userName){
		
		try {
			return new ResponseEntity<Profile>(service.getProfileDetails(userName),HttpStatus.OK);
		} catch (ProfileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="/getUserDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> getUserDetails(@RequestParam("emailId") String emailId){
		try {
			return new ResponseEntity<Users>(service.getUserDetails(emailId),HttpStatus.OK);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
	}
}
