package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController extends BaseController {

    @Autowired
    CommentService commentService;

    @GetMapping("/newest")
    ResponseEntity<?> getNewestComments() {
        return handleResponse(commentService.getNewestComments());
    }
}
