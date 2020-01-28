package com.example.demo.service;

import com.example.demo.domain.Quiz;
import com.example.demo.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

}
