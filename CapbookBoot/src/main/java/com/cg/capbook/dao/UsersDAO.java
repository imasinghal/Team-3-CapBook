package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.Users;

public interface UsersDAO extends JpaRepository<Users, String> {

}
