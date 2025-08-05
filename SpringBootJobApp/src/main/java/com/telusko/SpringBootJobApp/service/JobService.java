package com.telusko.SpringBootJobApp.service;

import com.telusko.SpringBootJobApp.model.JobPost;
import com.telusko.SpringBootJobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;
    public void addjob(JobPost job){
repo.addJob(job);
    }
    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }
}
