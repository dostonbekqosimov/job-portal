package com.doston.JobApp.controller;

import com.doston.JobApp.model.JobPost;
import com.doston.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

//    public JobController(JobService jobService) {
//        this.jobService = jobService;
//    }

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();

    }

    @GetMapping("jobPost/{id}")
    public Optional<JobPost> getJobById(@PathVariable Integer id) {
        return jobService.getJobById(id);

    }

    @PostMapping("/jobPost")
    public ResponseEntity<String> createJob(@RequestBody JobPost job) {
        // Add logic to handle the creation of a job
        jobService.addJob(job);
        return ResponseEntity.ok("Job created successfully");
    }

    @PutMapping("/jobPost")
    public ResponseEntity<String> updateJob(
            @RequestBody JobPost job) {
        jobService.updateById(job);
        return ResponseEntity.ok("Job updated successfully");
    }

    @DeleteMapping("/jobPost/{id}")
    public String deleteJobById(@PathVariable Integer id) {
        // Add logic to handle the creation of a job
        jobService.deleteJobById(id);
        return "Deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.searchByKey(keyword);
    }



    @GetMapping("load")
    public String load(){
        jobService.load();
        return "Success";
    }
}
