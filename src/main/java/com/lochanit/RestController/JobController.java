package com.lochanit.RestController;

import com.lochanit.Entity.Company;
import com.lochanit.Entity.Job;
import com.lochanit.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;
   @GetMapping
    public ResponseEntity<List<Job>> findAll(){
    return ResponseEntity.ok(jobService.findAll());
   }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
       jobService.createJob(job);
        Company c=job.getCompany();
       return new ResponseEntity<>("job added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
  public ResponseEntity<Job> getJobById(@PathVariable Long id){
       Job job =jobService.getJobById(id);
       if(job!=null){
           return new ResponseEntity<>(job,HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  @DeleteMapping("/{id}")
public ResponseEntity<String> deleteJob(@PathVariable Long id){
       boolean deleted=jobService.deleteJobById(id);
       if(deleted) {
           return new ResponseEntity<>("job deleted successful", HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
//@PutMapping("/jobs/{id}")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updateJob){
       boolean updated=jobService.updateJob(id,updateJob);
       if(updated){
           return new ResponseEntity<>("job updated successfully",HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}














}
