package com.spring.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Contact implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	
	@Transient
	private String replyMessage;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(unique = true)
	private String emailId;
	
	@Column(nullable = false, length = 300)
	private String message;
	
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReplyMessage() {
		return replyMessage;
	}
	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}
	
	
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", replyMessage=" + replyMessage + ", name=" + name + ", emailId=" + emailId
				+ ", message=" + message + ", status=" + status + "]";
	}
	
	
	
	

}
