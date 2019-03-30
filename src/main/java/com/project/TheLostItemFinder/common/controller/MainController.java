package com.project.TheLostItemFinder.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String toMain(Model model) {
		
		return Main(model);
	}
	
	@RequestMapping(value="/main/", method=RequestMethod.GET)
	public String Main(Model model) {
		
		return "main";
	}
	
}
