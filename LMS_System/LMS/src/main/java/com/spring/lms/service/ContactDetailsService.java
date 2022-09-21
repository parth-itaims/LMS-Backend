package com.spring.lms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.ContactDetails;
import com.spring.lms.repository.ContactDetailsRepo;

@Service
@Transactional
public class ContactDetailsService {

	@Autowired
	private ContactDetailsRepo contactDetailsRepo;

	public ContactDetails addData(ContactDetails contactus) {
		// TODO Auto-generated method stub
		return contactDetailsRepo.save(contactus);
	}

	public ContactDetails updateData(ContactDetails contactus) {
		// TODO Auto-generated method stub

		ContactDetails exisitingData = contactDetailsRepo.findById(contactus.getcId()).orElse(null);
		exisitingData.setEmailId(contactus.getEmailId());
		exisitingData.setPhoneNumber(contactus.getPhoneNumber());
		exisitingData.setAddress(contactus.getAddress());

		return contactDetailsRepo.save(exisitingData);
	}

	public List<ContactDetails> getData() {
		// TODO Auto-generated method stub
		return contactDetailsRepo.findAll();
	}

}
