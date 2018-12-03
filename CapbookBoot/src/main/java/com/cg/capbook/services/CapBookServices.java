package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;

public interface CapBookServices {
	
	public Users acceptUserDetails(Users user);
	public Profile addUserProfile(Profile profile);
	public Users addFriendProfile(Profile profile,Users user);
	

}
