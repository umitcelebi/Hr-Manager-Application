package com.ucelebi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Applicants {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String thoughtsOnJob;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private File file;
	
	public Applicants() {}
	
	public Applicants(int id,String name, String email, String phone, String address, String thoughtsOnJob) {
		this.id=id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.thoughtsOnJob = thoughtsOnJob;
	}
	public Applicants(String name, String email, String phone, String address, String thoughtsOnJob, List<Job> jobs) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.thoughtsOnJob = thoughtsOnJob;
		this.jobs = jobs;
	}
	public Applicants(String name, String email, String phone, String address, String thoughtsOnJob) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.thoughtsOnJob = thoughtsOnJob;
	}

	@ManyToMany(mappedBy = "applicants",fetch = FetchType.EAGER)
	private List<Job> jobs=new ArrayList<Job>();
	
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	//----------------------------------------------
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	//----------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//----------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//----------------------------------------------
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//----------------------------------------------
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//----------------------------------------------
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//----------------------------------------------
	public String getThoughtsOnJob() {
		return thoughtsOnJob;
	}
	public void setThoughtsOnJob(String thoughtsOnJob) {
		this.thoughtsOnJob = thoughtsOnJob;
	}
	//----------------------------------------------
	@Override
	public String toString() {
		return "Applicants [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", thoughtsOnJob=" + thoughtsOnJob + ", jobs=" + jobs + "]";
	}
	
}
