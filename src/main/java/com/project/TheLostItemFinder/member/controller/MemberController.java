package com.project.TheLostItemFinder.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TheLostItemFinder.member.service.MemberService;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService serv=new MemberService();
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, @RequestParam("id") String id, @RequestParam("pw") String pw) {
		String nickName;
		if((nickName = serv.login(id, pw))!=null) {
		HttpSession session = request.getSession();
		//session.isNew() 세션이 새로운 것인지?
		session.setAttribute("user", nickName);
		}
		return "main";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public String login(Model model, HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String signfor(Model model) {
		return "register";
	}
}
