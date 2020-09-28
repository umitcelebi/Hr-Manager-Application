package com.ucelebi.service;

import java.util.List;

import com.ucelebi.model.Job;

public interface JobService {
	
	Job getOneJob(int id);
	Job createJob(Job job);
	List<Job> allJob();
	void updateJob(Job job2,int id);
	void deleteJob(int id);
	
}
