package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
