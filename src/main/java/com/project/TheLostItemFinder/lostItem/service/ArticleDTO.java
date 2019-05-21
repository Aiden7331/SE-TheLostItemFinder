package com.project.TheLostItemFinder.lostItem.service;

public class ArticleDTO {
	private String TYPE_ARTICLE;
	private String TYPE_ITEM;
	private String DATE_LOST;
	private String DATE_UPLOAD;
	private String TITLE;
	private String IMAGE;
	private String NICKNAME;
	private String CONTENTS;
	private String PLACE;
	private String HOLD;
	private int HITS;
	private int SEQ;
	
	
	
	public String getNICKNAME() {
		return NICKNAME;
	}
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	public int getHITS() {
		return HITS;
	}
	public void setHITS(int hITS) {
		HITS = hITS;
	}
	public String getTYPE_ARTICLE() {
		return TYPE_ARTICLE;
	}
	public void setTYPE_ARTICLE(String tYPE_ARTICLE) {
		TYPE_ARTICLE = tYPE_ARTICLE;
	}
	public String getTYPE_ITEM() {
		return TYPE_ITEM;
	}
	public void setTYPE_ITEM(String tYPE_ITEM) {
		TYPE_ITEM = tYPE_ITEM;
	}
	public String getDATE_LOST() {
		return DATE_LOST;
	}
	public void setDATE_LOST(String dATE_LOST) {
		DATE_LOST = dATE_LOST;
	}
	public String getDATE_UPLOAD() {
		return DATE_UPLOAD;
	}
	public void setDATE_UPLOAD(String dATE_UPLOAD) {
		DATE_UPLOAD = dATE_UPLOAD;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public String getPLACE() {
		return PLACE;
	}
	public void setPLACE(String pLACE) {
		PLACE = pLACE;
	}
	public String getHOLD() {
		return HOLD;
	}
	public void setHOLD(String hOLD) {
		HOLD = hOLD;
	}
	public int getSEQ() {
		return SEQ;
	}
	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}
	
	
}
