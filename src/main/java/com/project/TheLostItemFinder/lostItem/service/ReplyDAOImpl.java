package com.project.TheLostItemFinder.lostItem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("replyDAO")
public class ReplyDAOImpl implements ReplyDAO{
	static final String namespace ="Reply";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public boolean insertReply(ReplyDTO dto) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("reply", dto);
		sqlSession.insert(namespace+".insertOne",param);
		return true;
	}

	@Override
	public boolean updateReply() {
		return false;
	}

	@Override
	public boolean deleteReply() {
		return false;
	}

	/*@Override
	public Integer seqByID(String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("id", id);
		return sqlSession.selectOne(namespace+".selectSeq",param);
	}*/

	@Override
	public List<ReplyDTO> selectReply(Integer id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		return sqlSession.selectList(namespace+".selectList",param);
	}

}
