package com.example.demo.service;

import com.example.demo.domain.Quiz;
import com.example.demo.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

/**
 * QuizService.
 *
 * @author Alexey_Ermolin
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public List<Quiz> findByParams(Integer pageNum, Integer pageSize, String sortBy,
                                 String title, Boolean active, LocalDate beginDate, LocalDate endDate) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        return quizRepository.findByTitleContainingAndActiveAndBeginDateGreaterThanEqualAndEndDateIsLessThanEqual(
                title, active, beginDate, endDate, pageable);
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz findById(Long id) {
        return quizRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Quiz editQuiz(Quiz quiz, Long id) {
        Quiz editedQuiz = findById(id);
        editedQuiz.setActive(quiz.getActive())
                .setTitle(quiz.getTitle())
                .setBeginDate(quiz.getBeginDate())
                .setEndDate(quiz.getEndDate())
                .setQuestions(quiz.getQuestions());
        return quizRepository.save(editedQuiz);
    }

    public void deleteQuiz(Long id) {
        Quiz quizForDeletion = findById(id);
        quizRepository.delete(quizForDeletion);
    }

}
