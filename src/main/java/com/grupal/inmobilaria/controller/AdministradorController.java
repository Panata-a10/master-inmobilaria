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

import com.grupal.inmobilaria.entities.Administrador;
import com.grupal.inmobilaria.service.IAdministradorService;

@Controller 
@SessionAttributes("administrador")
@RequestMapping(value = "/administrador")//todas las peticiones q getiono este controller
public class AdministradorController {
	
	@Autowired
	private IAdministradorService srvAdministrador;

	@GetMapping(value = "/create")
	public String create(Model model) {
		Administrador administrador = new Administrador();
		model.addAttribute("title", "Registro de nuevo administrador");
		model.addAttribute("administrador", administrador); //similar VieBag
		
		return "administrador/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Administrador administrador = srvAdministrador.findById(id);
		model.addAttribute("administrador", administrador);
		model.addAttribute("title", "Datos de " + administrador);
		return "administrador/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Administrador administrador = srvAdministrador.findById(id);
		model.addAttribute("administrador", administrador);
		model.addAttribute("title", "Actualizado el registro de " + administrador);
		return "administrador/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvAdministrador.delete(id);
		return "redirect:/administrador/list";
	}
	
	
	
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Administrador> administradores = srvAdministrador.findAll();
		model.addAttribute("administradores", administradores);
		model.addAttribute("title", "Listado de Administradores");
		return ("administrador/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(@Validated Administrador administrador,BindingResult result,Model model,
			SessionStatus status, RedirectAttributes flash) {
		try {
			String message = "Registro agregado correctamente";
			String titulo = "Registro de nuevo Administrador";
			
			if(administrador.getIdadmin() != null) {
				message = "Registro actualizado correctamente";
				titulo = "Actualizando el registro de " + administrador;
			}
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);
				model.addAttribute("error", "Error al registrar");
				return "administrador/form";
			}
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "administrador/form";				
			}
			srvAdministrador.save(administrador);
			status.setComplete();
			flash.addFlashAttribute("success", message);
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}
		return "redirect:/administrador/list";
	}
}
