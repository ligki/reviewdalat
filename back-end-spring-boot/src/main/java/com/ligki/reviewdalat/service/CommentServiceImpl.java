package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import com.ligki.reviewdalat.reposiroty.ReviewCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends BaseService implements CommentService {
    @Autowired
    ReviewCommentRepository reviewCommentRepository;

    @Override
    public List<ReviewComment> getNewestComments() {
        return reviewCommentRepository.findTop10ByOrderByCreatedDesc();
    }
}
