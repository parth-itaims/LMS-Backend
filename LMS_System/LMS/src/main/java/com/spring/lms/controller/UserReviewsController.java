package com.spring.lms.controller;

import com.spring.lms.model.UserReviews;
import com.spring.lms.service.UserReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/user-reviews")
public class UserReviewsController {

    @Autowired
    private UserReviewsService userReviewsService;

    @PostMapping("/post-review")
    public UserReviews postUserReview(@RequestBody UserReviews userReview){
        return userReviewsService.saveUserReview(userReview);
    }

    @GetMapping("/{courseId}")
    public List<UserReviews> getAllUserReviewsOfCourse(@PathVariable Integer courseId){
        return userReviewsService.loadAllUserReviewForCourse(courseId);

    }

    @DeleteMapping("/{reviewId}")
    public boolean removeUserReview(@PathVariable Integer reviewId){
        return userReviewsService.removeUserReviewFromCourse(reviewId);
    }
}
