package com.spring.lms.controller;

import com.spring.lms.model.User;
import com.spring.lms.service.EnrollmentService;
import com.spring.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUsers() {
		return userService.getUserList();
	}

	@GetMapping({ "/user/{user_id}", "/tutor/{user_id}" })
	public User getUserById(@PathVariable int user_id) {
		return userService.getUserDataById(user_id);
	}

	@DeleteMapping({ "/user/{user_id}", "/tutor/{user_id}" })
	public String deleteUser(@PathVariable int user_id) {
		return userService.deleteUserData(user_id);
	}

	@GetMapping("/unblock-user/{user_id}")
	public String unblockUser(@PathVariable int user_id) {
		return userService.unblockUser(user_id);
	}

	@PutMapping({ "/user", "/tutor" })
	public User updateUser(@RequestBody User user) {
		return userService.updateUserData(user);
	}

	@PostMapping("/user/forgot-password")
	public Boolean forgotPassword(@RequestBody String userEmail) {
		System.out.println("\nUser Email: " + userEmail);
		Boolean isUserExists = userService.isUserExistsWithEmail(userEmail);
		return isUserExists;
	}

	@PostMapping("/tutor")
	public User addTutor(@RequestBody User user) throws IOException {
		return userService.saveTutor(user);
	}

	@GetMapping("/tutor")
	public List<User> getTutors() {
		return userService.getTutors();
	}

	@PostMapping("/tutor/save-tutor/{id}")
	public boolean uploadTutorImage(@PathVariable("id") int id,
			@RequestParam("profileImage") MultipartFile profileImage) throws IOException {
		System.out.println("\nUpload tutor profile image called....\n");
		return userService.saveTutorProfileImage(id, profileImage);
	}

}
