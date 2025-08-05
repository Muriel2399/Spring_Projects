package com.telusko.SpringJDBCEx.repo;

import com.telusko.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbc;
    public void save(Student s){
        System.out.println("Repo layer: save()");
        String sql="insert into Student(rollno, name , marks) values(?,?,?)";
        int rows =jdbc.update(sql,s.getRollno(), s.getName(), s.getMarks());
        System.out.println(rows+ " affected");
    }

    public List<Student> findAll() {
        System.out.println("Repo layer: findAll()");
        String sql="select * from student";
        //without using Lambda expression
//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s = new Student();
//                s.setRollno(rs.getInt("rollno"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//                return s;
//            }
//        };

        //with using Lambda expression
        RowMapper<Student> mapper = ( rs,  rowNum) ->{
                Student s = new Student();
                s.setRollno(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;

        };
        return jdbc.query(sql,mapper);

    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
