package com.project.TheLostItemFinder.lostItem.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.TheLostItemFinder.lostItem.service.ArticleDAOImpl;
import com.project.TheLostItemFinder.lostItem.service.ArticleDTO;
import com.project.TheLostItemFinder.lostItem.service.ArticleService;
import com.project.TheLostItemFinder.lostItem.service.ReplyDTO;
import com.project.TheLostItemFinder.member.service.MemberDTO;

import net.sf.json.JSONObject;

@Controller
public class LostItemController {
	@Resource(name="articleDAO")
	ArticleDAOImpl dao= new ArticleDAOImpl();
	
	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@RequestMapping(value = "board", method=RequestMethod.GET)
	public String findItem(Model model, @RequestParam(value="id", required=false) Integer id, 
			@RequestParam(value="searchType",required=false) String searchType,
			@RequestParam(value="search",required=false) String search,
			@RequestParam(value="limit", required=false) Integer limit) throws Exception {
		ArticleDTO dto = null;
		List<ReplyDTO> rlist = null;
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
		if(searchType==null) {
			list = serv.getList(0, limit);
		}else {
			list = serv.getList(0, 0, searchType, search);	
		}
		
		if(list!=null) {
			model.addAttribute("page", 1);
			model.addAttribute("list", list);
		}else {
			return "400_page";
		}
		
		return "board";
	}
	
	@RequestMapping(value = "boardpage", method=RequestMethod.GET)
	public void totalPage(int limit,HttpServletResponse response) {
		String message;
		message = "{\"total\":\"" + dao.totalPage(limit) + "\"}";
		try {
			response.getWriter().print(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	
	@RequestMapping(value = "board", method=RequestMethod.POST)
	public String findItem(@RequestParam(value="contents", required=true) String contents,
			@RequestParam(value="nickname", required=true) String nickname, 
			@RequestParam(value="id", required=true) Integer id, Model model,
			@RequestParam(value="searchType",required=false) String searchType,
			@RequestParam(value="search",required=false) String search,
			@RequestParam(value="limit", required=false) Integer limit) throws Exception {
		
		System.out.println("received reply request");
		serv.addReply(id, contents, nickname);
		
		ArticleDTO dto = null;
		List<ReplyDTO> rlist = null;
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
		if(searchType==null) {
			list = serv.getList(0, limit);
		}else {
			list = serv.getList(0, 0, searchType, search);	
		}
		
		if(list!=null) {
			model.addAttribute("page", 1);
			model.addAttribute("list", list);
		}else {
			return "400_page";
		}
		
		return "board";
	}
	
	
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
	
	@RequestMapping(value="find_result", method=RequestMethod.GET)
	public String adminGive(Model model, @RequestParam(value="seq", required=false) String seq) {
		if(seq!=null) {
			model.addAttribute(seq);
		}
		
		return "find_result";
	}
	
	
	@RequestMapping(value = "upload", method=RequestMethod.GET)
	public String write(Model model) {
		
		
		return "upload";
	}
	
	@RequestMapping(value="imageup")
	public void ImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) {
		String filename = upload.getOriginalFilename();
		String path="C:\\IMAGE_DATA"+filename;
		byte[] bytes;
		OutputStream out = null;
		try {
			bytes = upload.getBytes();
			out = new FileOutputStream(new File(path));
			out.write(bytes);
			
			String callback=request.getParameter("CKEditorFuncNum");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "upload", method=RequestMethod.POST)
	public String write(Model model, @RequestParam("title") String title, @RequestParam("contents") String contents,
						@RequestParam("type_item") String type_item, @RequestParam("type_article") String type_article,
						@RequestParam("place") String place, @RequestParam("nickname") String nickName) throws Exception {
		
		serv.addArticle(title, type_item, type_article, contents, place,nickName);
		
		return findItem(model,null,null,null,null);
	}
	
	@RequestMapping(value="deleteitem", method=RequestMethod.GET)
	public String deleteItem(Model model,@RequestParam(value="seq") int seq, HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.isNew()){
			//TODO :: JSON 실패 응답
		}
		MemberDTO mdto = (MemberDTO)session.getAttribute("user");
		ArticleDTO adto = serv.getArticle(seq);
		
		if(mdto.getNICKNAME().equals(adto.getNICKNAME())) {
			serv.deleteArticle(seq);
		}
		
		return "board";
	}
	
	@RequestMapping(value="deletereply", method=RequestMethod.GET)
	public String deleteReply(Model model,@RequestParam(value="seq") int seq, @RequestParam(value="aseq") int article_seq, HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.isNew()){
			//TODO :: JSON 실패 응답
		}
		
		MemberDTO mdto = (MemberDTO)session.getAttribute("user");
		ReplyDTO rdto = serv.getAReply(seq,article_seq);
		
		if(mdto.getNICKNAME().equals(rdto.getNICKNAME())) {
			serv.deleteReply(seq,article_seq);
		}
		
		
		return "board";
	}
	
	@RequestMapping(value="additem", method=RequestMethod.GET)
	public String addItem(Model model,@RequestParam(value="seq") int seq, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		if(session.isNew()){
			//TODO :: JSON 실패 응답
		}
		
		String office = (String)session.getAttribute("office");
		try {
			if(serv.setOffice(seq, office)) {
				response.getWriter().print("{\"meesage\":true}");
			}else {
				response.getWriter().print("{\"meesage\":false}");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board";
	}
}
