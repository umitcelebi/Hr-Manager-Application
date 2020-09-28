package com.ucelebi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ucelebi.model.File;
import com.ucelebi.repo.FileRepository;
import com.ucelebi.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public File saveFile(MultipartFile multipartFile) {
		String fileName=multipartFile.getOriginalFilename();
		
		try {
			File file=new File(fileName, multipartFile.getContentType(), multipartFile.getBytes());
			return fileRepository.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Optional<File> getFile(int id){
		return fileRepository.findById(id);
	}
	
	@Override
	public List<File> getFiles(){
		return fileRepository.findAll();
	}
}
