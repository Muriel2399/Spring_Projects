package com.telusko.SpringQuestionApp.service;

import com.telusko.SpringQuestionApp.model.Question;
import com.telusko.SpringQuestionApp.model.QuestionWrapper;
import com.telusko.SpringQuestionApp.model.Response;
import com.telusko.SpringQuestionApp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, Integer numQ) {
        List<Integer> questions = repo.findRandomQuestionsByCategory(category, numQ);
   return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {
  List<QuestionWrapper> wrappers = new ArrayList<>();
  List<Question> questions = new ArrayList<>();

  for(Integer id : questionIds){

      questions.add(repo.findById(id).get());

  }
  for(Question q: questions){
      QuestionWrapper wrapper = new QuestionWrapper();
      wrapper.setId(q.getId());
      wrapper.setQuestionTitle(q.getQuestionTitle());
      wrapper.setOption1(q.getOption1());
      wrapper.setOption2(q.getOption2());
      wrapper.setOption3(q.getOption3());
      wrapper.setOption4(q.getOption4());
      wrappers.add(wrapper);
   }
    return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
return null;
    }
}
