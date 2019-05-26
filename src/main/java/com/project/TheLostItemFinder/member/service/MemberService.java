package com.project.TheLostItemFinder.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {
	
	@Resource(name = "memberDAO")
	MemberDAO dao= new MemberDAO();
	
	public boolean checkDouble() {
		//TODO 중복확인
		return true;
	}
	
	public boolean updateMemInfo() {
		//TODO 사용자 정보 수정
		return true;
	}
	
	public String login(String id, String pw) {
		if(dao.confirmPW(id, pw)) {
			return dao.getNickName(id);
		}else {
			return null;
		}
	}
	
	public boolean logout() {
		//TODO 로그아웃
		return true;
	}
	
	
}