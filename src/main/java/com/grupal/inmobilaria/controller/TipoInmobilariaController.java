package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.TipoInmobilaria;
import com.grupal.inmobilaria.service.ITipoInmobilariaService;

@Controller 
@RequestMapping(value = "/tipoinmobilaria")
public class TipoInmobilariaController {
	@Autowired
	private ITipoInmobilariaService srvtipoinmobilaria;
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		TipoInmobilaria tipoinmobilaria = new TipoInmobilaria();
		model.addAttribute("title", "Registro de nuevo tipoinmobilaria");
		model.addAttribute("tipoinmobilaria", tipoinmobilaria); //similar VieBag
		
		return "tipoinmobilaria/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		TipoInmobilaria tipoinmobilaria = srvtipoinmobilaria.findById(id);
		model.addAttribute("tipoinmobilaria", tipoinmobilaria);
		model.addAttribute("title", "Datos de " + tipoinmobilaria);
		return "tipoinmobilaria/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		TipoInmobilaria tipoinmobilaria = srvtipoinmobilaria.findById(id);
		model.addAttribute("tipoinmobilaria", tipoinmobilaria);
		model.addAttribute("title", "Actualizado el registro de " + tipoinmobilaria);
		return "tipoinmobilaria/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvtipoinmobilaria.delete(id);
		return "redirect:/tipoinmobilaria/list";
	}
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<TipoInmobilaria> tipoinmobilarias = srvtipoinmobilaria.findAll();
		model.addAttribute("tipoinmobilarias", tipoinmobilarias);
		model.addAttribute("title", "Listado de tipoinmobilarias");
		return ("tipoinmobilaria/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(TipoInmobilaria tipoinmobilaria,Model model) {
		srvtipoinmobilaria.save(tipoinmobilaria);
		return "redirect:/tipoinmobilaria/list";
	}
	


}
