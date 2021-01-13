package com.ligki.reviewdalat.model.responsetype;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class DetailReviewObject {
    String id;
    String name;
    String type;
    String imageIcon;
    String rating1;
    String rating2;
    String rating3;
    String rating4;
    String rating5;
    String location;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String phone;
    String description;

    String averageRating;
    String allRates;
}
