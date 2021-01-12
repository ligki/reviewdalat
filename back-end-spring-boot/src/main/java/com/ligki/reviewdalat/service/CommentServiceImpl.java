package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import com.ligki.reviewdalat.model.responsetype.NewestComment;
import com.ligki.reviewdalat.reposiroty.ReviewCommentRepository;
import com.ligki.reviewdalat.reposiroty.ReviewObjectRepository;
import com.ligki.reviewdalat.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl extends BaseService implements CommentService {
    @Autowired
    ReviewCommentRepository reviewCommentRepository;

    @Autowired
    ReviewObjectRepository reviewObjectRepository;

    @Override
    public List<NewestComment> getNewestComments() {
        return reviewCommentRepository.findTop10ByReviewObjectIdNotNullAndReviewCommentParentNullOrderByCreatedDesc()
                .stream()
                .map(comment -> {
                    NewestComment nc = dozerBeanMapper.map(comment, NewestComment.class);
                    String roName = reviewObjectRepository.findNameById(comment.getReviewObjectId());
                    String lastTime = DateTimeUtil.diff2DateToDayAndHour(comment.getCreated(), DateTimeUtil.getCurrentTime());


                    nc.setReviewObjectName(roName);
                    nc.setLastTime(lastTime);
                    return nc;
                }).collect(Collectors.toList());
    }
}
