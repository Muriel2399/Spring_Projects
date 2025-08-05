package com.telusko.SpringQuizApp.controller;

import com.telusko.SpringQuizApp.model.QuestionWrapper;
import com.telusko.SpringQuizApp.model.Response;
import com.telusko.SpringQuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        //return new ResponseEntity<>("quiz created", HttpStatus.CREATED);
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity <List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
       return quizService.getQuizQuestions(id);
    }



    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
