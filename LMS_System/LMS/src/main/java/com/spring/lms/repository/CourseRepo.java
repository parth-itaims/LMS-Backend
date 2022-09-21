package com.spring.lms.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.lms.dto.CoursesDTO;
import com.spring.lms.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

	Course findBycourseName(String courseName);
	
	@Query("SELECT new com.spring.lms.dto.CoursesDTO(c.courseId, c.courseName, c.courseDescription, c.coursePrice, c.courseDuration, c.courseDate, c.courseImage, c.courseRating, c.courseStatus, u.userId, u.firstName, u.lastName, u.profileImage) "
			+ "FROM Course as c "
			+ "INNER JOIN User as u ON (c.user.userId = u.userId)")
	List<CoursesDTO> getCourses();
	
	@Query("SELECT new com.spring.lms.dto.CoursesDTO(c.courseId, c.courseName, c.courseDescription, c.coursePrice, c.courseDuration, c.courseDate, c.courseImage, c.courseRating, c.courseStatus, u.userId, u.firstName, u.lastName, u.profileImage) "
			+ " FROM Course as c"
			+ " INNER JOIN User as u ON (c.user.userId = u.userId)"
			+ " WHERE c.courseId = :courseId")
	CoursesDTO getCourse(int courseId);

	Optional<Course> findByCourseId(int courseId);

	/**
	Method to get all user email address
	 */

	/**
	 Method to update Course Rating
	 */

	@Modifying
	@Transactional
	@Query(
			nativeQuery = true,
			value = "UPDATE course as c " +
					"SET c.course_rating = ?1 " +
					"WHERE c.course_id = ?2"
	)
	void updateCourseRatingById(double courseRating, int courseId);

	@Query("SELECT courseId from Course where user.userId = :userId")
	Optional<List<Integer>> getMyCourses(int userId);
//
//	@Query("SELECT courseId from Course where user.userId = :user_id")
//	List<Course> findCourseIdByUserId(int user_id);
}