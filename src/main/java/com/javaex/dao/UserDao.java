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
		
		return sqlSession.insert("user.insertUser", userVo);
	}
	
	//아이디중복체크
	public UserVo getId(String id) {
		System.out.println("UserDao > getId");
		
		return sqlSession.selectOne("user.getId", id);
	}
	
	//로그인
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao > getUser");
		
		return sqlSession.selectOne("user.getUser", userVo);
	}
	

}
