package com.project.TheLostItemFinder.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {
	
	String[] GRADE = {"ADMIN","MEMBER"};
	
	@Resource(name = "memberDAO")
	MemberDAO dao= new MemberDAO();
	
	public boolean checkDouble(String id) {
		return dao.checkDouble(id);
	}
	
	public boolean registerMember(String id, String pw, String tel, String nickname) {
		MemberDTO dto = new MemberDTO();
		dto.setID(id);
		dto.setPW(pw);
		dto.setNICKNAME(nickname);
		dto.setTEL(tel);
		if(dao.insertMember(dto)!=1) {
			return false;
		}
		
		return true;
	}
	
	public String getOffice(String seq) {
		return dao.getOffice(seq);
	}
	
	public MemberDTO login(String id, String pw) {
		if(dao.confirmPW(id, pw)) {
			return dao.getMember(id);
		}else {
			return null;
		}
	}
	
	public boolean logout() {
		//TODO 로그아웃
		return true;
	}
	
	
}
