package com.project.TheLostItemFinder.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public String getOffice(String seq) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("seq", seq);
		return sqlSession.selectOne(namespace+".selectOffice",param);
	}
	public String getNickName(String id) {
		Map<String,Object> param = new HashMap<String, Object>();
		System.out.println("id, pw"+id);
		param.put("id", id);
		return sqlSession.selectOne(namespace+".selectNickName",param);
	}
	
	public MemberDTO getMember(String id) {
		Map<String,Object> param = new HashMap<String, Object>();
		System.out.println("id, pw"+id);
		param.put("id", id);
		return sqlSession.selectOne(namespace+".selectMember",param);
	}
	public boolean checkDouble(String id) {
		
		MemberDTO dto= (MemberDTO)sqlSession.selectOne(namespace+".checkDouble",id);
		System.out.println("id값:" + id+", list size:"+dto);
		if(dto!=null) {
			return false;
		}
		return true;
	}
	public int insertMember(MemberDTO dto){
		HashMap<String,MemberDTO> param = new HashMap<String,MemberDTO>();
		param.put("dto", dto);
		return sqlSession.insert(namespace+".insertOne",param);
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
