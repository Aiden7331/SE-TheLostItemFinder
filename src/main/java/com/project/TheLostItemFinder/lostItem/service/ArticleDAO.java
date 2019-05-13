package com.project.TheLostItemFinder.lostItem.service;

import java.util.List;

public interface ArticleDAO {

	public boolean insertItem(ArticleDTO dto);
	
	public boolean updateItem();
	
	/*public boolean deleteItem() {
		return true;
	}*/
	
	public List<ArticleDTO> selectList() throws Exception;
	
	public ArticleDTO selectAArticle(int seq);
}
