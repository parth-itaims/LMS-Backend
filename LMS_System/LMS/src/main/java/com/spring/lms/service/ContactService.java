package com.spring.lms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.Contact;
import com.spring.lms.model.User;
import com.spring.lms.repository.ContactRepo;
import com.spring.lms.utility.EmailUtility;

@Service
@Transactional
public class ContactService {

	@Autowired
	private ContactRepo contactRepo;

	@Autowired
	private EmailUtility emailUtility;

	public Contact add(Contact contactUs) {
		// TODO Auto-generated method stub
		return contactRepo.save(contactUs);
	}

	public List<Contact> getDetails() {
		// TODO Auto-generated method stub
		return contactRepo.findAll();
	}

	public Contact getcontactById(int cId) {
		// TODO Auto-generated method stub
		return contactRepo.findById(cId).orElse(null);
	}

	public Boolean sendEmailData(Contact contact) {
		// TODO Auto-generated method stub
		String emailTo = contact.getEmailId();
		String firstName = contact.getName();
		// System.out.println(contact);
		String replyMessage = contact.getReplyMessage();
		System.out.println("name:" + firstName);
		System.out.println("email:" + emailTo);
		String emailBody = "<div style ='text-align:center'>" + "<h1>Hello " + firstName + ",</h1>" + "<hr /><br>"
				+ "<h3>Here's Your Question</h3>" + "<h2>" + contact.getMessage()
				+ "</h2><br> + <h3>Here's Response From our Side</h3>" + "<h2>" + replyMessage + "</h2><br> "
				+ "<br><span>Thank you for Contact Us.</span>" + "</div>";
		String emailSubject = "Reply from CourseLog";

		boolean result = emailUtility.sendHTMLEmail(emailTo, emailSubject, emailBody);
		if (result) {
			contact.setStatus(1);
			contactRepo.save(contact);
		}
		return result;

	}

}
