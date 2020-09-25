package com.ucelebi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "jobs")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jobTitle;
	private String jobDescription;
	private int numberOfPeople;
	
	@DateTimeFormat(pattern = "yyyy-M-dd'T'HH:mm")
	private Date lastApplication;
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Applicants> applicants=new ArrayList<Applicants>();
	
	public List<Applicants> getApplicants() {
		return applicants;
	}
	public void setApplicants(List<Applicants> applicants) {
		this.applicants = applicants;
	}
	//----------------------------------------------
	
	public Job() {	}

	public Job(String jobTitle, String jobDescription, int numberOfPeople, Date lastApplication) {
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.numberOfPeople = numberOfPeople;
		this.lastApplication = lastApplication;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public Date getLastApplication() {
		return lastApplication;
	}
	public void setLastApplication(Date lastApplication) {
		this.lastApplication = lastApplication;
	}
	public String bilgiler() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", jobDescribtion=" + jobDescription + ", numberOfPeople="
				+ numberOfPeople + ", lastApplication=" + lastApplication + ", applicants=" + applicants + "]";
	}
	
	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", jobDescribtion=" + jobDescription + ", numberOfPeople="
				+ numberOfPeople + ", lastApplication=" + lastApplication+"]";
	}
	
	public boolean getApplicantDate() {
		Date currentDate=new Date();
		return lastApplication.before(currentDate);
	}
}
