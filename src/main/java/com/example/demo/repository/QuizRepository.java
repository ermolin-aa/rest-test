package com.example.demo.repository;

import com.example.demo.domain.Quiz;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * QuizRepository.
 *
 * @author Alexey_Ermolin
 */
@Repository
public interface QuizRepository extends PagingAndSortingRepository<Quiz, Long> {

    //В реальном проекте я использовал бы, скорее всего, @Query или Criteria API,
    //но захотелось попробовать в действии магию Spring Data Query Methods
    List<Quiz> findByTitleContainingAndActiveAndBeginDateGreaterThanEqualAndEndDateIsLessThanEqual(
            String title, Boolean active, LocalDate beginDate, LocalDate endDate, Pageable pageable);
}
