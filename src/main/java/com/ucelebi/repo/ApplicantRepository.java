package com.ucelebi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucelebi.model.Applicants;

public interface ApplicantRepository extends JpaRepository<Applicants, Integer> {
	
}
