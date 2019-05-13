package com.project.TheLostItemFinder.lostItem.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TheLostItemFinder.lostItem.service.ArticleDAOImpl;
import com.project.TheLostItemFinder.lostItem.service.ArticleDTO;
import com.project.TheLostItemFinder.lostItem.service.ArticleService;

@Controller
public class LostItemController {
	@Resource(name="articleDAO")
	ArticleDAOImpl dao= new ArticleDAOImpl();
	
	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@RequestMapping(value = "board", method=RequestMethod.GET)
	public String findItem(Model model, @RequestParam(value="id", required=false) Integer id) throws Exception {
		ArticleDTO dto=null;
		if(id!=null && (dto=serv.getArticle(id))!=null) {
			System.out.println("Having article :"+dto);
			model.addAttribute("article",dto);
			model.addAttribute("isArticle",true);
		}else {
			model.addAttribute("isArticle",false);
		}
		
		List<ArticleDTO> list=(List) dao.selectList();
		if(list!=null) {
		model.addAttribute("list", list);
		}
		
		return "board";
	}
	
	@RequestMapping(value = "board", method=RequestMethod.POST)
	public String findItem(Model model, @RequestParam(value="id", required=true) Integer id, 
			@RequestParam(value="contents", required=true) String contents,
			@RequestParam(value="writer", required=true) String writer) throws Exception {
		
		serv.addReply(id, contents, writer);
		
		
		
		return findItem(model,id);
	}
	
	@RequestMapping(value = "upload", method=RequestMethod.GET)
	public String write(Model model) {
		
		
		return "upload";
	}
	
	@RequestMapping(value = "upload", method=RequestMethod.POST)
	public String write(Model model, @RequestParam("title") String title, @RequestParam("contents") String contents,
						@RequestParam("type_item") String type_item, @RequestParam("place") String place) throws Exception {
		serv.addArticle(title, type_item, contents, place);
		
		return findItem(model,null);
	}
}
