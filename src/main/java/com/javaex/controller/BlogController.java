package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

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
		
		model.addAttribute("blogVo", blogVo);
		
		return "blog/blog-main";
	}

}
