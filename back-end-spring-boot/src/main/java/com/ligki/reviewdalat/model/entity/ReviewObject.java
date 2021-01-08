package com.ligki.reviewdalat.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ligki.reviewdalat.constant.DateTime;
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
public class ReviewObject {

    @Id
    @GeneratedValue
    @Column(nullable = false)
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
    String phone;
    String description;
    @JsonFormat(pattern = DateTime.FORMAT_GENERAL)
    String lastUpdate;
    @JsonFormat(pattern = DateTime.FORMAT_GENERAL)
    String created;
    String active;

    public String getId() {
        return StringUtils.leftPad(id, 8, "0");
    }
}
