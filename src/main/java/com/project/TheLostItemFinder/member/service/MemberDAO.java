package com.project.TheLostItemFinder.member.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	private SqlSession sqlSession;
	private final String namespace="Member";
	
	public boolean insertMember(MemberDTO dto){
		return false;
	}
	
	public boolean updateMember(MemberDTO dto) {
		return false;
		
	}
	public boolean deleteMember(MemberDTO dtd) {
		return false;
		
	}
	
	public ArrayList<MemberDTO> selectMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		return list;
	}
	
	public MemberDTO selectAMember() {
		MemberDTO dto=new MemberDTO();
		
		return dto;
	}
}
