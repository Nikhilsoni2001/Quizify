package com.nikhil.quizify.controller;

import com.nikhil.quizify.model.exam.Question;
import com.nikhil.quizify.model.exam.Quiz;
import com.nikhil.quizify.service.QuestionService;
import com.nikhil.quizify.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    // add Question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    // update the question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    // get by Question
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid) {
        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List<Question> list = new ArrayList<>(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }
}
