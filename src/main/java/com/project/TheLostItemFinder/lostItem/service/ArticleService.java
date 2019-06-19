package com.project.TheLostItemFinder.lostItem.service;

import java.util.Iterator;
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
	public ReplyDTO getAReply(int seq, int article_seq) {
		return rdao.selectAReply(seq,article_seq);
	}
	public List<ReplyDTO> getReply(int seq) {
		return rdao.selectReply(seq);
	}
	
	public int totalPage(int delimit) {
		return dao.totalPage(delimit);
	}
	
	public List<ArticleDTO> getList(int page, int delimit) throws Exception {
		return dao.selectList(page, delimit);	
	}
	
	public List<ArticleDTO> getList(int page, int delimit, String searchType, String search) throws Exception {
		return dao.selectList(page, delimit,searchType, search);	
		
	}
	
	public List<ArticleDTO> getThumbnail(){
		List<ArticleDTO> list = dao.selectThumbnail();
		ArticleDTO dto;
		for(int i=0; i<list.size(); i++) {
			dto=list.get(i);
			String contents=dto.getCONTENTS();
			if(contents.contains("<br>")) {
				contents=contents.replaceAll("<br>", " ");
				contents=contents.trim();
			}
			if(contents.contains("<p>")) {
				contents=contents.replaceAll("<p>", " ");
				contents=contents.trim();
			}
			if(contents.contains("</p>")) {
				contents=contents.replaceAll("</p>", " ");
				contents=contents.trim();
			}
			if(contents.length()>20) {
				contents=contents.substring(0, 20);
			}
			dto.setCONTENTS(contents);
			System.out.println(contents);
			list.set(i, dto);
		}
		return list;
	}
	
	public List<ArticleDTO> getAdminList(int page, int delimit, String office)throws Exception {
		return dao.selectAdminList(page, delimit, office);
	}
	
	public boolean setOffice(int seq, String office) {
		return dao.setOffice(seq, office);
	}
	
	public boolean addReply(int seq, String contents, String writer){
		ReplyDTO dto=new ReplyDTO();
		dto.setDATE(fUtil.date());
		dto.setNICKNAME(writer);
		dto.setARTICLE_SEQ(seq);
		dto.setCONTENTS(contents);
		
		return rdao.insertReply(dto);
	}
	public boolean addArticle(String title, String type_item, String type_article, String contents, String place, String nickName, String date_lost) {
		ArticleDTO dto=new ArticleDTO();
		
		dto.setDATE_UPLOAD(fUtil.date());
		dto.setTITLE(title);
		dto.setTYPE_ITEM(type_item);
		dto.setTYPE_ARTICLE(type_article);
		dto.setCONTENTS(contents);
		dto.setPLACE(place);
		dto.setNICKNAME(nickName);
		dto.setDATE_LOST(date_lost);
		dao.insertItem(dto);
		
		return true;
	}
	public boolean deleteArticle(int seq) {
		rdao.deleteReplies(seq);
		return dao.deleteItem(seq);
	}
	
	public boolean deleteReply(int seq,int article_seq) {
		return rdao.deleteReply(seq, article_seq);
	}
	
	public boolean setGiven(String name, String memo, String tel, int seq) {
		return dao.setGiven(name, memo, tel, seq);
	}
	
	public int todayCount() {
		return dao.todayCount();
	}
}
