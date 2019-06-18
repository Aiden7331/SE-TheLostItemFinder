package com.project.TheLostItemFinder.lostItem.service;

import java.util.List;

public interface ReplyDAO {
	boolean insertReply(ReplyDTO dto);
	boolean updateReply();
	int deleteReplies(int article_seq);
	List<ReplyDTO> selectReply(Integer id);
	ReplyDTO selectAReply(Integer id, Integer article_Seq);

	boolean deleteReply(int seq, int article_seq);
}
