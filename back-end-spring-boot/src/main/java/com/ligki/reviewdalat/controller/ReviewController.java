package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController extends BaseController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/{type:place|coffee-shop|hotel|food}/newest")
    ResponseEntity<?> getNewestReviews(@PathVariable(value = "type", required = true) String type) {
        return handleResponse(reviewService.getNewestReviewObject(type));
    }

    @GetMapping("/{type:place|coffee-shop|hotel|food}/best")
    ResponseEntity<?> getBestReviews(@PathVariable(value = "type", required = true) String type) {
        return handleResponse(reviewService.getBestReviewObject(type));
    }

    @GetMapping("/{type:place|coffee-shop|hotel|food}/worst")
    ResponseEntity<?> getWorstReviews(@PathVariable(value = "type", required = true) String type) {
        return handleResponse(reviewService.getWorstReviewObject(type));
    }

}
