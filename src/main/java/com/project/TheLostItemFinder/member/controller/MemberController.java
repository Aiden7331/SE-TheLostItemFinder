package com.project.TheLostItemFinder.member.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TheLostItemFinder.member.service.MemberDTO;
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
	public void login(Model model, HttpServletRequest request, @RequestParam("id") String id, @RequestParam("pw") String pw, HttpServletResponse response) {
		MemberDTO member;
		String login;
		
		if((member = serv.login(id, pw))!=null) {
			HttpSession session = request.getSession();
			//session.isNew() 세션이 새로운 것인지?
			session.setAttribute("user", member);
			login="{\"message\":\"true\"}";
		}else {
			login="{\"message\":\"false\"}";
		}
		try {
			response.getWriter().print(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	@RequestMapping(value="register-1", method = RequestMethod.GET)
	public String register1(Model model) {
		return "terms";
	}
	
	@RequestMapping(value="register-2",method = RequestMethod.GET)
	public String register2(Model model) {
			return "register1";
	}
	
	@RequestMapping(value="register-3",method = RequestMethod.POST)
	public String register3(Model model) {
			return "register2";
	}
}
