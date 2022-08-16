package com.nikhil.quizify.repository;

import com.nikhil.quizify.model.exam.Question;
import com.nikhil.quizify.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
