package com.project.TheLostItemFinder.member.service;

public class MemberDTO {
	private String ID;
	private String PW;
	private String TEL;
	private String GRADE;
	private String NICKNAME;
	private int ADMINNUM;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getGRADE() {
		return GRADE;
	}
	public void setGRADE(String gRADE) {
		GRADE = gRADE;
	}
	public String getNICKNAME() {
		return NICKNAME;
	}
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	public int getADMINNUM() {
		return ADMINNUM;
	}
	public void setADMINNUM(int aDMINNUM) {
		ADMINNUM = aDMINNUM;
	}
	
}
