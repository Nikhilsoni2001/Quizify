package com.nikhil.quizify.service;

import com.nikhil.quizify.model.exam.Question;
import com.nikhil.quizify.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestion(Long questionId);

    Set<Question> getQuestionsOfQuiz(Quiz quiz);

    void deleteQuestion(Long QuestionId);
}
