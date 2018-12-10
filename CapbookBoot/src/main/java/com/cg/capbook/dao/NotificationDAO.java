package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Notification;

public interface NotificationDAO extends JpaRepository<Notification, Integer>{

	@Query(value="SELECT * FROM notification where user_email_Id=?1",nativeQuery=true)
	public List<Notification> getNotification(String email);
}
