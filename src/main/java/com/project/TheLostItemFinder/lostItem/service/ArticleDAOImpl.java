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
	
	
	/*
	 * Article 삭제에 성공하면 true를 반환
	 * (non-Javadoc)
	 * @see com.project.TheLostItemFinder.lostItem.service.ArticleDAO#deleteItem(int)
	 */
	public boolean deleteItem(int seq) {
		if(sqlSession.delete(namespace+".deleteArticle",seq)==1)
			return true;
		return false;
	}
	public boolean setOffice(int seq, String office) {
		HashMap<String,Object> param = new HashMap<String,Object>();
		
		param.put("seq", seq);
		param.put("office", office);
		if(sqlSession.update(namespace+".setOffice", param)!=1) {
			return false;
		}
		return true;
	}
	public int totalPage(int delimit) {
		int count=sqlSession.selectOne(namespace+".selectPage");
		
		return count/delimit + 1;
	}
	
	public List<ArticleDTO> selectList(int page, int delimit) throws Exception{
		HashMap<String,Integer> param = new HashMap<String,Integer>();
		page*=delimit;
		
		param.put("page", page);
		param.put("limit", delimit);
		return sqlSession.selectList(namespace+".selectAll",param);	
	}
	
	public List<ArticleDTO> selectList(int page, int delimit, String searchType, String search) throws Exception{
		HashMap<String,String> param = new HashMap<String,String>();
		search="%"+search+"%";
		param.put("search",search);
		return sqlSession.selectList(namespace+".searchBy"+searchType,param);
		
	}
	
	public ArticleDTO selectAArticle(int seq) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("seq", seq);
		sqlSession.update(namespace+".updateHits",param);
		return sqlSession.selectOne(namespace+".selectOne",param);
	}
	public List<ArticleDTO> selectThumbnail(){
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("page", 0);
		param.put("limit", 10);
		return sqlSession.selectList(namespace+".selectAdminAll",param);
	}
	@Override
	public List<ArticleDTO> selectAdminList(int page, int delimit, String office) throws Exception {
		HashMap<String,Object> param = new HashMap<String,Object>();
		page*=delimit;
		param.put("office", office);
		param.put("page", page);
		param.put("limit", delimit);
		return sqlSession.selectList(namespace+".selectAdmin",param);	
	}

}
