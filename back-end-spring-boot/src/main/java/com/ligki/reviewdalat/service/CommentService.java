package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.responsetype.NewestComment;

import java.util.List;

public interface CommentService {
    List<NewestComment> getNewestComments();
}
