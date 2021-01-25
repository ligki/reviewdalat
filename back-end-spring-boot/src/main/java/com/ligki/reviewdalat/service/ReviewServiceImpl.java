package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.constant.ReviewObjectType;
import com.ligki.reviewdalat.model.entity.ReviewObject;
import com.ligki.reviewdalat.model.responsetype.AllPages;
import com.ligki.reviewdalat.model.responsetype.DetailReviewObject;
import com.ligki.reviewdalat.model.responsetype.NewestReviewObject;
import com.ligki.reviewdalat.model.responsetype.SearchReview;
import com.ligki.reviewdalat.reposiroty.ReviewObjectRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl extends BaseService implements ReviewService {

    @Autowired
    ReviewObjectRepository reviewObjectRepository;

    @Override
    public List<NewestReviewObject> getNewestReviewObject(String type, String page) {
        /*
         * To common response for APIs
         * Phis service using Pageable so page should from 0
         * Page from request is from 1 so need to subtract 1 from request
         */
        String typeDb = mapTypeFromRequestToDatabase(type);
        int pageInt = mapPageToPageable(page);
        PageRequest pageRequest = PageRequest.of(pageInt, LIMIT_PAGE, Sort.by("lastUpdate").descending());

        return reviewObjectRepository.findAllByType(typeDb, pageRequest)
                .stream()
                .map(review -> {
                    String allRates = calculateAllRates(review);
                    String averageRating = calculateAverageRating(review);

                    NewestReviewObject r = dozerBeanMapper.map(review, NewestReviewObject.class);
                    r.setAllRates(allRates);
                    r.setAverageRating(averageRating);
                    return r;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<NewestReviewObject> getBestReviewObject(String type, String page) {
        int typeDb = Integer.parseInt(mapTypeFromRequestToDatabase(type));
        int offset = mapPageToOffset(page);
        return reviewObjectRepository.findBestReviewObjectByType(typeDb, offset)
                .stream()
                .map(review -> {
                    String allRates = calculateAllRates(review);
                    String averageRating = calculateAverageRating(review);

                    NewestReviewObject r = dozerBeanMapper.map(review, NewestReviewObject.class);
                    r.setAllRates(allRates);
                    r.setAverageRating(averageRating);
                    return r;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<NewestReviewObject> getWorstReviewObject(String type, String page) {
        int typeDb = Integer.parseInt(mapTypeFromRequestToDatabase(type));
        int offset = mapPageToOffset(page);
        return reviewObjectRepository.findWorstReviewObjectByType(typeDb, offset)
                .stream()
                .map(review -> {
                    String allRates = calculateAllRates(review);
                    String averageRating = calculateAverageRating(review);

                    NewestReviewObject r = dozerBeanMapper.map(review, NewestReviewObject.class);
                    r.setAllRates(allRates);
                    r.setAverageRating(averageRating);
                    return r;
                })
                .collect(Collectors.toList());
    }

    @Override
    public DetailReviewObject getDetail(String id) {
        Optional<ReviewObject> ro = reviewObjectRepository.findById(id);
        if (ro.isEmpty()) {
            LOGGER.info("Cannot find reviewObject {}", id);
            return null;
        }
        DetailReviewObject result = dozerBeanMapper.map(ro.get(), DetailReviewObject.class);
        String allRates = calculateAllRates(ro.get());
        String averageRating = calculateAverageRating(ro.get());
        result.setAllRates(allRates);
        result.setAverageRating(averageRating);
        return result;
    }

    @Override
    public List<SearchReview> searchReviews(String query) {
        if (ObjectUtils.isEmpty(query)) {
            return Collections.emptyList();
        }
        List<ReviewObject> reviewObjects = reviewObjectRepository.findTop10ByNameContainingIgnoreCase(query);
        return reviewObjects.stream().map(reviewObject -> dozerBeanMapper.map(reviewObject, SearchReview.class)).collect(Collectors.toList());
    }

    @Override
    public AllPages getAllPage(String type) {
        String typeDb = mapTypeFromRequestToDatabase(type);
        int allPages = reviewObjectRepository.countByType(typeDb) / LIMIT_PAGE + 1;
        return new AllPages(allPages);
    }

    private String calculateAverageRating(ReviewObject review) {
        int allRates = Integer.parseInt(review.getRating1()) + Integer.parseInt(review.getRating2()) + Integer.parseInt(review.getRating3()) + Integer.parseInt(review.getRating4()) + Integer.parseInt(review.getRating5());
        float avr = (Float.parseFloat(review.getRating1())
                + Float.parseFloat(review.getRating2()) * 2
                + Float.parseFloat(review.getRating3()) * 3
                + Float.parseFloat(review.getRating4()) * 4
                + Float.parseFloat(review.getRating5()) * 5) / allRates;
        return String.valueOf(Math.round(avr * 2) / 2.0);
    }


    private String calculateAllRates(ReviewObject review) {
        int allRates = Integer.parseInt(review.getRating1()) + Integer.parseInt(review.getRating2()) + Integer.parseInt(review.getRating3()) + Integer.parseInt(review.getRating4()) + Integer.parseInt(review.getRating5());
        return String.valueOf(allRates);
    }

    private String mapTypeFromRequestToDatabase(String type) {
        if (ReviewObjectType.PLACE.getKey().equals(type)) {
            return ReviewObjectType.PLACE.getValue();
        }
        if (ReviewObjectType.COFFEE_SHOP.getKey().equals(type)) {
            return ReviewObjectType.COFFEE_SHOP.getValue();
        }
        if (ReviewObjectType.HOTEL.getKey().equals(type)) {
            return ReviewObjectType.HOTEL.getValue();
        }
        if (ReviewObjectType.FOOD.getKey().equals(type)) {
            return ReviewObjectType.FOOD.getValue();
        }
        return "0";
    }

    private int mapPageToPageable(String page) {
        if (ObjectUtils.isEmpty(page) || !StringUtils.isNumeric(page)) {
            return 0;
        } else {
            int pageInt = Integer.parseInt(page);
            if (pageInt < 1) return 0;
            else return pageInt - 1;
        }
    }

    private int mapPageToOffset(String page) {
        if (ObjectUtils.isEmpty(page) || !StringUtils.isNumeric(page)) {
            return 0;
        } else {
            int pageInt = Integer.parseInt(page);
            if (pageInt < 1) return 0;
            else return (pageInt - 1) * LIMIT_PAGE;
        }
    }
}
