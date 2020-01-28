package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Quiz entity class.
 *
 * @author Alexey_Ermolin
 */
@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    private Date beginDate;

    private Date endDate;

    private Boolean active;

    @OneToMany
    @JoinColumn(name="quiz_id")
    @OrderBy("order")
    private List<Question> questions;
}
