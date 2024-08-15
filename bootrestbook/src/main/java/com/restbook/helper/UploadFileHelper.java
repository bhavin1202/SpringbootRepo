package com.restbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFileHelper {

	public final String upload_dir = "C:\\Users\\dell\\Documents\\workspace-spring-tool-suite-4-4.21.1.RELEASE\\bootrestbook\\src\\main\\resources\\static\\image\\";
	

	public boolean uploadFile(MultipartFile data )
	
	{
		boolean returnvalue = false;
		try 
		{
			
		//InputStream in = 	data.getInputStream();
		//byte dat[] = new byte[in.available()];
		//in.read(dat);
		
		//FileOutputStream fos = new FileOutputStream(upload_dir+File.separator+data.getOriginalFilename());
		//fos.write(dat);
		//fos.flush();
		//fos.close();
		
		
		Files.copy(data.getInputStream(),Paths.get(upload_dir+File.pathSeparator+data.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		
		returnvalue = true;
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return returnvalue;
		
	}
}
