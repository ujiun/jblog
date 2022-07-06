package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

	//블로그방문
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String visit() {
		System.out.println("BlogController > visit()");
		
		return "blog/blog-main";
	}

}
