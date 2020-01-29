package com.example.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Question entity class.
 *
 * @author Alexey_Ermolin
 */
@Data
@Entity
public class Question {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private Integer priority;
}
