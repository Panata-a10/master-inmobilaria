package com.grupal.inmobilaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.Detalle;

@Controller
@RequestMapping(value="/detalle")  
public class DetalleController {

	@GetMapping(value="/create")
	public String create (Model model) {
		
		Detalle detalle = new Detalle();
		model.addAttribute("detalle", detalle);
		return "detalle/form";
	}
}
