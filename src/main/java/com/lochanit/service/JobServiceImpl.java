package com.lochanit.service;

import com.lochanit.Entity.Job;
import com.lochanit.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    /* private List<Job> jobs=new ArrayList<>();
     private Long nextId=1L;

     @Override
     public Job getJobById(Long id) {
         for(Job job:jobs){
             if(job.getId().equals(id)){
                 return job;
             }
         }
         return null;
     }
     @Override
     public List<Job> findAll() {
         return jobs;
     }
     @Override
     public void createJob(Job job) {
         job.setId(nextId++);
        jobs.add(job);
     }
     @Override
     public boolean deleteJobById(Long id) {
         Iterator<Job> iterator=jobs.iterator();
         while (iterator.hasNext()){
             Job job=iterator.next();
             if(job.getId().equals(id)){
                 iterator.remove();
                 return true;
             }
         }
         return false;
     }

     @Override
     public boolean updateJob(Long id, Job updateJob) {
         for(Job job:jobs){
             if(job.getId().equals(id)){
                 job.setTitle(updateJob.getTitle());
                 job.setDescription(updateJob.getDescription());
                 job.setLocation(updateJob.getLocation());
                 job.setMinSalary(updateJob.getMinSalary());
                 job.setMaxSalary(updateJob.getMaxSalary());
                 return true;
             }
         }
         return false;
     }
 */
    @Autowired
    private JobRepo jobRepo;


    @Override
    public Job getJobById(Long id) {
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepo.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setLocation(updateJob.getLocation());
            job.setMinSalary(updateJob.getMinSalary());
            job.setMaxSalary(updateJob.getMaxSalary());
            jobRepo.save(job);
            return true;
        }
        return false;

    }
}



