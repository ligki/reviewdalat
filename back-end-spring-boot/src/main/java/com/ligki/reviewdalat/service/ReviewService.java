package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.responsetype.NewestReviewObject;

import java.util.List;

public interface ReviewService {
    /**
     * Get 10 newest review object by type
     * Refer type by ReviewType
     *
     * @param type
     * @return
     */
    List<NewestReviewObject> getNewestReviewObject(String type);
}
