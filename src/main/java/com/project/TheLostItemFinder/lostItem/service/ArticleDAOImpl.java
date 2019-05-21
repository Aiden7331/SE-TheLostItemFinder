package com.project.TheLostItemFinder.lostItem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("articleDAO")
public class ArticleDAOImpl implements ArticleDAO{
	private static final String namespace = "Article";
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArticleDAOImpl(){
	}
	
	public boolean insertItem(ArticleDTO dto) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("article", dto);
		if(sqlSession.insert(namespace+".insertOne", param)==1)
			return true;
		else 
			return false;
	}
	
	public boolean updateItem() {
		return true;
	}
	
	/*public boolean deleteItem() {
		return true;
	}*/
	
	public List<ArticleDTO> selectList(int page, int delimit) throws Exception{
		return sqlSession.selectList(namespace+".selectAll");
	}
	
	public ArticleDTO selectAArticle(int seq) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("seq", seq);
		sqlSession.update(namespace+".updateHits",param);
		return sqlSession.selectOne(namespace+".selectOne",param);
	}
}
