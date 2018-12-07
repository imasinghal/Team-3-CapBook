package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Notification {
	
	@Id
	@SequenceGenerator(name="not_seq",sequenceName="not_seq",initialValue=123,allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="not_seq")
	private int id;
	
	private String notMsg;
	private String type;
	private String status;//either reject or accept
	private String msgTo;
	
	@JsonBackReference
	@ManyToOne
	private Users user;

	public Notification(int id, String notMsg, String type, String status, String msgTo, Users user) {
		super();
		this.id = id;
		this.notMsg = notMsg;
		this.type = type;
		this.status = status;
		this.msgTo = msgTo;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", notMsg=" + notMsg + ", type=" + type + ", status=" + status + ", msgTo="
				+ msgTo + ", user=" + user + "]";
	}

	public String getMsgTo() {
		return msgTo;
	}

	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotMsg() {
		return notMsg;
	}

	public void setNotMsg(String notMsg) {
		this.notMsg = notMsg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}


	public Notification() {
		super();
	}

	
}
