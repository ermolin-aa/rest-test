package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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

    private LocalDate beginDate;

    private LocalDate endDate;

    private Boolean active;

    @OneToMany
    @JoinColumn(name="quiz_id")
    @OrderBy("order")
    private List<Question> questions;
}
