package com.spring.lms.model;

import java.io.Serializable;
//import java.sql.Date;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Chapters implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chapterId;

	@Column(nullable = false, length = 30)
	private String chapterName;

	@Column(nullable = false)
	private String chapterlink;

	@Column(nullable = false)
	private Date chapterDate;

	@Transient
	private int courseId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "course_fk")
	private Course course;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getChapterlink() {
		return chapterlink;
	}

	public void setChapterlink(String chapterlink) {
		this.chapterlink = chapterlink;
	}

	public Date getChapterDate() {
		return chapterDate;
	}

	public void setChapterDate(Date chapterDate) {
		this.chapterDate = chapterDate;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
