package com.restbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restbook.helper.UploadFileHelper;

@RestController
public class FileUploadController {

	@Autowired
	private UploadFileHelper uploadfilehelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile  file	)
	{
		//System.out.println(file.getContentType());
		//System.out.println(file.getSize());
		//System.out.println(file.getOriginalFilename());
		
		
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is empty");
		}
		
		else if (!file.getContentType().equals("image/webp"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("webp file can only be uploaded");
		}
		
		// file upload code 
		
		boolean uploadstatus = uploadfilehelper.uploadFile(file);
		if(!uploadstatus)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while uploading the file");
			
			else
			return ResponseEntity.ok("Working fine");
	}
}
