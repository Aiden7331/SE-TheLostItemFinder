package com.project.TheLostItemFinder.lostItem.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("officeDAO")
public class OfficeDAOImpl implements OfficeDAO{
	private static final String namespace = "Office";

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public OfficeDTO getOneOffice(int seq) {
		HashMap<String,Object> param = new HashMap<String,Object>();
		
		param.put("seq", seq);
		
		return sqlSession.selectOne(namespace+".selectOneOffice",param);
	}

	public boolean updateOffice(OfficeDTO dto) {
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("dto", dto);
		if(sqlSession.update(namespace+".updateOffice",param)==1) {
			return true;
		}
		return false;
	}

}
