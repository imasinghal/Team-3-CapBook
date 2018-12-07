package com.cg.capbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.capbook.exceptions.UserNotFoundException;
import com.cg.capbook.services.CapBookServices;


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
		user=service.acceptUserDetails(user);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}

	@RequestMapping(value="/updateProfile",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> updateProfile(@RequestBody Users user){
		user=service.updateUserDetails(user);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}

	@RequestMapping(value="/loginUser",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> loginUser(@RequestBody Users user){
		return new ResponseEntity<Users>(service.loginUser(user.getEmailId(), user.getPassword()),HttpStatus.OK);
	}

	@RequestMapping(value="/addFriend",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> addFriend(@RequestParam("emailId") String emailId,@RequestParam("userName") String userName){
		System.out.println("endndnd");
		System.out.println(userName+"   emao  "+emailId );
		return new ResponseEntity<Users>(service.addFriend(emailId,userName),HttpStatus.OK);
	}
	
	@RequestMapping(value="/addPost",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Post> addPost(@RequestParam("emailId") String emailId,@RequestParam("post") String post){
		System.out.println("post is "+post);
		return new ResponseEntity<Post>(service.addPost(emailId, post),HttpStatus.OK);
	}
	@RequestMapping(value="/addNotification",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Notification> addNotification(@RequestParam("emailId") String emailId,@RequestParam("message") String message,@RequestParam("type") String type,@RequestParam("status") String status,@RequestParam("msgTo") String msgTo){
		return new ResponseEntity<Notification>(service.addNotification(emailId, message, type, status, msgTo),HttpStatus.OK);
	}
		
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Users>> getAllUsers(){
		System.out.println("Chavo");
		System.out.println(service.getAllUserDetails());
		return new ResponseEntity<List<Users>>(service.getAllUserDetails(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllFriends",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<String>> getAllFriends(@RequestParam("emailId") String emailId){
		return new ResponseEntity<List<String>>(service.getAllFriends(emailId),HttpStatus.OK);
	}
	@RequestMapping(value="/getMyPosts",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<String>> getMyPosts(@RequestParam("emailId") String emailId){
		return new ResponseEntity<List<String>>(service.getMyPosts(emailId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllPosts",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<String>> getAllPosts(@RequestParam("emailId") String emailId){
		
		return new ResponseEntity<List<String>>(service.getAllPosts(emailId),HttpStatus.OK);
	}

	@RequestMapping(value="/getAllNotifications",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<String>> getAllNotifications(@RequestParam("emailId") String emailId){
		return new ResponseEntity<List<String>>(service.getAllNotification(emailId),HttpStatus.OK);
	}

	@RequestMapping(value="/searchFriend",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Profile>> searchFriend(@RequestParam("name") String name){
		return new ResponseEntity<List<Profile>>(service.getAllProfiles(name),HttpStatus.OK);
	}
	@RequestMapping(value="/getProfileDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Profile> getProfileDetails(@RequestParam("userName") String userName){
		Profile profile = service.getProfileDetails(userName);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	@RequestMapping(value="/getUserDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> getUserDetails(@RequestParam("emailId") String emailId) throws UserNotFoundException{//throws Exception{
		return new ResponseEntity<Users>(service.getUserDetails(emailId),HttpStatus.OK);
	}
}
