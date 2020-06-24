package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.Pago;
import com.grupal.inmobilaria.service.IPagoService;

@Controller 
@RequestMapping(value = "/pago")
public class PagoController {
	@Autowired
	private IPagoService srvPago;
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		Pago pago = new Pago();
		model.addAttribute("title", "Registro de nuevo pago");
		model.addAttribute("pago", pago); //similar VieBag
		
		return "pago/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Pago pago = srvPago.findById(id);
		model.addAttribute("pago", pago);
		model.addAttribute("title", "Datos de " + pago);
		return "pago/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Pago pago = srvPago.findById(id);
		model.addAttribute("pago", pago);
		model.addAttribute("title", "Actualizado el registro de " + pago);
		return "pago/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvPago.delete(id);
		return "redirect:/pago/list";
	}
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Pago> pagos = srvPago.findAll();
		model.addAttribute("pagos", pagos);
		model.addAttribute("title", "Listado de pagos");
		return ("pago/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(Pago pago,Model model) {
		srvPago.save(pago);
		return "redirect:/pago/list";
	}
	

}
