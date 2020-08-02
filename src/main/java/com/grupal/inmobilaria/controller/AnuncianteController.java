package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupal.inmobilaria.entities.Anunciante;
import com.grupal.inmobilaria.service.IAnuncianteService;

@Controller 
@SessionAttributes("anunciante")
@RequestMapping(value = "/anunciante")
public class AnuncianteController {
	
	@Autowired
	private IAnuncianteService srvAnunciante;
	
	@GetMapping(value = "/create")
	public String create(Model model) {
		Anunciante anunciante = new Anunciante();
		model.addAttribute("title", "Registro de nuevo anunciante");
		model.addAttribute("anunciante", anunciante);
		
		return "anunciante/form";
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
	public String save(@Validated Anunciante anunciante, BindingResult result,Model model,
			SessionStatus status, RedirectAttributes flash) {
		try {
			String message = "Registro agregado correctamente";
			String titulo = "Registro de nuevo Anunciante";
			
			if(anunciante.getIdanunciante() != null) {
				message = "Registro actualizado correctamente";
				titulo = "Actualizando el registro de " + anunciante;
			}
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);
				model.addAttribute("error", "Error al registrar");
				return "anunciante/form";
			}
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "anunciante/form";				
			}
			srvAnunciante.save(anunciante);
			status.setComplete();
			flash.addFlashAttribute("success", message);
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}
		return "redirect:/anunciante/list";
	}
}
