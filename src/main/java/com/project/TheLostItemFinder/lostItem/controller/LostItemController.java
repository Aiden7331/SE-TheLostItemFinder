package com.project.TheLostItemFinder.lostItem.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;

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

import com.project.TheLostItemFinder.FileBean;
import com.project.TheLostItemFinder.fUtil;
import com.project.TheLostItemFinder.lostItem.service.ArticleDAOImpl;
import com.project.TheLostItemFinder.lostItem.service.ArticleDTO;
import com.project.TheLostItemFinder.lostItem.service.ArticleService;
import com.project.TheLostItemFinder.lostItem.service.OfficeDTO;
import com.project.TheLostItemFinder.lostItem.service.OfficeService;
import com.project.TheLostItemFinder.lostItem.service.ReplyDTO;
import com.project.TheLostItemFinder.member.service.MemberDTO;

import net.sf.json.JSONObject;

@Controller
public class LostItemController {
	@Resource(name="articleDAO")
	ArticleDAOImpl dao= new ArticleDAOImpl();
	
	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@Resource(name="officeService")
	OfficeService oserv= new OfficeService();
	
	final int DEFAULT_LIMIT=10;
	final int DEFAULT_PAGE=1;
	
	@RequestMapping(value = "board", method=RequestMethod.GET)
	public String findItem(Model model, @RequestParam(value="id", required=false) Integer id, 
			@RequestParam(value="searchType",required=false) String searchType,
			@RequestParam(value="search",required=false) String search,
			@RequestParam(value="limit", required=false) Integer limit,
			@RequestParam(value="page",required=false) Integer page) throws Exception {
		
		ArticleDTO dto = null;
		List<ReplyDTO> rlist = null;
		/*게시물 출력*/
		if(id!=null && (dto=serv.getArticle(id))!=null) {
			model.addAttribute("article",dto);
			model.addAttribute("isArticle",true);
			rlist=serv.getReply(id);
			model.addAttribute("replies",rlist);
			if(dto.getHOLD().equals("HOLD")||dto.getHOLD().equals("GIVEBACK")||dto.getHOLD().equals("DISCARD")) {
				if(dto.getOFFICE_SEQ()!=null){
					OfficeDTO odto = oserv.getOneOffice(Integer.parseInt(dto.getOFFICE_SEQ()));
					model.addAttribute("infoOffice",odto);
				}
			}
			System.out.println("LostItemController findItem : "+dto.getHOLD()+"/");
		}else {
			model.addAttribute("isArticle",false);
		}
		List<ArticleDTO> list = null;
		
		/*게시판 목록 출력*/
		if(limit==null) {
			limit = DEFAULT_LIMIT;
		}
		if(page == null) {
			page = DEFAULT_PAGE;
		}
		model.addAttribute("limit",limit);
		
		if(searchType==null) {
			list = serv.getList(page, limit);
		}else {
			list = serv.getList(page, limit, searchType, search);	
		}
		
		if(list!=null) {
			model.addAttribute("page", page);
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
			@RequestParam(value="limit", required=false) Integer limit,
			@RequestParam(value="page",required=false) Integer page) throws Exception {
		
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
			limit = DEFAULT_LIMIT;
		}
		if(page == null) {
			page = DEFAULT_PAGE;
		}
		model.addAttribute("limit",limit);
		if(searchType==null) {
			list = serv.getList(page, limit);
		}else {
			list = serv.getList(page, 0, searchType, search);	
		}
		
		if(list!=null) {
			model.addAttribute("page", page);
			model.addAttribute("list", list);
		}else {
			return "400_page";
		}
		
		return "board";
	}
	
	@RequestMapping(value = "upload", method=RequestMethod.GET)
	public String write(Model model) {
		
		
		return "upload";
	}
	/*
	 * 기능: 파일 업로드
	 * 한글 파일, 공백문자가 입력될 경우 fUtil클래스 PathEncoding함수로 utf8로 인코딩 후 문자열 반환.
	 * 
	 */
	@RequestMapping(value="file_upload",method=RequestMethod.POST)
	public String procFileUpload(FileBean fileBean, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root_path = session.getServletContext().getRealPath("/"); //웹 서비스 ROOT경로
		String attach_path = "resources/files/attach/";
		
		MultipartFile upload = fileBean.getUpload();
		String filename="";
		String CKEditorFuncNum="";
		if(upload!=null) {
			try {
				filename = fUtil.PathEncoding(filename);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			
			filename=upload.getOriginalFilename();
			fileBean.setFilename(filename);
			CKEditorFuncNum = fileBean.getCKEditorFuncNum();
			try {
				File file = new File(root_path+attach_path+filename);
				upload.transferTo(file);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		String file_path="/TheLostItemFinder/"+attach_path + filename;
		model.addAttribute("file_path",file_path);
		model.addAttribute("CKEditorFuncNum",CKEditorFuncNum);
		
		return "upImages/fileupload";
	}
	
	@RequestMapping(value = "upload", method=RequestMethod.POST)
	public String write(Model model, @RequestParam("title") String title, @RequestParam("contents") String contents,
						@RequestParam("date_lost") String date_lost,
						@RequestParam("type_item") String type_item, @RequestParam("type_article") String type_article,
						@RequestParam("place") String place, @RequestParam("nickname") String nickName,
						@RequestParam(value="image",required=false) String image) throws Exception {
		if(image==null) {
			image= "/TheLostItemFinder/site-image/main_image.png";
		}
		serv.addArticle(title, type_item, type_article, contents, place, nickName, date_lost, image);
		
		return "relocation";
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
	/*
	 * 기능 : 뎃글 삭제
	 * 
	 */
	@RequestMapping(value="deletereply", method=RequestMethod.GET)
	public void deleteReply(Model model, @RequestParam(value="seq") String seq, @RequestParam(value="aseq") String aseq, HttpServletRequest request
			,HttpServletResponse response){
		HttpSession session=request.getSession();
		if(session.isNew()){
			//TODO :: JSON 실패 응답
		}
		
		MemberDTO mdto = (MemberDTO)session.getAttribute("user");
		ReplyDTO rdto = serv.getAReply(Integer.parseInt(seq), Integer.parseInt(aseq));
		if(mdto.getNICKNAME().equals(rdto.getNICKNAME())) {
			System.out.println("deletereply: execution deleteReply at serv object");
			serv.deleteReply(Integer.parseInt(seq), Integer.parseInt(aseq));
			//response.getWriter().write("{'message':'true'}");
		}
		
		
		return ;
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
				response.getWriter().print("{\"message\":true}");
			}else {
				response.getWriter().print("{\"message\":false}");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board";
	}
	
	
}

class JSONreply{
	int seq;
	int aseq;
}
