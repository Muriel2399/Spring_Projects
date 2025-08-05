package com.telusko.SpringJDBCEx.service;

import com.telusko.SpringJDBCEx.model.Student;
import com.telusko.SpringJDBCEx.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentRepository getRepo() {
        return repo;
    }
@Autowired
    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    private StudentRepository repo;
    public void addStudent(Student s){
        System.out.println("Service layer: addStudent()");
        repo.save(s);

    }

    public List<Student> getStudents() {
        System.out.println("Service layer: getStudents()");
        return repo.findAll();
    }
}
