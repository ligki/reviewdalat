package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.constant.ReviewObjectType;
import com.ligki.reviewdalat.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController extends BaseController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/place/newest")
    ResponseEntity<?> getNewestPlaceReviews() {
        return handleResponse(reviewService.getNewestReviewObject(ReviewObjectType.PLACE));
    }
}
