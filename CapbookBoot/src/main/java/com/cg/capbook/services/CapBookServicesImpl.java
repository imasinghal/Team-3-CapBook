package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;
import com.cg.capbook.dao.ProfileDAO;
import com.cg.capbook.dao.UsersDAO;

@Component("service")
public class CapBookServicesImpl implements CapBookServices {

	@Autowired
	UsersDAO usersDAO;
	@Autowired
	ProfileDAO profileDAO;
	@Override
	public Users acceptUserDetails(Users user) {
			return usersDAO.save(user);
	}

	@Override
	public Profile addUserProfile(Profile profile) {
		return profileDAO.save(profile);
	}

	@Override
	public Users addFriendProfile(Profile profile, Users user) {
		System.out.println("BIBIBI");
		Users userFi = usersDAO.findById(user.getUserName()).get();
		userFi.addFriend(profile);
		
		System.out.println("CICIC");
		return usersDAO.save(userFi);
	}

}
