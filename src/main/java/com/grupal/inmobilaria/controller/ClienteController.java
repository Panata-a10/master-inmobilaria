package com.grupal.inmobilaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupal.inmobilaria.entities.Cliente;
import com.grupal.inmobilaria.service.IClienteService;

@Controller 
@SessionAttributes("cliente")
@RequestMapping(value = "/cliente")//todas las peticiones q getiono este controller
public class ClienteController {
	@Autowired
	private IClienteService srvCliente;

	@GetMapping(value = "/create")
	public String create(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("title", "Registro de nuevo cliente");
		model.addAttribute("cliente", cliente); //similar VieBag
		
		return "cliente/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Cliente cliente = srvCliente.findById(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("title", "Datos de " + cliente);
		return "cliente/card";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Cliente cliente = srvCliente.findById(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("title", "Actualizado el registro de " + cliente);
		return "cliente/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvCliente.delete(id);
		return "redirect:/cliente/list";
	}
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes", clientes);
		model.addAttribute("title", "Listado de clientes");
		return ("cliente/list");
	}
	
	
	
	/*@PostMapping(value = "/save")
	public String save(@Validated Cliente cliente,Model model, BindingResult result,
			SessionStatus status, RedirectAttributes flash) {
		try {
			String message = "Registro agregado correctamente";
			String titulo = "Registro de nuevo Administrador";
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);
				model.addAttribute("error", "Error al registrar");
				return "cliente/form";
			}
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "cliente/form";				
			}
			srvCliente.save(cliente);
			status.setComplete();
			flash.addFlashAttribute("success", message);
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}
		return "redirect:/cliente/list";
	}*/
	
	@PostMapping(value = "/save")
	public String save(Cliente cliente,Model model) {
		srvCliente.save(cliente);
		return "redirect:/cliente/list";
	}
	

}
