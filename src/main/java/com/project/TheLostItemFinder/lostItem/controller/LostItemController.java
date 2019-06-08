package com.project.TheLostItemFinder.lostItem.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller
public class LostItemController {
	@Resource(name="articleDAO")
	ArticleDAOImpl dao= new ArticleDAOImpl();
	
	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@RequestMapping(value = "board", method=RequestMethod.GET)
	public String findItem(Model model, @RequestParam(value="id", required=false) Integer id) throws Exception {
		ArticleDTO dto = null;
		List<ReplyDTO> rlist = null;
		if(id!=null && (dto=serv.getArticle(id))!=null) {
			System.out.println("Having article :"+dto);
			model.addAttribute("article",dto);
			model.addAttribute("isArticle",true);
			rlist=serv.getReply(id);
			model.addAttribute("replies",rlist);
		}else {
			model.addAttribute("isArticle",false);
		}
		
		List<ArticleDTO> list=serv.getList(0, 0);
		if(list!=null) {
		model.addAttribute("list", list);
		}
		
		return "board";
	}
	
	@RequestMapping(value="items", method=RequestMethod.GET)
	public String admin(Model model, @RequestParam(value="id", required=false) Integer id) throws Exception {
		ArticleDTO dto = null;
		List<ReplyDTO> rlist = null;
		if(id!=null && (dto=serv.getArticle(id))!=null) {
			System.out.println("Having article :"+dto);
			model.addAttribute("article",dto);
			model.addAttribute("isArticle",true);
			rlist=serv.getReply(id);
			model.addAttribute("replies",rlist);
		}else {
			model.addAttribute("isArticle",false);
		}
		
		List<ArticleDTO> list=serv.getList(0, 0);
		if(list!=null) {
		model.addAttribute("list", list);
		}
		
		return "items";
	}
	
	@RequestMapping(value = "board", method=RequestMethod.POST)
	public String findItem(Model model, @RequestParam(value="id", required=true) Integer id, 
			@RequestParam(value="contents", required=true) String contents,
			@RequestParam(value="nickname", required=true) String nickname) throws Exception {
		
		System.out.println("received reply request");
		serv.addReply(id, contents, nickname);
		
		
		
		return findItem(model,id);
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
						@RequestParam("type_item") String type_item, @RequestParam("place") String place,
						@RequestParam("nickname") String nickName) throws Exception {
		
		serv.addArticle(title, type_item, contents, place,nickName);
		
		return findItem(model,null);
	}
	
	@RequestMapping(value="deleteitem", method=RequestMethod.POST)
	public String deleteItem(Model model,@RequestBody String seq) {
		seq=seq.substring(seq.indexOf("=")+1, seq.length());
		System.out.println("실행"+seq);
		//TODO : 삭제 기능 + 세션인증 필요.
		return "board";
	}
}
