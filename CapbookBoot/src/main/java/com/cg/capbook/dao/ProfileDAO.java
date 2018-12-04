package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Profile;
import com.cg.capbook.beans.Users;

public interface ProfileDAO extends JpaRepository<Profile, String> {
	@Query(value="SELECT * FROM Profile WHERE name LIKE %?1%", nativeQuery=true)
	List<Profile> searchFriend(String name);
}
