package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.constant.CommentReact;
import com.ligki.reviewdalat.model.entity.ReviewComment;
import com.ligki.reviewdalat.model.responsetype.DetailReviewComment;
import com.ligki.reviewdalat.model.responsetype.DetailReviewCommentChild;
import com.ligki.reviewdalat.model.responsetype.NewestComment;
import com.ligki.reviewdalat.reposiroty.ReviewCommentRepository;
import com.ligki.reviewdalat.reposiroty.ReviewObjectRepository;
import com.ligki.reviewdalat.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl extends BaseService implements CommentService {
    private static final String TRUE_VALUE = "1";
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
                    String roType = reviewObjectRepository.findTypeById(comment.getReviewObjectId());
                    String lastTime = DateTimeUtil.diff2DateToDayAndHour(comment.getCreated(), DateTimeUtil.getCurrentTime());

                    nc.setReviewObjectName(roName);
                    nc.setReviewObjectType(roType);
                    nc.setLastTime(lastTime);
                    return nc;
                }).collect(Collectors.toList());
    }

    @Override
    public List<DetailReviewComment> getDetailComment(String id) {
        //TODO: validate id is parent
        List<DetailReviewComment> result = reviewCommentRepository.findByReviewObjectId(id)
                .stream()
                .map(reviewComment -> {
                    Optional<ReviewComment> reviewCommentOpt = reviewCommentRepository.findById(reviewComment.getId());
                    if (reviewCommentOpt.isEmpty()) {
                        LOGGER.info("Review Comment {} not found", id);
                        return null;
                    } else {
                        DetailReviewComment detail = dozerBeanMapper.map(reviewCommentOpt.get(), DetailReviewComment.class);
                        detail.setLastTime(DateTimeUtil.diff2DateToDayAndHour(reviewComment.getCreated(), DateTimeUtil.getCurrentTime()));

                        List<DetailReviewCommentChild> commentChildren = reviewCommentRepository.findByReviewCommentParent(reviewComment.getId())
                                .stream()
                                .map(r -> {
                                    DetailReviewCommentChild child = dozerBeanMapper.map(r, DetailReviewCommentChild.class);
                                    String lastTime = DateTimeUtil.diff2DateToDayAndHour(r.getCreated(), DateTimeUtil.getCurrentTime());
                                    child.setReact(convertReact(r));
                                    child.setLastTime(lastTime);
                                    return child;
                                })
                                .collect(Collectors.toList());

                        detail.setComments(commentChildren);
                        return detail;
                    }
                })
                .collect(Collectors.toList());

        return result;
    }

    private String convertReact(ReviewComment reviewComment) {
        if (ObjectUtils.isEmpty(reviewComment)) {
            return null;
        } else if (TRUE_VALUE.equals(reviewComment.getLike())) return CommentReact.LIKE;
        else if (TRUE_VALUE.equals(reviewComment.getDislike())) return CommentReact.DISLIKE;
        else if (TRUE_VALUE.equals(reviewComment.getReport())) return CommentReact.REPORT;
        else return null;
    }
}
