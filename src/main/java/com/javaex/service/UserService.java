package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("UserService > join");
		
		int count = userDao.userInsert(userVo);
		
		return count;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("UserService > login");
		
		return userDao.getUser(userVo);
	}
	
	//한명정보 가져오기
	public UserVo getUser(String id) {
		System.out.println("UserService > getUser");
		
		return userDao.getUser(id);
	}
	
	
}
