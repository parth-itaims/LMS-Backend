package com.spring.lms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.NewsLetter;
import com.spring.lms.repository.NewsLetterRepository;

@Service
@Transactional
public class NewsLetterService {

	@Autowired
	private NewsLetterRepository newsLetterRepository;

	private Logger logger = LoggerFactory.getLogger(NewsLetterService.class);

	public boolean addEmailToNewsLetterList(String email) {
		logger.info("--- Service = Adding Email ID TO News Letter List: {}", email);

		Optional<NewsLetter> newsLetter = isNewsLetterEmailExists(email);

		if (newsLetter.isPresent())
			return true;

		newsLetterRepository.save(new NewsLetter(email));
		return true;
	}

	private Optional<NewsLetter> isNewsLetterEmailExists(String email) {
		return newsLetterRepository.findByEmail(email);
	}

	public boolean checkUserExistsInNewsLetter(String email) {
		Optional<NewsLetter> optionalNewsLetter = newsLetterRepository.findByEmail(email);

		logger.info("---> User exists in NewsLetter : {} ", optionalNewsLetter);

		return optionalNewsLetter.isPresent();
	}

	public void removeUserFromNewsLetter(String email) {
		newsLetterRepository.deleteByEmail(email);
	}

	public List<String> listAllEmailAddressFromNewsLetter() {
		logger.info("---> Listing all email address from news letter");
		return newsLetterRepository.getAllEmailAddressFromNewsLetter();
	}
}
