 package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Friend;
public interface FriendDAO extends JpaRepository<Friend, Integer> {

	@Query(value="SELECT name FROM Friend where user_email_Id=?1",nativeQuery=true)
	public List<String> getFriends(String email);
	
	@Query(value="SELECT user_name FROM Friend where user_email_Id=?1",nativeQuery=true)
	public List<String> getFriendsUserName(String email);
}
