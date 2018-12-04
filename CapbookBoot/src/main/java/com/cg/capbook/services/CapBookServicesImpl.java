package com.cg.capbook.services;

import java.util.List;

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
			user = usersDAO.save(user);
			return user;
	}

	@Override
	public Profile addUserProfile(Profile profile) {
		return profileDAO.save(profile);
	}

	@Override
	public Users addFriendProfile(Profile profile, Users user) {
		Users userFi = usersDAO.findById(user.getUserName()).get();
		userFi.addFriend(profile);
		return usersDAO.save(userFi);
	}

	@Override
	public Users loginUser(Users user) {
		if(!user.getPassword().equals(null) && !user.getUserName().equals(null))
			if(!usersDAO.findById(user.getUserName()).get().equals(null))
				if(usersDAO.findById(user.getUserName()).get().getPassword().equals(user.getPassword()))
					return usersDAO.findById(user.getUserName()).get();
		return null;
	}

	@Override
	public Users getUserDetails(String userName) {
		Users user = usersDAO.findById(userName).get();
		if(user!= null) return user;
		
		return null;
	}

	@Override
	public List<Profile> searchFriend(String name) {
		List<Profile> profiles = profileDAO.searchFriend(name);
		if(profiles!=null) return profiles;
		
		return null;
	}

	@Override
	public List<Users> getAllUserDetails() {
		return usersDAO.findAll();
		}
	@Override
	public Users updateUserDetails(Users user) {
		Users temp = usersDAO.findById(user.getUserName()).get();
		usersDAO.delete(user);
		user.setFriends(temp.getFriends());
		return usersDAO.save(user);
	}

}
