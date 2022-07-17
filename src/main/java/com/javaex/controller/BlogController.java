package com.javaex.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	//블로그 메인
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(@PathVariable("id") String id, Model model) {		
		System.out.println("BlogController > main()");
		
		Map<String, Object> bMap= blogService.getBlog(id);
		
		if(bMap == null) {
			return "redirect:/";
		}
		
		model.addAttribute("bMap", bMap);
		
		return "blog/blog-main";
	}
	
	//블로그 관리폼 
	@RequestMapping(value = "/{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String admin(@PathVariable("id") String id, HttpSession session, Model model) {
		System.out.println("BlogController > admin()");
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");

		if( userVo != null) {
			String authUserId = userVo.getId();
			
			if(authUserId.equals(id)) {
				
				Map<String, Object> bMap= blogService.getBlog(id);
				
				model.addAttribute("bMap", bMap);
				
				return "blog/admin/blog-admin-basic";
			}
			
		}
			
		return "redirect:/";
	}
	
	//블로그 업데이트
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute BlogVo blogVo, @RequestParam("file") MultipartFile file, HttpSession session) {
		System.out.println("BlogController > update()");
		
		UserVo authUser= (UserVo)session.getAttribute("authUser");
		
		blogVo.setId(authUser.getId());				
		
		blogService.update(blogVo, file);
		
		return "redirect:./" + authUser.getId() +"/admin/basic";
	}

}
