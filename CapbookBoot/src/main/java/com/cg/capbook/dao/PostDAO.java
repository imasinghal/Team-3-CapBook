package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {

	@Query(value="SELECT post_content FROM post where user_email_Id=?1",nativeQuery=true)
	public List<String> getPosts(String email);
}
