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
		System.out.println("Reply Writer :"+dto.getNICKNAME());
		sqlSession.insert(namespace+".insertOne",param);
		return true;
	}

	@Override
	public boolean updateReply() {
		return false;
	}

	@Override
	public int deleteReplies(int article_seq) {
		return sqlSession.delete(namespace+".deleteReplies",article_seq);
	}

	@Override
	public boolean deleteReply(int seq,int article_seq) {
		HashMap<String,Integer> param = new HashMap<String,Integer>();
		param.put("seq", seq);
		param.put("article_seq",article_seq);
		if(sqlSession.delete(namespace+".deleteReply",param)!=1) {
			return false;
		}
		
		return true;
	}

	/*@Override
	public Integer seqByID(String id) {
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("id", id);
		return sqlSession.selectOne(namespace+".selectSeq",param);
	}*/
	public ReplyDTO selectAReply(Integer seq,Integer article_seq) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("seq",seq);
		param.put("article_seq", article_seq);
		return sqlSession.selectOne(namespace+".selectOne",param);
	}
	@Override
	public List<ReplyDTO> selectReply(Integer id) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		return sqlSession.selectList(namespace+".selectList",param);
	}

}
