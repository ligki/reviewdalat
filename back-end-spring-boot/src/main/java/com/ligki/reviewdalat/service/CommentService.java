package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import com.ligki.reviewdalat.model.httpentity.ErrorResponse;
import com.ligki.reviewdalat.model.responsetype.DetailReviewComment;
import com.ligki.reviewdalat.model.responsetype.NewestComment;

import java.util.List;

public interface CommentService {
    List<NewestComment> getNewestComments();

    List<DetailReviewComment> getDetailComment(String reviewObjectId);

    ErrorResponse addComment(ReviewComment review);
}
