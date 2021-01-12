package com.ligki.reviewdalat.model.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Where(clause = "active = 1")
public class ReviewComment {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    String id;

    String author;
    String reviewObjectId;
    String point;
    String reviewCommentParent;
    String context;
    String like;
    String dislike;
    String report;
    String lastUpdate;
    String created;
    String active;

    public String getId() {
        return StringUtils.leftPad(id, 8, "0");
    }
}
