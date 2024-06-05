package com.lochanit.RestController;

import com.lochanit.Entity.Company;
import com.lochanit.Entity.Review;
import com.lochanit.service.CompanyService;
import com.lochanit.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @PostMapping("reviews")
    public ResponseEntity<?> createReview(@RequestBody Review review,@PathVariable Long companyId) {
     boolean isReviewSaved= reviewService.createReview(review,companyId);
     if(isReviewSaved) {
         return new ResponseEntity<>("review saved successful", HttpStatus.CREATED);
     }else {
         return new ResponseEntity<>("review not saved ", HttpStatus.BAD_REQUEST);
     }
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAll(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId) {
        Review reviewById = reviewService.getReviewById(companyId,reviewId);
        return new ResponseEntity<>(reviewById, HttpStatus.OK);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId) {
        boolean isReviewDeleted=reviewService.deleteReviewById(companyId,reviewId);
        if(isReviewDeleted){
            return new ResponseEntity<>("deleted successful", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("deleted successful", HttpStatus.OK);
        }


    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,
                                               @RequestBody Review updateReview) {
        boolean isReviewUpdated=reviewService.updateReviewById(companyId,reviewId,updateReview);
        if (isReviewUpdated){
            return new ResponseEntity<>("update successful", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("update successful", HttpStatus.OK);
        }

    }


}
