package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.Inmobilaria;
import com.grupal.inmobilaria.service.IInmobilariaService;

@Controller 
@RequestMapping(value = "/inmobilaria")

public class InmobilariaController {
	
	@Autowired
	private IInmobilariaService srvInmobilaria;
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		Inmobilaria inmobilaria = new Inmobilaria();
		model.addAttribute("title", "Registro de nueva Inmobiliaria");
		model.addAttribute("inmobilaria", inmobilaria); //similar VieBag
		
		return "inmobilaria/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Inmobilaria inmobilaria = srvInmobilaria.findById(id);
		model.addAttribute("inmobilaria", inmobilaria);
		model.addAttribute("title", "Datos de " + inmobilaria);
		return "inmobilaria/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Inmobilaria inmobilaria = srvInmobilaria.findById(id);
		model.addAttribute("inmobilaria", inmobilaria);
		model.addAttribute("title", "Actualizado el registro de " + inmobilaria);
		return "inmobilaria/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvInmobilaria.delete(id);
		return "redirect:/inmobilaria/list";
	}
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Inmobilaria> inmobilarias = srvInmobilaria.findAll();
		model.addAttribute("inmobilarias", inmobilarias);
		model.addAttribute("title", "Listado de inmobilarias");
		return ("inmobilaria/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(Inmobilaria inmobilaria,Model model) {
		srvInmobilaria.save(inmobilaria);
		return "redirect:/inmobilaria/list";
	}
	



}
