package com.spring.lms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	public SimpleMailMessage sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("emailtestingforspring@gmail.com");
		message.setTo("shubhamjansari11@gmail.com");
		message.setSubject("Your Password");
		message.setText("Testing purpose");

		javaMailSender.send(message);

		return message;

	}
}
