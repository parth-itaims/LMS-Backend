package com.spring.lms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_reviews")
public class UserReviews implements Serializable
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;

    @Column(nullable = false, length = 1)
    private int courseRating;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int courseId;

    private Date reviewDate;

    @Column(name = "courseReview", nullable = false, length = 300)
    private String reviewDescription;

    @Column(length = 40)
    private String userName;

    public UserReviews() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(int courseRating) {
        this.courseRating = courseRating;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
