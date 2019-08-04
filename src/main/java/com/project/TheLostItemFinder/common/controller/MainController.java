package com.project.TheLostItemFinder.common.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TheLostItemFinder.lostItem.service.ArticleDTO;
import com.project.TheLostItemFinder.lostItem.service.ArticleService;


@Controller
public class MainController {
	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String toMain(Model model,@RequestParam(value="page", required=false) Integer page) {
		return Main(model, page);
	}
	
	@RequestMapping(value="/main/", method=RequestMethod.GET)
	public String Main(Model model, @RequestParam(value="page", required=false) Integer page) {
		int limit=6, count = 0, totalPage;
		if(page == null) {
			page = 1;
		}
		System.out.println("MainController : "+page);
		List<ArticleDTO> list=serv.getThumbnail(limit, page, 60);
		totalPage= serv.getTotalMainPage(limit);
		count=serv.todayCount();
		model.addAttribute("page",page);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("count",count);
		model.addAttribute("list",list);
		return "main";
	}
	
}
