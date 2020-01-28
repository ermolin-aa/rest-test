package com.example.demo.service;

import com.example.demo.domain.Quiz;
import com.example.demo.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * QuizService.
 *
 * @author Alexey_Ermolin
 */
@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public List<Quiz> findAll(Integer pageNum, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));

        Page<Quiz> pagedResult = quizRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }


}
