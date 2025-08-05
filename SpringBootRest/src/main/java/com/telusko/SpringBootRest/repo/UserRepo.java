package com.telusko.SpringBootRest.repo;

import com.telusko.SpringBootRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}


