package com.ucelebi.service;

import java.util.List;

import com.ucelebi.model.Applicants;
import com.ucelebi.model.File;

public interface ApplicantService {

	Applicants createApplicant(Applicants applicants);
	List<Applicants> allApplicants();
	void applyForJobs(int jobId,Applicants applicants,File file);
	
}
