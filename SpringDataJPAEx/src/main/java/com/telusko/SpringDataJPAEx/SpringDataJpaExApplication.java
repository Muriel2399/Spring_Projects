package com.telusko.SpringDataJPAEx;

import com.telusko.SpringDataJPAEx.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringDataJpaExApplication.class, args);
StudentRepo repo= context.getBean(StudentRepo.class);
		Student s1= context.getBean(Student.class);
		Student s2= context.getBean(Student.class);
		Student s3= context.getBean(Student.class);
//
//		s1.setRollno(101);
//		s1.setName("Navin");
//		s1.setMarks(99);
//
		s2.setRollno(102);
		s2.setName("Kiran");
		s2.setMarks(65);
//
//		s3.setRollno(103);
//		s3.setName("Harsh");
//		s3.setMarks(83);
//
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);
		//System.out.println(repo.findAll());

		//System.out.println(repo.findById(103));
		//Optional<Student> s=repo.findById(104) ;
		//System.out.println(s.orElse(new Student()));

		//System.out.println(repo.findByName("Navin"));
		//System.out.println(repo.findByMarks(86));
		//System.out.println(repo.findByMarksGreaterThan(85));

		repo.delete(s2);
	}

}
