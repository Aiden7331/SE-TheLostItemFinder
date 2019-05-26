package com.project.TheLostItemFinder.lostItem.service;

import java.util.List;

public interface ReplyDAO {
	boolean insertReply(ReplyDTO dto);
	boolean updateReply();
	boolean deleteReply();
	public List<ReplyDTO> selectReply(Integer id);
}