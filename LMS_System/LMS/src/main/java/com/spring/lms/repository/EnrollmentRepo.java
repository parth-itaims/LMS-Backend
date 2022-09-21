package com.spring.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Enrollment;
import com.spring.lms.model.User;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {

	Enrollment findByorderId(String orderId);

	@Query(value = "select course_id from enrollment where user_id = :id", nativeQuery = true)
	Optional<List<Integer>> getMyCourses(int id);

	@Query(value = "select user_id from enrollment where course_id = :c_id", nativeQuery = true)
	List<Integer> getUserIdByCourseId(int c_id);

}
