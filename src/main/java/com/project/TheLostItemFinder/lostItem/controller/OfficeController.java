package com.project.TheLostItemFinder.lostItem.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TheLostItemFinder.lostItem.service.ArticleDTO;
import com.project.TheLostItemFinder.lostItem.service.ArticleService;
import com.project.TheLostItemFinder.lostItem.service.OfficeService;
import com.project.TheLostItemFinder.lostItem.service.ReplyDTO;
import com.project.TheLostItemFinder.member.service.MemberDTO;

@Controller
public class OfficeController {
	final int DEFAULT_LIMIT = 10;
	final int DEFAULT_PAGE = 1;
	
	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@Resource(name="officeService")
	OfficeService oserv= new OfficeService();
	
	@RequestMapping(value = "itempage", method=RequestMethod.GET)
	public void totalPage(@RequestParam("limit") Integer limit,@RequestParam("officeName") String officeName,
			HttpServletResponse response) {
		
		String message;
		message = "{\"total\":\"" + oserv.totalPage(limit, officeName) + "\"}";
		try {
			response.getWriter().print(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	
	@RequestMapping(value="items", method=RequestMethod.GET)
	public String admin(Model model, @RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="limit", required=false) Integer limit,
			@RequestParam(value="page",required=false) Integer page, HttpServletRequest request) throws Exception {
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
			limit = DEFAULT_LIMIT;
		}
		if(page==null) {
			page = DEFAULT_PAGE;
		}
		
		list = serv.getAdminList(page, limit,office);
		System.out.println("list :"+list.toString());
		if(list!=null) {
			model.addAttribute("limit",limit);
			model.addAttribute("page", page);
			model.addAttribute("list", list);
		}else {
			return "400_page";
		}
		
		return "items";
	}
	
	@RequestMapping(value="setDiscard", method=RequestMethod.POST)
	public void disCardItem(Model model,@RequestBody String user,
			@RequestBody String office, @RequestBody String seq,
			HttpServletResponse response) throws IOException {
		
		if(serv.setDiscard(Integer.parseInt(seq), user, office)) {
			response.getWriter().write("{'message':'true'}");
		}else {
			response.getWriter().write("{'message':'false'}");
		}
		return ;
	}
	/*
	 * 기능: 관리실이 보관처리한 소유물을 보관취소 처리
	 * 
	 */
	@RequestMapping(value="cancelProperty", method=RequestMethod.GET)
	public void cancelProperty(Model model,@RequestParam(value="seq") int seq, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session=request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("user");
		ArticleDTO adto = serv.getArticle(seq);
		/*요청자가 관리자일때만 수행 */
		if(mdto.getOFFICE_SEQ().equals(adto.getOFFICE_SEQ())) {
			if(serv.cancelProperty(seq)) {
				response.getWriter().write("{'message':'true'}");
			}else {
				response.getWriter().write("{'message':'false'}");
			}
		}
		return ;
	}
	/*
	 * 
	 * 
	 */
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
	
	@RequestMapping(value="info_office", method=RequestMethod.GET)
	public String showOffice(Model model, @RequestParam(value="seq", required=false) String seq) {
		if(seq!=null) {
			model.addAttribute("office",oserv.getOneOffice(Integer.parseInt(seq)));
		}else {
			return "400_page";
		}
		
		return "info_office";
	}
	
	@RequestMapping(value="updateInfoOffice", method=RequestMethod.POST)
	public String updateOffice(Model model, @RequestParam("name") String name,
			@RequestParam("tel") String tel,
			@RequestParam("location") String location) {
		oserv.updateOffice(name,tel,location);
		return "terminate";
	}
}

