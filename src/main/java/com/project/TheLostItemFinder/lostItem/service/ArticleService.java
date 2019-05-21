package com.project.TheLostItemFinder.lostItem.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.TheLostItemFinder.fUtil;

@Service("articleService")
public class ArticleService {

	@Resource(name="articleDAO")
	ArticleDAOImpl dao= new ArticleDAOImpl();
	
	@Resource(name="replyDAO")
	ReplyDAOImpl rdao= new ReplyDAOImpl();
	
	public ArticleDTO getArticle(int seq) {
		return dao.selectAArticle(seq);
	}
	
	public List<ReplyDTO> getReply(int seq) {
		return rdao.selectReply(seq);
	}
	
	public List<ArticleDTO> getList(int page, int delimit) throws Exception {
		return dao.selectList(page, delimit);
	}
	
	public boolean addReply(int seq, String contents, String writer){
		ReplyDTO dto=new ReplyDTO();
		dto.setDATE(fUtil.date());
		dto.setNICKNAME(writer);
		dto.setARTICLE_SEQ(seq);
		dto.setCONTENTS(contents);
		
		return rdao.insertReply(dto);
	}
	public boolean addArticle(String title, String type_item, String contents, String place, String nickName) {
		ArticleDTO dto=new ArticleDTO();
		
		dto.setDATE_UPLOAD(fUtil.date());
		dto.setTITLE(title);
		dto.setTYPE_ITEM(type_item);
		dto.setCONTENTS(contents);
		dto.setPLACE(place);
		dto.setNICKNAME(nickName);
		dao.insertItem(dto);
		
		return true;
	}
	
}
