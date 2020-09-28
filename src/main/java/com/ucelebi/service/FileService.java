package com.ucelebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.ucelebi.model.File;

public interface FileService {

	File saveFile(MultipartFile multipartFile);
	Optional<File> getFile(int id);
	List<File> getFiles();
}
