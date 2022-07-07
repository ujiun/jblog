package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	//블로그 등록
	public void insertBlog(BlogVo blogVo) {
		System.out.println("BlogDao > insertBlog");
		
		sqlSession.insert("blog.insertBlog", blogVo);
		
	}
	
	//블로그정보 하나 가져오기
	public BlogVo getBlog(String id) {
		System.out.println("BlogDao > getBlog");
		
		return sqlSession.selectOne("blog.getBlog", id);
		
	}
	
	//블로그 업데이트
	public int updateBlog(BlogVo blogVo) {
		System.out.println("BlogDao > updateBlog");
		
		return sqlSession.update("blog.updateBlog", blogVo);
	}
	
}
