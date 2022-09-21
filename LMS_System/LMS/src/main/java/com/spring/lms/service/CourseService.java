package com.spring.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lms.dto.CoursesDTO;
import com.spring.lms.model.Course;
import com.spring.lms.model.User;
import com.spring.lms.repository.CourseRepo;
import com.spring.lms.utility.ImageUtility;
import com.spring.lms.utility.NewsLetterUtility;

@Service
@Transactional
public class CourseService {

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private UserService userService;

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private UserReviewsService userReviewsService;

	@Autowired
	private NewsLetterUtility newsLetterUtility;

	@Value("${app.host.port}")
	private String hostAddress;

	public Course saveCourse(Course course) {
		User user = userService.getUserDataById(course.getUserId());
		course.setUser(user);

		sendNewsLetterUpdate(course.getCourseId(), user, course.getCourseName(), course.getCoursePrice());

		return courseRepo.save(course);
	}

	private void sendNewsLetterUpdate(int courseId, User tutor, String courseName, int coursePrice) {

		String emailSubject = tutor.getFirstName() + " Added " + courseName + " !!";

		String link = this.hostAddress + "homepage/courses/" + courseId;
		String emailBody = "<div style = 'background-color:rgb(229 231 235)'>"
				+ "<h2 style = 'border:2px solid black; font-size: 2rem; padding: 0.5rem; font-weight:bold'>"
				+ courseName.toUpperCase() + " BY " + tutor.getFirstName().toUpperCase() + "</h2>"
				+ "<div style = 'font-size: 1rem;'>" + "<p>Checkout this course </p>" + "<a href =" + link + ">"
				+ courseName + "</a>" + "<br><br>"
				+ "<span style = 'font-weight:bold;'>Course Will Start Soon. Click Above Link For More Details.</span>"
				+ "<span style = 'font-weight:bold;'>Course Price:" + coursePrice + " Rs.</span>"
				+ "<p style='font-style:italic; font-weight:bold'>Happy Learning, <br> CourseLog.</p>" + "</div>"
				+ "</div>";
		newsLetterUtility.sendNewsLetterUpdateEmail(emailSubject, emailBody);
	}

	public List<CoursesDTO> getCourses() {
		// TODO Auto-generated method stub
		List<CoursesDTO> list = courseRepo.getCourses();
		list.stream().map(l -> {
			l.setChapters(chapterService.getChaptersList(l.getCourseId()));
			l.setCourseReviews(userReviewsService.loadAllUserReviewForCourse(l.getCourseId()));
			return l;
		}).collect(Collectors.toList());
		return list;
	}

	public CoursesDTO getCourse(int courseId) {
		CoursesDTO course = courseRepo.getCourse(courseId);
		course.setChapters(chapterService.getChaptersList(course.getCourseId()));
		course.setCourseReviews(userReviewsService.loadAllUserReviewForCourse(course.getCourseId()));
		return course;
	}

	public Course updateCourse(Course course) {
		User user = userService.getUserDataById(course.getUserId());
		Course existingCourse = courseRepo.findById(course.getCourseId()).orElse(null);

		existingCourse.setCourseName(course.getCourseName());
		existingCourse.setCourseDescription(course.getCourseDescription());
		existingCourse.setCoursePrice(course.getCoursePrice());
		existingCourse.setCourseDuration(course.getCourseDuration());
		existingCourse.setCourseDate(course.getCourseDate());
		existingCourse.setUser(user);
		return courseRepo.save(existingCourse);
	}

	public String deleteCourse(int courseId) {
		courseRepo.deleteById(courseId);
		return null;
	}

	public boolean savecourseImage(int id, MultipartFile courseImage) {
		Optional<Course> courseobj = courseRepo.findById(id);
		if (courseobj.isPresent()) {
			Course obj = courseobj.get();
			try {
				obj.setCourseImage(ImageUtility.compressImage(courseImage));
				courseRepo.save(obj);
				return true;
			} catch (Exception e) {
				System.out.println("\nError during file upload... " + e.getMessage());
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	public Optional<Course> getCourseDetailsById(int courseId) {
		return courseRepo.findByCourseId(courseId);
	}

	public void updateCourseRating(double courseRating, int courseId) {
		courseRepo.updateCourseRatingById(courseRating, courseId);
	}

	public Optional<List<Integer>> getMyCourses(int userId) {
		return this.courseRepo.getMyCourses(userId);
	}

	public List<Course> getTutorCourses(int user_id) {
		// TODO Auto-generated method stub
		List<Integer> courseId = courseRepo.getMyCourses(user_id).orElse(null);
		return courseRepo.findAllById(courseId);
	}
}
