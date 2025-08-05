package com.telusko.SpringBootRest;

import com.telusko.SpringBootRest.model.JobPost;
import com.telusko.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;
    @GetMapping("jobPosts")
    //@ResponseBody
      public List<JobPost> getAllJobs(){
         return service.getAllJobs();
         }

    @GetMapping("jobPost/{i}")
    public JobPost getJob(@PathVariable int i){
        return service.getJob(i);
    }

    @PostMapping("/jobPost")
    public void addJob(@RequestBody JobPost job){
 service.addjob(job);
 //return job;
    }


    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost job){
         service.updateJob(job);
        return job;
    }

    @DeleteMapping("jobPost/{i}")
    public String deleteJob(@PathVariable int i){
         service.deleteJob(i);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }
    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword){
        return service.search(keyword);
    }
}
