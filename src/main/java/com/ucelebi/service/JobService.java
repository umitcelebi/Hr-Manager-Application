package com.ucelebi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucelebi.model.Job;
import com.ucelebi.repo.JobRepository;

@Service
@Transactional
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public Job getOneJob(int id) {
		return jobRepository.getOne(id);
		
	}
	
	public Job createJob(Job job) {
		return jobRepository.save(job);
		
	}
	
	public List<Job> allJob(){
		return jobRepository.findAll();
	}
	
	public void updateJob(Job job2,int id) {
		Job job=jobRepository.getOne(id);
		
		job.setJobDescription(job2.getJobDescription());
		job.setJobTitle(job2.getJobTitle());
		job.setLastApplication(job2.getLastApplication());
		job.setNumberOfPeople(job2.getNumberOfPeople());
		
		jobRepository.save(job);
	}
	
	public void deleteJob(int id) {
		jobRepository.deleteById(id);
	}
}
