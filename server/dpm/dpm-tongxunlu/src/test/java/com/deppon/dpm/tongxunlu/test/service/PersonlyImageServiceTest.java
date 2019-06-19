package com.deppon.dpm.tongxunlu.test.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;

public class PersonlyImageServiceTest extends BaseTestCase{
	
	@Autowired
	private IPersonlyImageService personlyImageService;

	@Test
	public void testUpdateImage(){
		EmpExtensionEntity entity = new EmpExtensionEntity();
		entity.setEmpCode("268105");
		entity.setPictPath("b91aa8df-d978-4059-9d4b-7ec942c1562f.jpg");
		int i = personlyImageService.updateImage(entity);
		System.out.println(i);
	}
	
	@Test
	public void testDeleteFile() throws IOException{
		String empCode = "268105";
		personlyImageService.deleteFile(empCode);
	}
	
/*	@Test
	public void testUploadImage() throws IOException, URISyntaxException{
		///dpmfile/headPhoto
		File[] file = new File[]{new File("/dpmfile/headPhoto/7a1b5fca-d863-4114-bab0-07dddb41713c.jpg")};
		String empCode = "268105";
		String[] fileNames = {"小虫子"};
		int i = personlyImageService.uploadImage(file, empCode, fileNames);
		System.out.println(i);
	}*/
	
	@Test
	public void testDownloadImage() throws FileNotFoundException{
		String downloadImage = personlyImageService.downloadImage("268105");
		System.out.println(downloadImage);
	}
}
