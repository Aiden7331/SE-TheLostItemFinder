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
	
	//private SqlSessionFactory sqlSession;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArticleDAOImpl(){
	}
	/*
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	*/
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
	
	public List<ArticleDTO> selectList() throws Exception{
		//System.out.println("sqlSessionFactory == > "+sqlSession);
		//SQLSession=sqlSession.openSession();
		System.out.print("SQLSESSION INJECTION ERROR : ");
		System.out.println(sqlSession);
		return sqlSession.selectList(namespace+".selectAll");
	}
	
	public ArticleDTO selectAArticle(int seq) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("seq", seq);
		return sqlSession.selectOne(namespace+".selectOne",param);
	}
}
