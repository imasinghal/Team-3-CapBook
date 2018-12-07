package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Profile;

public interface ProfileDAO extends JpaRepository<Profile, String> {
	@Query(value="SELECT * FROM Profile WHERE name LIKE %?1%", nativeQuery=true)
	public List<Profile> getProfiles(String name);
		
	@Query(value="SELECT name FROM Profile where user_name=?1",nativeQuery=true)
	public String getName(String userName);
}
