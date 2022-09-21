package com.spring.lms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.spring.lms.model.Course;
import com.spring.lms.model.UserReviews;
import com.spring.lms.repository.UserReviewsRepo;

@Service
@Transactional
public class UserReviewsService {

	private Logger logger = LoggerFactory.getLogger(UserReviewsService.class);

	@Autowired
	private UserReviewsRepo userReviewsRepo;

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	public UserReviews saveUserReview(UserReviews userReview) {
		userReview.setReviewDate(new Date());
		logger.info(">>> Saving User Review in database");
		Optional<String> getFullName = Optional.ofNullable(userService.getFullNameOfUser(userReview.getUserId()));

		if (getFullName.isPresent()) {
			System.out.println("Full UserName: " + getFullName.get());
			userReview.setUserName(getFullName.get());
		}

		userReviewsRepo.save(userReview);
		Optional<Course> upCourse = updateCourseRating(userReview.getCourseId());
		return upCourse.isPresent() ? userReview : null;
	}

	public Optional<Course> updateCourseRating(int courseId) {

		List<List<Integer>> getTotalRatingWithUser = userReviewsRepo.countTotalByCourseId(courseId);

		if (getTotalRatingWithUser == null)
			return Optional.empty();
		if (getTotalRatingWithUser.size() == 0)
			return Optional.empty();
		if (getTotalRatingWithUser.get(0).get(0) == null || getTotalRatingWithUser.get(0).get(1) == null)
			return Optional.empty();

		int totalRating = getTotalRatingWithUser.get(0).get(0);
		int totalUser = getTotalRatingWithUser.get(0).get(1);

		logger.info(">>> Total Rating , User {} , {}", totalRating, totalUser);
		Optional<Course> getCourse = courseService.getCourseDetailsById(courseId);
		double result = totalRating / totalUser;
		double updateRating = Double.parseDouble(String.format("%.2f", result));

		getCourse.get().setCourseRating(updateRating);
		logger.info(">>> Course Rating: {}", updateRating);

		logger.info(">> UPDATING COURSE RATING ");
//        courseService.updateCourse(getCourse.get());
		courseService.updateCourseRating(getCourse.get().getCourseRating(), getCourse.get().getCourseId());
		return getCourse;
	}

	public List<UserReviews> loadAllUserReviewForCourse(Integer courseId) {
		logger.info(">>> Fetching all user review from database");
		return userReviewsRepo.findByCourseId(courseId);
	}

	@Transactional
	@Modifying
	public boolean removeUserReviewFromCourse(Integer reviewId) {
		logger.info(">>> REmoving review from database");
		Optional<UserReviews> userReview = userReviewsRepo.findById(reviewId);
		int courseId = userReview.get().getCourseId();
		System.out.println(userReview);
		userReviewsRepo.deleteByReviewId(reviewId);
		System.out.println("\n\n >>> REview ID removed");
		Optional<Course> upCourse = updateCourseRating(courseId);
		return true;
	}
}
