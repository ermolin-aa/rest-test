package com.example.demo.contoller;

import com.example.demo.domain.Quiz;
import com.example.demo.service.QuizService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * QuizController.
 *
 * @author Alexey_Ermolin
 */
@RestController
@RequestMapping("/quizzes")
@Api
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping

    public ResponseEntity<List<Quiz>> getAllQuizzes(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "", required = false) String title,
            @RequestParam(defaultValue = "true") Boolean active,
            @RequestParam(defaultValue = "", required = false) String beginDate,
            @RequestParam(defaultValue = "", required = false) String endDate) {

        System.out.println("!!!");
        System.out.println(title.isEmpty());
        System.out.println(beginDate.isEmpty());
        System.out.println(endDate.isEmpty());


        List<Quiz> quizzes = quizService.findAll(pageNum, pageSize, sortBy);

        return new ResponseEntity<>(quizzes, new HttpHeaders(), HttpStatus.OK);
    }
}
