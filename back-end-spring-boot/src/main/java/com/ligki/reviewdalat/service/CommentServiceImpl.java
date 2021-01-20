package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.constant.Comment;
import com.ligki.reviewdalat.constant.ErrorCode;
import com.ligki.reviewdalat.exception.ApiException;
import com.ligki.reviewdalat.model.entity.ReviewComment;
import com.ligki.reviewdalat.model.httpentity.SuccessResponse;
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

    List<String> ACCEPTED_TYPES = List.of("comment", "like", "dislike", "report");

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
        List<DetailReviewComment> result = reviewCommentRepository.findByReviewObjectIdOrderByCreatedDesc(id)
                .stream()
                .map(reviewComment -> {
                    Optional<ReviewComment> reviewCommentOpt = reviewCommentRepository.findById(reviewComment.getId());
                    if (reviewCommentOpt.isEmpty()) {
                        LOGGER.info("Review Comment {} not found", id);
                        return null;
                    } else {
                        DetailReviewComment detail = dozerBeanMapper.map(reviewCommentOpt.get(), DetailReviewComment.class);
                        detail.setLastTime(DateTimeUtil.diff2DateToDayAndHour(reviewComment.getCreated(), DateTimeUtil.getCurrentTime()));

                        List<DetailReviewCommentChild> commentChildren = reviewCommentRepository.findByReviewCommentParentOrderByCreatedDesc(reviewComment.getId())
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

    @Override
    public SuccessResponse addComment(ReviewComment review) {
        try {
            int rows = reviewCommentRepository.insertComment(review.getAuthor(), review.getReviewObjectId(), review.getPoint(), review.getContext());
            return new SuccessResponse("Add comment success");
        } catch (Exception e) {
            LOGGER.info("Insert new review comment fail: {}", e.getMessage());
            throw new ApiException(ErrorCode.E0001, ErrorCode.E0001_MESSAGE);
        }
    }

    @Override
    public SuccessResponse addCommentReact(ReviewComment review, String type) {
        if (!ACCEPTED_TYPES.contains(type)) {
            LOGGER.info("Add comment react fail because type is not correct");
            throw new ApiException(ErrorCode.E0002, ErrorCode.E0002_MESSAGE);
        }
        try {
            if (Comment.REACT_COMMENT.equals(type)) {
                int rows = reviewCommentRepository.insertCommentReactComment(review.getAuthor(), review.getReviewCommentParent(), review.getContext());
            }
            if (Comment.REACT_LIKE.equals(type)) {
                int rows = reviewCommentRepository.insertCommentReactLike(review.getAuthor(), review.getReviewCommentParent(), review.getContext());
            }
            if (Comment.REACT_DISLIKE.equals(type)) {
                int rows = reviewCommentRepository.insertCommentReactDislike(review.getAuthor(), review.getReviewCommentParent(), review.getContext());
            }
            if (Comment.REACT_REPORT.equals(type)) {
                int rows = reviewCommentRepository.insertCommentReactReport(review.getAuthor(), review.getReviewCommentParent(), review.getContext());
            }
            return new SuccessResponse("React comment success");
        } catch (Exception e) {
            LOGGER.info("Insert new comment react fail: {}", e.getMessage());
            throw new ApiException(ErrorCode.E0001, ErrorCode.E0001_MESSAGE);
        }
    }

    private String convertReact(ReviewComment reviewComment) {
        if (ObjectUtils.isEmpty(reviewComment)) {
            return null;
        } else if (TRUE_VALUE.equals(reviewComment.getComment())) return Comment.REACT_COMMENT;
        else if (TRUE_VALUE.equals(reviewComment.getLike())) return Comment.REACT_LIKE;
        else if (TRUE_VALUE.equals(reviewComment.getDislike())) return Comment.REACT_DISLIKE;
        else if (TRUE_VALUE.equals(reviewComment.getReport())) return Comment.REACT_REPORT;
        else return null;
    }
}
