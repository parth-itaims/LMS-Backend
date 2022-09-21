package com.spring.lms.model;

import java.util.List;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(nullable = false, length = 20)
	private String firstName;

	@Column(nullable = false, length = 20)
	private String lastName;

	@Column(unique = true, nullable = false)
	private String emailId;

	@Column(nullable = false)
	private char[] password;

	@Column(nullable = false, length = 10)
	private String role;

	@Column(nullable = true, length = 10)
	private String phoneNum;

	private boolean status;

	@Transient
	private boolean emailError;
	@Transient
	private boolean passwordError;
	@Transient
	private boolean statusError;

	@Lob
	@Column(name = "profile_image", length = Integer.MAX_VALUE)
	byte[] profileImage;

	@Transient
	private List<Integer> myCourses;

	public List<Integer> getMyCourses() {
		return myCourses;
	}

	public void setMyCourses(List<Integer> myCourses) {
		this.myCourses = myCourses;
	}

	public boolean isEmailError() {
		return emailError;
	}

	public void setEmailError(boolean emailError) {
		this.emailError = emailError;
	}

	public boolean isPasswordError() {
		return passwordError;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public void setPasswordError(boolean passwordError) {
		this.passwordError = passwordError;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatusError() {
		return statusError;
	}

	public void setStatusError(boolean statusError) {
		this.statusError = statusError;
	}
}
