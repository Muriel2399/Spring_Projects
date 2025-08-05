package com.telusko.SpringQuestionApp.controller;

import com.telusko.SpringQuestionApp.model.Question;
import com.telusko.SpringQuestionApp.model.QuestionWrapper;
import com.telusko.SpringQuestionApp.model.Response;
import com.telusko.SpringQuestionApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //generate
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestion(@RequestParam String category, @RequestParam Integer numQ){
        return questionService.getQuestionForQuiz(category,numQ);
    }
    //get{questionid}

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionFromId(questionIds);
    }

    @PostMapping("getscore")
    public ResponseEntity<Integer> getscore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}
