package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewCommentRepository extends CrudRepository<ReviewComment, String> {
    /**
     * Find top 10 Review Comment that
     * reviewObjectId not null and reviewCommentParent null: the parent review
     * order by created desc: newest review
     *
     * @return
     */
    List<ReviewComment> findTop10ByReviewObjectIdNotNullAndReviewCommentParentNullOrderByCreatedDesc();
}
