package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinform() {
		System.out.println("joinform");
		return "user/joinForm";
	}
	@RequestMapping(value="/joins", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println(userVo.toString());
		
		userService.join(userVo);
		
		return "user/joinSuccess";
	}

	@RequestMapping(value="/loginform",method=RequestMethod.GET)
	public String loginform() {
		System.out.println("loginform");
		return "user/loginForm";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password")String password,
						HttpSession session) {
		UserVo uservo=userService.login(id,password);
		String url;
		if(uservo != null) {
			session.setAttribute("authUser", uservo);
		url= "redirect:/";
		}
		else {
			url= "redirect:/user/loginform?no=1";
			}
		return url;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String loginout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	@ResponseBody                            //바디에 데이터 넣어서 보낼꺼니까 기존방식으로 해석하지 마라
	@RequestMapping(value="/idcheck",method=RequestMethod.POST)
	public boolean exists(@RequestParam("id") String id) {
		boolean isExists=userService.idcheck(id);
		return isExists;
	}
}
