package com.lochanit.service;

import com.lochanit.Entity.Job;

import java.util.List;

public interface JobService {
      Job getJobById(Long id) ;
    List<Job>findAll();
    void createJob(Job job);
    boolean deleteJobById(Long id);
    boolean updateJob(Long id, Job updateJob);
}
