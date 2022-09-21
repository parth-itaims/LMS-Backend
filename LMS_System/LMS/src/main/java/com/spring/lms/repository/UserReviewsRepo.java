package com.spring.lms.repository;

import com.spring.lms.model.UserReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserReviewsRepo extends JpaRepository<UserReviews, Integer> {

    @Query("SELECT SUM(u.courseRating), COUNT(*) FROM UserReviews AS u WHERE u.courseId = ?1")
    List<List<Integer>> countTotalByCourseId(Integer courseId);

    List<UserReviews> findByCourseId(Integer courseId);

    @Modifying
    @Transactional
    void deleteByReviewId(Integer reviewId);
}
