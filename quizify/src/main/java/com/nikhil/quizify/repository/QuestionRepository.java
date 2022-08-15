package com.nikhil.quizify.repository;

import com.nikhil.quizify.model.exam.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
