package com.example.demo.repository;

import com.example.demo.domain.Quiz;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * QuizRepository.
 *
 * @author Alexey_Ermolin
 */
@Repository
public interface QuizRepository extends PagingAndSortingRepository<Quiz, Long> {

}
