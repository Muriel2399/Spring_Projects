package com.telusko.SpringQuizApp.controller;

import com.telusko.SpringQuizApp.model.Question;
import com.telusko.SpringQuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{topic}")
    public List<Question> getQuestionsByCategory(@PathVariable String topic){
        return questionService.getQuestionsByCategory(topic);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
        //return "Question added successfully";
    }
}
