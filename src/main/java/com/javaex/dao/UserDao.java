package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao > userInsert");
		
		return sqlSession.insert("user.insert", userVo);
	}
	
	//로그인
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao > getUser(로그인)");
		
		return sqlSession.selectOne("user.getUser", userVo);
		
	}
	
	//한명정보 가져오기
	public UserVo getUser(String id) {
		System.out.println("UserDao > getUser(한명정보)");
		
		return sqlSession.selectOne("user.getUser2", id);
	}
}
