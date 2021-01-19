package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    List<ReviewComment> findByReviewCommentParentOrderByCreatedDesc(String reviewCommentParent);

    List<ReviewComment> findByReviewObjectIdOrderByCreatedDesc(String reviewObjectId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO review_comment(author, review_object_id, point, context, created) VALUES (:author, :reviewObjectId, :point, :context, CURRENT_TIME())", nativeQuery = true)
    int insertComment(@Param("author") String author, @Param("reviewObjectId") String reviewObjectId, @Param("point") String point, @Param("context") String context);
}
