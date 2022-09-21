package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.ContactDetails;
import com.spring.lms.service.ContactDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactDetailsController {
	
	@Autowired
	private ContactDetailsService contactDetailsService;

	@PutMapping("/contactDetails")
	public ContactDetails updateData(@RequestBody ContactDetails contactus)
	{
		return contactDetailsService.updateData(contactus);
	}
	
	@GetMapping("/contactDetails")
	public List<ContactDetails> getData()
	{
		return contactDetailsService.getData();
	}
	
//	@PostMapping
//	public ContactDetails sendEmail(@RequestBody ContactDetails contactDetails)
//	{
//		return contactDetailsService.sendEmail(contactDetails)
//	}
}
