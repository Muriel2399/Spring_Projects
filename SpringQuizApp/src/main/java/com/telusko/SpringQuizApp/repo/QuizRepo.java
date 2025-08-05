package com.telusko.SpringQuizApp.repo;

import com.telusko.SpringQuizApp.model.Question;
import com.telusko.SpringQuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
