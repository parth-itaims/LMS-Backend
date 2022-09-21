package com.spring.lms.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Lob;

import com.spring.lms.model.Chapters;
import com.spring.lms.model.UserReviews;
import com.spring.lms.service.UserReviewsService;

public class CoursesDTO {
	// c.course_id, c.course_name, c.course_duration, c.course_rating,
	// c.course_status, c.course_price, c.course_image, u.first_name,
	// u.profile_image

	private int courseId;

	private String courseName;

	private String courseDescription;

	private int coursePrice;

	private byte courseDuration;

	private Date courseDate;

	private byte[] courseImage;

	private double courseRating;

	private String courseStatus;

	private int userId;

	private String tutorName;

	private byte[] tutorImage;

	private List<Chapters> chapters;
	
	private List<UserReviews> courseReviews;

	public CoursesDTO() {}

	public CoursesDTO(int courseId, String courseName, String courseDescription, int coursePrice, byte courseDuration,
			Date courseDate, byte[] courseImage, double courseRating, String courseStatus, int userId, String fName,
			String lName, byte[] tutorImage) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.coursePrice = coursePrice;
		this.courseDuration = courseDuration;
		this.courseDate = courseDate;
		this.courseImage = courseImage;
		this.courseRating = courseRating;
		this.courseStatus = courseStatus;
		this.userId = userId;
		this.tutorName = fName + ' ' + lName;
		this.tutorImage = tutorImage;
	}

	public List<UserReviews> getCourseReviews() {
		return courseReviews;
	}

	public void setCourseReviews(List<UserReviews> reviews) {
		this.courseReviews = reviews;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Chapters> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapters> chapters) {
		this.chapters = chapters;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public byte getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(byte courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	public byte[] getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(byte[] courseImage) {
		this.courseImage = courseImage;
	}

	public double getCourseRating() {
		return courseRating;
	}

	public void setCourseRating(double courseRating) {
		this.courseRating = courseRating;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public byte[] getTutorImage() {
		return tutorImage;
	}

	public void setTutorImage(byte[] tutorImage) {
		this.tutorImage = tutorImage;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
}
