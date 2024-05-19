package com.doston.JobApp.service;

import com.doston.JobApp.model.JobPost;
import com.doston.JobApp.repository.JobRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private JobRepo jobRepo;

    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public void addJob(JobPost jobPost) {

        jobRepo.save(jobPost);


    }

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    public Optional<JobPost> getJobById(Integer id) {
        return jobRepo.findById(id);
    }

    public void updateById(JobPost job) {
        jobRepo.save(job);
    }

    public void deleteJobById(Integer id) {

        jobRepo.deleteById(id);
    }

    public List<JobPost> searchByKey(String keyword1) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword1, keyword1);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Software Engineer", "Looking for a Java developer", 3, List.of("Java", "Spring")),
            new JobPost(2, "Data Analyst", "Seeking experienced data analyst", 5, List.of("SQL", "Python", "Data Visualization")),
            new JobPost(3, "UI/UX Designer", "UX/UI designer needed for web development", 2, List.of("Adobe XD", "Sketch", "Figma")),
            new JobPost(4, "Network Engineer", "Experienced network engineer required", 4, List.of("Cisco", "Routing", "Switching")),
            new JobPost(5, "DevOps Engineer", "Seeking DevOps engineer with cloud experience", 3, List.of("Docker", "Kubernetes", "AWS"))));

        jobRepo.saveAll(jobs);
    }
}
