package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private UserService userService;
	
	//블로그방문
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String visit(@PathVariable("id") String id, Model model) {		
		System.out.println("BlogController > visit()");
		
		UserVo userVo= userService.getUser(id);

		model.addAttribute("userVo", userVo);
		
		return "blog/blog-main";
	}

}
