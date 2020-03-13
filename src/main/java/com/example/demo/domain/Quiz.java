package com.example.demo.domain;

import static javax.persistence.CascadeType.ALL;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Quiz entity class.
 *
 * @author Alexey_Ermolin
 */
@Data
@Entity
@Accessors(chain = true)
public class Quiz {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true) //чтобы в Swagger при создании entity не требовался id
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private LocalDate beginDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private Boolean active;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "quiz_id", nullable = false)
    @OrderBy("priority")
    private List<Question> questions = new ArrayList<>();
}
