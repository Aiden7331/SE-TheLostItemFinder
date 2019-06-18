package com.project.TheLostItemFinder.common.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.TheLostItemFinder.lostItem.service.ArticleDTO;
import com.project.TheLostItemFinder.lostItem.service.ArticleService;


@Controller
public class MainController {
	@Resource(name="articleService")
	ArticleService serv= new ArticleService();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String toMain(Model model) {
		
		return Main(model);
	}
	
	@RequestMapping(value="/main/", method=RequestMethod.GET)
	public String Main(Model model) {
		List<ArticleDTO> list=serv.getThumbnail();
		model.addAttribute("list",list);
		return "main";
	}
	
}
