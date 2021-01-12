package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewCommentRepository extends CrudRepository<ReviewComment, String> {
    List<ReviewComment> findTop10ByOrderByCreatedDesc();
}
