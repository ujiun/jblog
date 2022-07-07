package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	
	//블로그정보 하나 가져오기
	public BlogVo getBlog(String id) {
		System.out.println("BlogService > getBlog");
		
		return blogDao.getBlog(id);
	}
	
	//블로그 업데이트
	public int update(BlogVo blogVo, MultipartFile file) {
		System.out.println("BlogService > update");
		
		String saveDir = "C:\\javaStudy\\upload";
		
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장할 파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일경로(디렉토리+저장파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일 하드디스크저장
		
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		blogVo.setLogoFile(saveName);
		
		return blogDao.updateBlog(blogVo);
	}
}
