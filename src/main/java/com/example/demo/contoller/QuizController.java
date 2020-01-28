package com.example.demo.contoller;

import com.example.demo.domain.Quiz;
import com.example.demo.service.QuizService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(defaultValue = "id") String sortBy) {

        List<Quiz> quizzes = quizService.findAll(pageNum, pageSize, sortBy);

        return new ResponseEntity<>(quizzes, new HttpHeaders(), HttpStatus.OK);
    }
}
