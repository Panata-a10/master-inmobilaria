package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.Anunciante;
import com.grupal.inmobilaria.service.IAnuncianteService;

@Controller 
@RequestMapping(value = "/anunciante")
public class AnuncianteController {
	
	@Autowired
	private IAnuncianteService srvAnunciante;
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		Anunciante anunciante = new Anunciante();
		model.addAttribute("title", "Registro de nuevo anunciante");
		model.addAttribute("anunciante", anunciante); //similar VieBag
		
		return "anunciante/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Anunciante anunciante = srvAnunciante.findById(id);
		model.addAttribute("anunciante", anunciante);
		model.addAttribute("title", "Datos de " + anunciante);
		return "anunciante/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Anunciante anunciante = srvAnunciante.findById(id);
		model.addAttribute("anunciante", anunciante);
		model.addAttribute("title", "Actualizado el registro de " + anunciante);
		return "anunciante/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvAnunciante.delete(id);
		return "redirect:/anunciante/list";
	}
	
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Anunciante> anunciantes = srvAnunciante.findAll();
		model.addAttribute("anunciantes", anunciantes);
		model.addAttribute("title", "Listado de anunciantees");
		return ("anunciante/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(Anunciante anunciante,Model model) {
		srvAnunciante.save(anunciante);
		return "redirect:/anunciante/list";
	}
	


}
