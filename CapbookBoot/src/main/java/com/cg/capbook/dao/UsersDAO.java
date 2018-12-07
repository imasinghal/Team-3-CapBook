package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Users;

public interface UsersDAO extends JpaRepository<Users, String> {
	@Query(value="SELECT email_id FROM users where profile_user_name=?1",nativeQuery=true)
	public String getEmailId(String userName);
	
	@Query(value="SELECT profile_user_name FROM users where email_id=?1",nativeQuery=true)
	public String getUserName(String emailId);

}
