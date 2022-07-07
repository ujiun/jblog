package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value= "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//회원가입폼
	@RequestMapping(value = "/joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController > joinForm()");
		
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value = "/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {	//디스패처서블릿이 setter로 만들어줌
		System.out.println("UserController > join()");
		
		userService.join(userVo);
		
		
		return "user/joinSuccess";
	}
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = {RequestMethod.GET, RequestMethod.POST})
	public String idCheck(@RequestBody String id) {
		System.out.println("UserController > idCheck()");
		
		String state = userService.getId(id);
		
		return state;
	}
	
	//로그인폼
	@RequestMapping(value = "/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController > loginForm()");

		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController > login()");
		
		UserVo authUser = userService.login(userVo);
		
		//세션저장
		if(authUser != null) {
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			
			return "redirect:/";
		}else {
			System.out.println("로그인 실패");
			
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController > logout()");
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	

}
