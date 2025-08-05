package com.telusko.SpringBootJobApp.controller;

import com.telusko.SpringBootJobApp.model.JobPost;
import com.telusko.SpringBootJobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.ui.Model;
@Controller
public class JobController {

    @Autowired
    private JobService service;
    @RequestMapping({"/","home"})
    public String home(){
        System.out.println("home");
        return "home";
    }

    @GetMapping("addjob")
    public String addjob(){
        System.out.println("addjob");
        return "addjob";
    }
    @GetMapping("viewalljobs")
    public String viewalljobs(Model m){
        System.out.println("viewalljobs");
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        System.out.println("handleForm");
        service.addjob(jobPost);
        return "success";
    }
}
