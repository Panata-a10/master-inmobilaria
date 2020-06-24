package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.Empresa;
import com.grupal.inmobilaria.service.IEmpresaService;

@Controller 
@RequestMapping(value = "/empresa")
public class EmpresaController {
	@Autowired
	private IEmpresaService srvEmpresa;
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		Empresa empresa = new Empresa();
		model.addAttribute("title", "Registro de nuevo empresa");
		model.addAttribute("empresa", empresa); //similar VieBag
		
		return "empresa/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Empresa empresa = srvEmpresa.findById(id);
		model.addAttribute("empresa", empresa);
		model.addAttribute("title", "Datos de " + empresa);
		return "empresa/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Empresa empresa = srvEmpresa.findById(id);
		model.addAttribute("empresa", empresa);
		model.addAttribute("title", "Actualizado el registro de " + empresa);
		return "empresa/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvEmpresa.delete(id);
		return "redirect:/empresa/list";
	}
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Empresa> empresas = srvEmpresa.findAll();
		model.addAttribute("empresas", empresas);
		model.addAttribute("title", "Listado de empresas");
		return ("empresa/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(Empresa empresa,Model model) {
		srvEmpresa.save(empresa);
		return "redirect:/empresa/list";
	}
	


}
