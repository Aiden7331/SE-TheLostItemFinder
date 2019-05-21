package com.project.TheLostItemFinder.lostItem.service;

public class ReplyDTO {
	private String CONTENTS;
	private int REPLY_SEQ;
	private String DATE;
	private String NICKNAME;
	private int ARTICLE_SEQ;
	
	public String getNICKNAME() {
		return NICKNAME;
	}
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public int getREPLY_SEQ() {
		return REPLY_SEQ;
	}
	public void setREPLY_SEQ(int sEQ) {
		REPLY_SEQ = sEQ;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public int getARTICLE_SEQ() {
		return ARTICLE_SEQ;
	}
	public void setARTICLE_SEQ(int aRTICLE_SEQ) {
		ARTICLE_SEQ = aRTICLE_SEQ;
	}
	
	
}
