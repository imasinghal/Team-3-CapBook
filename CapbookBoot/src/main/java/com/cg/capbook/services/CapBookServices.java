package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;

public interface CapBookServices {
	
	public Users acceptUserDetails(Users user);
	public Users getUserDetails(String userName);
	public Profile getProfileDetails(String name);
	public List<Profile> searchFriend(String name);
	public List<Users> getAllUserDetails();
	public Profile addUserProfile(Profile profile);
	public Users addFriendProfile(Profile profile,Users user);
	public Users loginUser(Users user);
	public Users updateUserDetails(Users user);
	

}
