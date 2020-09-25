package com.ucelebi.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ucelebi.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
}
