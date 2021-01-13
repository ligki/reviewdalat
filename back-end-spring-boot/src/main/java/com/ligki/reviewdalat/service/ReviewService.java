package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.entity.ReviewComment;
import com.ligki.reviewdalat.model.responsetype.DetailReviewObject;
import com.ligki.reviewdalat.model.responsetype.NewestReviewObject;

import java.util.List;

public interface ReviewService {
    /**
     * Get 10 newest review object by type
     * Refer type by ReviewType
     *
     * @param type ReviewType
     * @return
     */
    List<NewestReviewObject> getNewestReviewObject(String type);

    /**
     * Get 10 best review object by type
     * Refer type by ReviewType
     *
     * @param type ReviewType
     * @return
     */
    List<NewestReviewObject> getBestReviewObject(String type);

    /**
     * Get 10 worst review object by type
     * Refer type by ReviewType
     *
     * @param type ReviewType
     * @return
     */
    List<NewestReviewObject> getWorstReviewObject(String type);

    DetailReviewObject getDetail(String id);

}
