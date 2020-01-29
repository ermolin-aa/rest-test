package com.example.demo.contoller;

import com.example.demo.domain.Quiz;
import com.example.demo.service.QuizService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * QuizController.
 *
 * @author Alexey_Ermolin
 */
@Api
@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<List<Quiz>> getQuizzes(
            @RequestParam(defaultValue = "0", name = "Номер страницы") Integer pageNum,
            @RequestParam(defaultValue = "5", name = "Количество тестов на странице") Integer pageSize,
            @RequestParam(defaultValue = "title", name = "Сортировка по:") String sortBy,
            @RequestParam(defaultValue = "", required = false, name = "Название теста") String title,
            @RequestParam(defaultValue = "true", name = "Тест активен?") Boolean active,
            @RequestParam(defaultValue = "1990-01-01", required = false, name = "Дата начала теста")
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
            @RequestParam(defaultValue = "2100-01-01", required = false, name = "Дата окончания теста")
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {


        List<Quiz> quizzes = quizService.findByParams(pageNum, pageSize, sortBy,
                title, active, beginDate, endDate);

        return new ResponseEntity<>(quizzes, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz savedQuiz = quizService.saveQuiz(quiz);
        return new ResponseEntity<>(savedQuiz, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> editQuiz(@RequestBody Quiz quiz, @PathVariable Long id) {
        return new ResponseEntity<>(quizService.editQuiz(quiz, id), new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(id, new HttpHeaders(), HttpStatus.OK);
    }
}
