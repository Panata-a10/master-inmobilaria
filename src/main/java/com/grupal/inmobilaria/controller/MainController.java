package com.grupal.inmobilaria.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupal.inmobilaria.entities.Empresa;
import com.grupal.inmobilaria.entities.Rol;
import com.grupal.inmobilaria.entities.Usuario;

@Controller
@RequestMapping(value="/")
public class MainController {


	@GetMapping(value= {"/","/index.html"})
	public String index(Model model) {
		//El retorno indica la vista que se va a desplegar
		//se coloca únicamente el nombre sin la extension
		return "index";
	}
		
	@GetMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "El usuario ya tiene una sesión activa.");
			return "redirect:/";
		}		
		if(error != null) {
			model.addAttribute("error", "Usuario o contraseña incorrectas");
		}				
		return "login";
	}
	
/*===============================LOGIN=============================================*/
	
/*====================Fin anunciante ============================================*/

}
