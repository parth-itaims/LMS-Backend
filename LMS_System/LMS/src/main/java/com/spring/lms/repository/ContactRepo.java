package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
