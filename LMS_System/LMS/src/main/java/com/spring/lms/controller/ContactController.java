package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.ContactDetails;
import com.spring.lms.model.User;
import com.spring.lms.model.Contact;
import com.spring.lms.service.ContactService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contact")
	public Contact save( @RequestBody Contact contactUs)
	{
		return contactService.add(contactUs);
	}
	
	@GetMapping("/contact")
	public List<Contact> getDetails()
	{
		return contactService.getDetails();
	}
	
	@GetMapping("/contact/{cId}")
	public Contact getcontactById(@PathVariable int cId)
	{
		return contactService.getcontactById(cId);
	}
	
	@PostMapping("/contact-reply")
	public Boolean getEmailData(@RequestBody Contact contact)
	{
		
		return contactService.sendEmailData(contact);
	}

}
