package com.project.TheLostItemFinder.lostItem.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
	public boolean addReply(int seq, String contents, String writer){
		ReplyDTO dto=new ReplyDTO();
		Integer number = rdao.seqByID(writer);
		if(number==null) {
			return false;
		}
		dto.setDATE(fUtil.date());
		dto.setSEQ(number);
		dto.setSEQ(seq);
		dto.setCONTENTS(contents);
		
		return rdao.insertReply(dto);
	}
	public boolean addArticle(String title, String type_item, String contents, String place) {
		ArticleDTO dto=new ArticleDTO();
		
		dto.setDATE_UPLOAD(fUtil.date());
		dto.setTITLE(title);
		dto.setTYPE_ITEM(type_item);
		dto.setCONTENTS(contents);
		dto.setPLACE(place);
		dao.insertItem(dto);
		
		return true;
	}
	
}
