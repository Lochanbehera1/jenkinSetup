package com.lochanit.service;

import com.lochanit.Entity.Review;

import java.util.List;

public interface ReviewService {
    boolean createReview(Review review,Long companyId);
    List<Review> getAllReview(Long companyId);
    Review getReviewById(Long companyId,Long reviewId);
    boolean deleteReviewById(Long companyId,Long reviewId);
    boolean updateReviewById(Long companyId,Long reviewId,Review updateReview);

}
