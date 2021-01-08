package com.ligki.reviewdalat.model.responsetype;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class NewestReviewObject {
    String id;
    String name;
    String type;
    String imageIcon;
    String averageRating;
    String allRates;
    String location;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String phone;
    String description;
}
