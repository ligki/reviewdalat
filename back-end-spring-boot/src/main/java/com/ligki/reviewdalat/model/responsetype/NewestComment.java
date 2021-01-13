package com.ligki.reviewdalat.model.responsetype;

import lombok.Data;

@Data
public class NewestComment {
    String author;
    String reviewObjectId;
    String reviewObjectName;
    String reviewObjectType;
    String lastTime;
    String point;
    String context;
}