package com.doston.JobApp.repository;

import com.doston.JobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword1, String keyword2);
}

//    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(1, "Software Engineer", "Looking for a Java developer", 3, List.of("Java", "Spring")),
//            new JobPost(2, "Data Analyst", "Seeking experienced data analyst", 5, List.of("SQL", "Python", "Data Visualization")),
//            new JobPost(3, "UI/UX Designer", "UX/UI designer needed for web development", 2, List.of("Adobe XD", "Sketch", "Figma")),
//            new JobPost(4, "Network Engineer", "Experienced network engineer required", 4, List.of("Cisco", "Routing", "Switching")),
//            new JobPost(5, "DevOps Engineer", "Seeking DevOps engineer with cloud experience", 3, List.of("Docker", "Kubernetes", "AWS"))));
//
//    // ****************************************************************************
//
//    // constructor->injecting objects into ArrayList defined above.
//
//    public List<JobPost> returnAllJobPosts() {
//        return jobs;
//    }
//
//    // method to save a job post object into arrayList
//    public void addJobPost(JobPost job) {
//        jobs.add(job);
//
//    }
//
//
//    public JobPost getJobById(Integer id) {
//        for (JobPost job : jobs) {
//            if (job.getPostId() == id) {
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public ResponseEntity<String> updateJobById(Integer id, JobPost job) {
//
//        if (job.getPostId() == id) {
//            JobPost tempJob = job;
//            tempJob.setPostDesc(job.getPostProfile());
//            tempJob.setPostDesc(job.getPostDesc());
//            tempJob.setReqExperience(job.getReqExperience());
//            tempJob.setPostTechStack(job.getPostTechStack());
//
//
//        }
//        return ResponseEntity.ok("Couldn't update the job with the id:" + id);
//
//
//    }
//
//    public void deleteJobById(Integer id) {
//        for (JobPost job : jobs) {
//            if (job.getPostId() == id) {
//                jobs.remove(job);
//            }
//        }
//    }
//}