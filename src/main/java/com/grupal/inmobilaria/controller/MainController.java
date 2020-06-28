package com.grupal.inmobilaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class MainController {

	@GetMapping(value= {"/","/index.html"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping(value="/index1")
	public String tables(Model model) {						
		return "index1";
	}
	
	@GetMapping(value="/register.html")
	public String register(Model model) {						
		return "register";
	}
	
	@GetMapping(value = "/general.html")
	public String general(Model model) {
		return "general";
	}
}
