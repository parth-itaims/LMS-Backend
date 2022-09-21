package com.spring.lms.utility;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GenerateOTP {

	@Value("0123456789")
	private String numbers;
	
	private Random random;
	
	public String generateOTP(int length) {
		this.random = new Random();
		char otp[] = new char[length];
		for(int i = 0;i<length;i++) {
			otp[i] = numbers.charAt(random.nextInt(numbers.length()));
		}
		
		return new String(otp);
	}

}
