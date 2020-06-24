package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.Operacion;
import com.grupal.inmobilaria.service.IOperacionService;

@Controller 
@RequestMapping(value = "/operacion")
public class OperacionController {
	@Autowired
	private IOperacionService srvOperacion;
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		Operacion operacion = new Operacion();
		model.addAttribute("title", "Registro de nuevo operacion");
		model.addAttribute("operacion", operacion); //similar VieBag
		
		return "operacion/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Operacion operacion = srvOperacion.findById(id);
		model.addAttribute("operacion", operacion);
		model.addAttribute("title", "Datos de " + operacion);
		return "operacion/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Operacion operacion = srvOperacion.findById(id);
		model.addAttribute("operacion", operacion);
		model.addAttribute("title", "Actualizado el registro de " + operacion);
		return "operacion/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvOperacion.delete(id);
		return "redirect:/operacion/list";
	}
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Operacion> operaciones = srvOperacion.findAll();
		model.addAttribute("operacions", operaciones);
		model.addAttribute("title", "Listado de operacions");
		return ("operacion/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(Operacion operacion,Model model) {
		srvOperacion.save(operacion);
		return "redirect:/operacion/list";
	}
	


}
