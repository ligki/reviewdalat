package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.entity.ReviewComment;

import java.util.List;

public interface CommentService {
    List<ReviewComment> getNewestComments();
}
