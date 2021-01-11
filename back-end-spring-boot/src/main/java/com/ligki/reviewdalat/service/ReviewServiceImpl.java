package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.constant.ReviewObjectType;
import com.ligki.reviewdalat.model.entity.ReviewObject;
import com.ligki.reviewdalat.model.responsetype.NewestReviewObject;
import com.ligki.reviewdalat.reposiroty.ReviewObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl extends BaseService implements ReviewService {

    @Autowired
    ReviewObjectRepository reviewObjectRepository;

    @Override
    public List<NewestReviewObject> getNewestReviewObject(String type) {
        return reviewObjectRepository.findTop10ByTypeOrderByLastUpdateDesc(mapTypeFromRequestToDatabase(type))
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
    public List<NewestReviewObject> getBestReviewObject(String type) {
        return reviewObjectRepository.findBestReviewObjectByType(mapTypeFromRequestToDatabase(type))
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
    public List<NewestReviewObject> getWorstReviewObject(String type) {
        return reviewObjectRepository.findWorstReviewObjectByType(mapTypeFromRequestToDatabase(type))
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
        return "";
    }
}
