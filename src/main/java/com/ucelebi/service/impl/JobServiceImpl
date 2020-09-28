package com.ucelebi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucelebi.model.Job;
import com.ucelebi.repo.JobRepository;
import com.ucelebi.service.JobService;

@Service
@Transactional
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobRepository jobRepository;
	
	@Override
	public Job getOneJob(int id) {
		return jobRepository.getOne(id);
		
	}
	
	@Override
	public Job createJob(Job job) {
		return jobRepository.save(job);
		
	}
	
	@Override
	public List<Job> allJob(){
		return jobRepository.findAll();
	}

	@Override
	public void updateJob(Job job2,int id) {
		Job job=jobRepository.getOne(id);
		
		job.setJobDescription(job2.getJobDescription());
		job.setJobTitle(job2.getJobTitle());
		job.setLastApplication(job2.getLastApplication());
		job.setNumberOfPeople(job2.getNumberOfPeople());
		
		jobRepository.save(job);
	}

	@Override
	public void deleteJob(int id) {
		jobRepository.deleteById(id);
	}
}
