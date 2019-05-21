package com.project.TheLostItemFinder.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberDAO")
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String namespace="Member";
	
	public boolean confirmPW(String id, String pw) {
		Map<String,Object> param = new HashMap<String, Object>();
		System.out.println("id, pw"+id+pw);
		param.put("id", id);
		param.put("pw", pw);
		Integer n=sqlSession.selectOne(namespace+".selectPW",param);
		if(n==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getNickName(String id) {
		Map<String,Object> param = new HashMap<String, Object>();
		System.out.println("id, pw"+id);
		param.put("id", id);
		return sqlSession.selectOne(namespace+".selectNickName",param);
	}
	
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
