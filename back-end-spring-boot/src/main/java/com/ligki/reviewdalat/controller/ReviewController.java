package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController extends BaseController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/{type:place|coffee-shop|hotel|food}/newest")
    ResponseEntity<?> getNewestReviews(@PathVariable(value = "type") String type, @RequestParam(value = "page", defaultValue = "1") String page) {
        return handleResponse(reviewService.getNewestReviewObject(type, page));
    }

    @GetMapping("/{type:place|coffee-shop|hotel|food}/best")
    ResponseEntity<?> getBestReviews(@PathVariable(value = "type") String type, @RequestParam(value = "page", defaultValue = "1") String page) {
        return handleResponse(reviewService.getBestReviewObject(type, page));
    }

    @GetMapping("/{type:place|coffee-shop|hotel|food}/worst")
    ResponseEntity<?> getWorstReviews(@PathVariable(value = "type") String type, @RequestParam(value = "page", defaultValue = "1") String page) {
        return handleResponse(reviewService.getWorstReviewObject(type, page));
    }

    @GetMapping("/{type:place|coffee-shop|hotel|food}/{id}")
    ResponseEntity<?> getReviewDetail(@PathVariable(value = "type") String type,
                                      @PathVariable(value = "id") String id) {
        return handleResponse(reviewService.getDetail(id));
    }

    @GetMapping("/search")
    ResponseEntity<?> searchReviewDetail(@RequestParam("query") String query) {
        return handleResponse(reviewService.searchReviews(query));
    }

    @GetMapping("/{type:place|coffee-shop|hotel|food}/all-pages")
    ResponseEntity<?> countRecords(@PathVariable(value = "type") String type) {
        return handleResponse(reviewService.getAllPage(type));
    }

}
