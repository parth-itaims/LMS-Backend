package com.spring.lms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lms.dto.CoursesDTO;
import com.spring.lms.model.Chapters;
import com.spring.lms.model.Course;
import com.spring.lms.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	@GetMapping("/course")
	public List<CoursesDTO> getCourse() {
		return courseService.getCourses();
	}

	@GetMapping("/course/{courseId}")
	public CoursesDTO getCourse(@PathVariable int courseId) {
		return courseService.getCourse(courseId);
	}

	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		
		return courseService.updateCourse(course);
	}

	@DeleteMapping("/course/{courseId}")
	public String deleteCourse(@PathVariable int courseId) {
		return courseService.deleteCourse(courseId);
	}

	@PostMapping("/course/save-course/{id}")
	public boolean uploadCourseImage(@PathVariable("id") int id, @RequestParam("courseImage") MultipartFile courseImage)
			throws IOException {
		System.out.println("\nUpload course  image called....\n");
		return courseService.savecourseImage(id, courseImage);
	}
	
	@GetMapping("/getTutorCourses/{user_id}")
	public List<Course> getTutorCourses(@PathVariable int user_id)
	{
		return courseService.getTutorCourses(user_id);
	}
}
