package com.spring.lms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.User;
import com.spring.lms.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
			
	@Autowired
	UserService userService;
	
	@PostMapping("/register/sendotp")
	public ResponseEntity<String> sendOTP(@RequestBody Map<String,String> data) {
		return ResponseEntity.ok(this.userService.sendOTP(data));
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user){
		return userService.signUp(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user);	
	}

}
