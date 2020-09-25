package com.ucelebi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ucelebi.model.Applicants;
import com.ucelebi.model.File;
import com.ucelebi.model.Job;
import com.ucelebi.service.ApplicantService;
import com.ucelebi.service.FileService;
import com.ucelebi.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController {

	@Autowired
	JobService jobService;

	@Autowired
	FileService fileService;

	@Autowired
	ApplicantService applicantsService;
	
	
	@GetMapping
	public ModelAndView home() {
		return new ModelAndView("jobList");
	}

	// All Jobs
	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ModelAndView giris() {

		List<Job> jobList = jobService.allJob();

		ModelAndView modelAndView = new ModelAndView("jobList");

		modelAndView.addObject("jobList", jobList);

		return modelAndView;
	}
	
	// Job Details
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public ModelAndView detailsJob(@ModelAttribute Applicants applicants,@PathVariable int id) {

		ModelAndView modelAndView = new ModelAndView("jobDetails");
		
		Job job = jobService.getOneJob(id);
		List<Applicants> applicant = job.getApplicants();
		
		modelAndView.addObject("job", job);
		modelAndView.addObject("applicants", applicant);
		modelAndView.addObject("applicant", applicants);
		return modelAndView;
	}

	//ApplyForJob
	@RequestMapping(value = "/apply",method = RequestMethod.POST,consumes = {"multipart/form-data"} )
	public ModelAndView jobForApply(@RequestParam(value = "jobId") int id,
									@ModelAttribute Applicants applicants,
									@RequestParam("uploadedfile") MultipartFile file) {
		
		File file2=fileService.saveFile(file);
		applicantsService.applyForJobs(id, applicants,file2);
		
		return new ModelAndView("redirect:jobs");
	}

}
