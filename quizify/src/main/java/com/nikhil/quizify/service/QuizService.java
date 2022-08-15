package com.nikhil.quizify.service;

import com.nikhil.quizify.model.exam.Quiz;

import java.util.Set;

public interface QuizService {
    Quiz addQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    Set<Quiz> getQuizzes();

    Quiz getQuiz(Long quizId);

    void deleteQuiz(Long quizId);
}
