package com.telusko.SpringQuizApp.service;

import com.telusko.SpringQuizApp.model.Question;
import com.telusko.SpringQuizApp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo repo;
    public List<Question> getAllQuestions() {
        return repo.findAll();
    }

    public List<Question> getQuestionsByCategory(String topic) {
        return repo.findByCategory(topic);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        repo.save(question);
        try{
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }


    }
}
