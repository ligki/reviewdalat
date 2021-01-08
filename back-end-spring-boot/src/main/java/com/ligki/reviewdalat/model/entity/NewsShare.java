package com.ligki.reviewdalat.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ligki.reviewdalat.constant.DateTime;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Where(clause = "active = 1")
public class NewsShare {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private String  id;

    private String  title;
    private String  titleImage;
    private String  htmlContent;
    private String  source;
    @JsonFormat(pattern = DateTime.FORMAT_GENERAL)
    private String  created;
    @JsonIgnore
    private String  active;

}
