package com.project.TheLostItemFinder.lostItem.service;

import java.util.List;

public interface ArticleDAO {

	public boolean insertItem(ArticleDTO dto);
	
	public boolean updateItem();
	
	public boolean deleteItem(int seq);
	
	public List<ArticleDTO> selectList(int page, int delimit) throws Exception;

	public List<ArticleDTO> selectList(int page, int delimit, String searchType, String search) throws Exception;
	
	public List<ArticleDTO> selectAdminList(int page, int delimit, String office) throws Exception;

	public ArticleDTO selectAArticle(int seq);
	
	public int totalPage(int delimit);
	
	public boolean setOffice(int seq, String office);

	List<ArticleDTO> selectThumbnail(int limit, int page);
}
