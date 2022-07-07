package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	//블로그방문
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String visit(@PathVariable("id") String id, Model model) {		
		System.out.println("BlogController > visit()");
		
		BlogVo blogVo= blogService.getBlog(id);
		
		if(blogVo == null) {
			return "redirect:/";
		}
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/blog-main";
	}
	
	//내블로그 관리
	@RequestMapping(value = "/{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String admin(@PathVariable("id") String id, HttpSession session, Model model) {
		System.out.println("BlogController > admin()");
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");

		if( userVo != null ) {
			String authUserId = userVo.getId();
			
			if(authUserId.equals(id)) {
				return "blog/admin/blog-admin-basic";
			}
			
		}
			
		return "redirect:/";
		
	}

}
