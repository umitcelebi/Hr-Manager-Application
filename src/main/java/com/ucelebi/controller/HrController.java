package com.ucelebi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ucelebi.model.File;
import com.ucelebi.model.Job;
import com.ucelebi.service.FileService;
import com.ucelebi.service.JobService;

@Controller
@RequestMapping("/hr")
public class HrController {

	@Autowired
	JobService jobService;

	@Autowired
	FileService fileService;

	// Create a New Job
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView saveJob(@ModelAttribute Job job) {

		jobService.createJob(job);

		return new ModelAndView("redirect:/job/jobs");
	}

	// Delete Job
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteJob(@PathVariable int id) {

		jobService.deleteJob(id);
		return new ModelAndView("redirect:/job/jobs");
	}

	// Send Job Info to Job Details for Update
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateJob(@PathVariable int id) {
		Job job = jobService.getOneJob(id);

		ModelAndView modelAndView = new ModelAndView("createJob");
		modelAndView.addObject("job", job);
		return modelAndView;
	}

	// Download Resume FILE
	@RequestMapping(value = "/download/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable(required = false) int fileId) {
		File file = fileService.getFile(fileId).get();
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + file.getFileName() + "\"")
				.body(new ByteArrayResource(file.getData()));
	}

	// CreateJob Page
	@RequestMapping(value = "/createjob", method = RequestMethod.GET)
	public ModelAndView createJobPage(@ModelAttribute Job job) {

		return new ModelAndView("createJob");
	}

}
