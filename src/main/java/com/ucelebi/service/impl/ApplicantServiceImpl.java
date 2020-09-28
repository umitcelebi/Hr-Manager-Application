package com.ucelebi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucelebi.model.Applicants;
import com.ucelebi.model.File;
import com.ucelebi.model.Job;
import com.ucelebi.repo.ApplicantRepository;
import com.ucelebi.repo.JobRepository;
import com.ucelebi.service.ApplicantService;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService{
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Override
	public Applicants createApplicant(Applicants applicants) {
		return applicantRepository.save(applicants);
	}
	
	@Override
	public List<Applicants> allApplicants(){
		return applicantRepository.findAll();
	}
	
	@Override
	public void applyForJobs(int jobId,Applicants applicants,File file) {
		Job job=jobRepository.getOne(jobId);
		
		Applicants applicants2=new Applicants();
		applicants2.setAddress(applicants.getAddress());
		applicants2.setEmail(applicants.getEmail());
		applicants2.setName(applicants.getName());
		applicants2.setPhone(applicants.getPhone());
		applicants2.setThoughtsOnJob(applicants.getThoughtsOnJob());
		applicants2.setFile(file);
		
		createApplicant(applicants2);
		
		job.getApplicants().add(applicants2);
		
		jobRepository.save(job);
	}
}
