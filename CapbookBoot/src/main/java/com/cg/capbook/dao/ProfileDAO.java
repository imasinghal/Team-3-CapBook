package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.Profile;

public interface ProfileDAO extends JpaRepository<Profile, String> {

}
