package com.grupal.inmobilaria.controller;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupal.inmobilaria.entities.Movimiento;
//import com.grupal.inmobilaria.service.IMovimientoService;

@Controller 
@RequestMapping(value = "/movimiento")
public class MovimientoController {
	
	/*@Autowired
	private IMovimientoService srvMovimiento;*/
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		Movimiento movimiento = new Movimiento();
		model.addAttribute("title", "Registro de nuevo movimiento");
		model.addAttribute("movimiento", movimiento); //similar VieBag
		
		return "movimiento/form";//la ubicacion de la vista
	}
	
	/*
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Movimiento movimiento = srvMovimiento.findById(id);
		model.addAttribute("movimiento", movimiento);
		model.addAttribute("title", "Datos de " + movimiento);
		return "movimiento/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Movimiento movimiento = srvMovimiento.findById(id);
		model.addAttribute("movimiento", movimiento);
		model.addAttribute("title", "Actualizado el registro de " + movimiento);
		return "movimiento/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvMovimiento.delete(id);
		return "redirect:/movimiento/list";
	}
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Movimiento> movimientos = srvMovimiento.findAll();
		model.addAttribute("movimientos", movimientos);
		model.addAttribute("title", "Listado de movimientos");
		return ("movimiento/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(Movimiento movimiento,Model model) {
		srvMovimiento.save(movimiento);
		return "redirect:/movimiento/list";
	}
*/

}
