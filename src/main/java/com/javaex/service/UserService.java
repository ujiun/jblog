package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogdao;
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("UserService > join");
		
		int count = userDao.userInsert(userVo);
		
		String id = userVo.getId();
		
		BlogVo blogVo = new BlogVo();
		
		blogVo.setId(id);
		blogVo.setBlogTitle(id+"의 블로그입니다");
		
		
		blogdao.insertBlog(blogVo);
		
		return count;
	}
	
	//아이디 중복체크
	public String getId(String id) {
		System.out.println("UserService > getId");
		
		String state = null;
		
		UserVo userVo = userDao.getId(id);
		
		if(userVo == null) {
			state = "available";
		}else {
			state = "unavailable";
		}
		
		
		return state;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("UserService > login");
		
		return userDao.getUser(userVo);
	}
	
	
	
}
