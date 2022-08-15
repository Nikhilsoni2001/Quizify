package com.nikhil.quizify.repository;

import com.nikhil.quizify.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
