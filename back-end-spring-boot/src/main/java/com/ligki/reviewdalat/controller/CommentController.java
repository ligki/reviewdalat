package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import com.ligki.reviewdalat.model.requesttype.ReviewCommentAdd;
import com.ligki.reviewdalat.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController extends BaseController {

    @Autowired
    CommentService commentService;

    @GetMapping("/newest")
    ResponseEntity<?> getNewestComments() {
        return handleResponse(commentService.getNewestComments());
    }

    @GetMapping("/detail/{reviewObjectId}")
    ResponseEntity<?> getDetailComment(@PathVariable(value = "reviewObjectId", required = true) String reviewObjectId) {
        return handleResponse(commentService.getDetailComment(reviewObjectId));
    }

    @PostMapping("/{reviewObjectId}")
    ResponseEntity<?> addComment(@PathVariable(value = "reviewObjectId", required = true) String reviewObjectId,
                                 @RequestBody ReviewCommentAdd review) {
        ReviewComment rv = dozerBeanMapper.map(review, ReviewComment.class);
        rv.setReviewObjectId(reviewObjectId);
        return handleResponse(commentService.addComment(rv));
    }
}
