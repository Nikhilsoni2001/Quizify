package com.nikhil.quizify.controller;

import com.nikhil.quizify.model.exam.Quiz;
import com.nikhil.quizify.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // add Quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    // update Quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    // get Quizzes
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    // get Quiz
    @GetMapping("/{qid}")
    public Quiz getQuiz(@PathVariable("qid") Long qid) {
        return this.quizService.getQuiz(qid);
    }

    // delete Quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid) {
        this.quizService.deleteQuiz(qid);
    }
}
