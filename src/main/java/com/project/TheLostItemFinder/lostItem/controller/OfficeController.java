package com.project.TheLostItemFinder.lostItem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TheLostItemFinder.lostItem.service.ArticleDTO;
import com.project.TheLostItemFinder.lostItem.service.ArticleService;
import com.project.TheLostItemFinder.lostItem.service.ReplyDTO;

@Controller
public class OfficeController {

	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@RequestMapping(value="items", method=RequestMethod.GET)
	public String admin(Model model, @RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="limit", required=false) Integer limit, HttpServletRequest request) throws Exception {
		ArticleDTO dto = null;
		List<ReplyDTO> rlist = null;
		/*세션에서 관리실이름 획득*/
		HttpSession session = request.getSession();
		String office=(String)session.getAttribute("office");
		/*게시물 출력*/
		if(id!=null && (dto=serv.getArticle(id))!=null) {
			System.out.println("Having article :"+dto);
			model.addAttribute("article",dto);
			model.addAttribute("isArticle",true);
			rlist=serv.getReply(id);
			model.addAttribute("replies",rlist);
		}else {
			model.addAttribute("isArticle",false);
		}
		List<ArticleDTO> list = null;
		
		/*게시판 목록 출력*/
		if(limit==null) {
			limit=10;
		}
		list = serv.getAdminList(0, limit,office);
		System.out.println("list :"+list.toString());
		if(list!=null) {
			model.addAttribute("page", 1);
			model.addAttribute("list", list);
		}else {
			return "400_page";
		}
		
		return "items";
	}
	
	@RequestMapping(value="setgiven", method=RequestMethod.GET)
	public String addItem(Model model,@RequestParam(value="seq") int seq,
			@RequestParam(value="name")String name, @RequestParam(value="tel")String tel,
			@RequestParam(value="memo")String memo, HttpServletResponse response) {
		if(serv.setGiven(name, memo, tel, seq)) {
			//TODO 성공
		}else {
			//TODO 실패
		}
		return "terminate";
	}
	
	@RequestMapping(value="find_result", method=RequestMethod.GET)
	public String adminGive(Model model, @RequestParam(value="seq", required=false) String seq) {
		if(seq!=null) {
			model.addAttribute(seq);
		}
		
		return "find_result";
	}
}

