package com.ucelebi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucelebi.model.Applicants;
import com.ucelebi.model.File;
import com.ucelebi.model.Job;
import com.ucelebi.repo.ApplicantRepository;
import com.ucelebi.repo.JobRepository;

@Service
@Transactional
public class ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	
	public Applicants createApplicant(Applicants applicants) {
		return applicantRepository.save(applicants);
	}
	
	public List<Applicants> allApplicants(){
		return applicantRepository.findAll();
	}
	
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
