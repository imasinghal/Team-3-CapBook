package com.cg.capbook.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Notification;
import com.cg.capbook.beans.Photo;

public interface PhotoDAO extends JpaRepository<Photo	, Integer>{
	
	@Query(value="SELECT max(photo_Id) FROM photo",nativeQuery=true)
	public int getMaxId();
	
	@Query(value="SELECT max(photo_Id) FROM photo where user_email_Id=?1 and type='profile'",nativeQuery=true)
	public int getId(String email);
	
	@Query(value="SELECT photo_Id FROM photo where user_email_Id=?1 and type='profile'",nativeQuery=true)
	public List<BigDecimal> getAllId(String email);

}