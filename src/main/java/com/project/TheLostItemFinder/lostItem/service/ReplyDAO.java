package com.project.TheLostItemFinder.lostItem.service;

public interface ReplyDAO {
	boolean insertReply(ReplyDTO dto);
	Integer seqByID(String id);
	boolean updateReply();
	boolean deleteReply();
	
}
