package com.ligki.reviewdalat.model.requesttype;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReviewCommentAdd {
    String author;
    String point;
    String context;
}
