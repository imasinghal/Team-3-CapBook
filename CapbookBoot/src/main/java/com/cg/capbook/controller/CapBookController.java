package com.cg.capbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	Users temp;
	
	@RequestMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("hi yoyo",HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptUserDetails",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> acceptUserDetails(@RequestBody Users user){
		user=service.acceptUserDetails(user);
		temp=user;
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptUserFriends",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Users> acceptFriendDetails(@RequestBody Profile profile){
		System.out.println("hihihi");
		profile.setUser(temp);
		Users user=service.addFriendProfile(profile, temp);
		System.out.println("dididi");
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	
	

}
