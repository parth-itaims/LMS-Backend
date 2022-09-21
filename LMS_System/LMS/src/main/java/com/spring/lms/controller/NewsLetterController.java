package com.spring.lms.controller;

import com.spring.lms.model.NewsLetter;
import com.spring.lms.service.NewsLetterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/news-letter")
public class NewsLetterController {

    @Autowired
    private NewsLetterService newsLetterService;

    private Logger logger = LoggerFactory.getLogger(NewsLetterController.class);

    @GetMapping("/{email}")
    public boolean registerToNewsLetter(@PathVariable("email")
                                        String email){

        logger.info(">>> registerToNewsLetter method called with email: {}", email);

        if( ! isUserExistsWithEmailID(email) )
        {
            return newsLetterService.addEmailToNewsLetterList(email);
        }

        return false;
    }

    public boolean isUserExistsWithEmailID(String email){
        return newsLetterService.checkUserExistsInNewsLetter(email);
    }

    public void removeUserIfExists(String email){
        if(  isUserExistsWithEmailID(email) ){
            newsLetterService.removeUserFromNewsLetter(email);
        }
    }

}
