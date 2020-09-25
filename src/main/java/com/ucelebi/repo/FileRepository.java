package com.ucelebi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucelebi.model.File;

public interface FileRepository extends JpaRepository<File, Integer>{

}
