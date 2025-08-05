package com.telusko.SpringBootRest.service;
import com.telusko.SpringBootRest.model.User;
import com.telusko.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepo repo;
    public User saveUser(User user){
        return repo.save(user);
    }
}
