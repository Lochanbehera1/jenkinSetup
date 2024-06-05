package com.lochanit.service;

import com.lochanit.Entity.Company;
import com.lochanit.Entity.Review;
import com.lochanit.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private CompanyService companyService;

    @Override
    public boolean createReview(Review review, Long companyId) {
        Company company = companyService.getIdCompany(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Review> getAllReview(Long companyId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }

    @Override
    public boolean deleteReviewById(Long companyId,Long reviewId) {
       if(companyService.getIdCompany(companyId)!=null && reviewRepo.existsById(reviewId)) {
           Review review=reviewRepo.findById(reviewId).orElse(null);
           Company company=review.getCompany();
           company.getReviews().remove(review);
           review.setCompany(null);
           companyService.updateCompanyById(companyId,company);
           return true;
       }else{
           return false;
       }

    }

    @Override
    public boolean updateReviewById(Long companyId, Long reviewId, Review updateReview) {

        if (companyService.getIdCompany(companyId) != null) {
            updateReview.setCompany(companyService.getIdCompany(companyId));
            updateReview.setId(reviewId);
            reviewRepo.save(updateReview);
            return true;
        }else{
            return false;
        }
    }
}