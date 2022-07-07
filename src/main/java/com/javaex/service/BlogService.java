package com.javaex.service;

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
	public void update(BlogVo blogVo, MultipartFile file) {
		System.out.println("BlogService > update");
		
		blogDao.updateBlog(blogVo);
	}
}
