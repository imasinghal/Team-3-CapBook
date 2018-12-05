package com.cg.capbook.controller;

import java.util.ArrayList;
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

import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;
import com.cg.capbook.dao.UsersDAO;
import com.cg.capbook.services.CapBookServices;


@CrossOrigin
@RestController
public class CapBookController {
	
	@Autowired
	CapBookServices service;
	
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
	@RequestMapping(value="/getUserDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> getUserDetails(@RequestParam("userName") String userName){
		Users user=service.getUserDetails(userName);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	@RequestMapping(value="/getProfileDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Profile> getProfileDetails(@RequestParam("emailId") String emailId){
		Profile profile = service.getProfileDetails(emailId);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	@RequestMapping(value="/searchFriend",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Profile>> searchFriend(@RequestParam("name") String name){
		System.out.println(name);
		List<Profile> profiles=service.searchFriend(name);
		return new ResponseEntity<List<Profile>>(profiles,HttpStatus.OK);
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> loginUser(@RequestBody Users user){
		user=service.loginUser(user);
		if(user==null)
			return new ResponseEntity<Users>(null);
		else
			return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	@RequestMapping(value="/addBulkUserDetails", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBulkUserDetails(@RequestBody ArrayList<Users> users){
		for(Users user: users)
			service.acceptUserDetails(user);
		return new ResponseEntity<>("User Details successfully added", HttpStatus.OK);
	}
	@RequestMapping(value= {"allUserDetails"},method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<List<Users>> getAllUserDetails(){
		List<Users> userList = service.getAllUserDetails();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	@RequestMapping(value="/updateUserDetails",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> updateUserDetails(@RequestBody Users user){
		user=service.updateUserDetails(user);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	

}
