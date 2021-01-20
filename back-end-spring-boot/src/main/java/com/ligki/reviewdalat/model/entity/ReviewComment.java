package com.ligki.reviewdalat.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ligki.reviewdalat.constant.DateTime;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@Where(clause = "active = 1")
public class ReviewComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    String id;

    String author;
    String reviewObjectId;
    String point;
    String reviewCommentParent;
    String comment;
    String context;
    String like;
    String dislike;
    String report;
    @JsonFormat(pattern = DateTime.FORMAT_GENERAL)
    String lastUpdate;
    @JsonFormat(pattern = DateTime.FORMAT_GENERAL)
    String created;
    String active;

    public String getId() {
        return StringUtils.leftPad(this.id, 8, "0");
    }

    public String getReviewObjectId() {
        return StringUtils.leftPad(this.reviewObjectId, 8, "0");
    }
}
