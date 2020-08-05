package com.grupal.inmobilaria.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupal.inmobilaria.entities.Inmobilaria;
import com.grupal.inmobilaria.entities.Operacion;
import com.grupal.inmobilaria.entities.TipoInmobilaria;
import com.grupal.inmobilaria.entities.Usuario;
import com.grupal.inmobilaria.service.IInmobilariaService;
import com.grupal.inmobilaria.service.IOperacionService;
import com.grupal.inmobilaria.service.ITipoInmobilariaService;
import com.grupal.inmobilaria.service.UsuarioService;

@Controller 
@RequestMapping(value = "/inmobilaria")

public class InmobilariaController {
	
	@Autowired
	private IInmobilariaService srvInmobilaria;
	
	@Autowired 
	private ITipoInmobilariaService srvTipoInmo;
	

	@Autowired 
	private IOperacionService  srvOperacion;
	

	@Autowired 
	private UsuarioService  srvUsuario;
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	@GetMapping(value = "/create")
	public String create(Model model) {
		Inmobilaria inmobilaria = new Inmobilaria();
		model.addAttribute("title", "Registro de nueva Inmobiliaria");
		model.addAttribute("inmobilaria", inmobilaria); //similar VieBag
		
		List<TipoInmobilaria> tipoIs = srvTipoInmo.findAll();
		model.addAttribute("tipo_inmobilarias", tipoIs);
		

		List<Operacion> operacion = srvOperacion.findAll() ;
		model.addAttribute("operaciones", operacion);
		
		return "inmobilaria/form";//la ubicacion de la vista
	}
	
	
	@GetMapping(value = "/retrieve/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Inmobilaria inmobilaria = srvInmobilaria.findById(id);
		model.addAttribute("inmobilaria", inmobilaria);
		model.addAttribute("title", "Datos de " + inmobilaria.getNombre());
		return "inmobilaria/card";
	}
	
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		
		
		Inmobilaria inmobilaria = srvInmobilaria.findById(id);
		model.addAttribute("inmobilaria", inmobilaria);
		
		List<TipoInmobilaria> tipoIs = srvTipoInmo.findAll();
		model.addAttribute("tipo_inmobilarias", tipoIs);
		

		List<Operacion> operacion = srvOperacion.findAll() ;
		model.addAttribute("operaciones", operacion);
		
		
		model.addAttribute("title", "Actualizado el registro de " + inmobilaria.getNombre());
		return "inmobilaria/form";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvInmobilaria.delete(id);
		return "redirect:/inmobilaria/list";
	}
	
	
	@GetMapping(value = "/list")
	public String list(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
		String nombre;
		if (principal instanceof UserDetails) {
			nombre = ((UserDetails)principal).getUsername();
		} else {
		   nombre = principal.toString();
		}
		
		Usuario usuario = srvUsuario.findByNombre(nombre);
		
		
		List<Inmobilaria> inmobilarias = srvInmobilaria.findUsuario(usuario.getIdusuario());
		model.addAttribute("inmobilarias", inmobilarias);
		model.addAttribute("title", "Listado de inmobilarias");
		return ("inmobilaria/list");
	}
	
	
	
	@PostMapping(value = "/save")
	public String save(@Validated Inmobilaria inmobilaria,BindingResult result,Model model
			,@RequestParam("photo") MultipartFile image,
			SessionStatus status, RedirectAttributes flash) {
		
		try {
			String message = "Registro agregado correctamente";
			String titulo = "Registro de nueva Inmobiliaria";
			
			if(inmobilaria.getIdInmobilaria() != null) {
				message = "Registro actualizado correctamente";
				titulo = "Actualizando el registro de " + inmobilaria.getNombre();
			}
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);
				model.addAttribute("error", "Error al registrar");
				return "inmobilaria/form";
			}
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "inmobilaria/form";				
			}
			//VALIDAR IMAGEN --> inicio
			if (!image.isEmpty()) {
				Path dir = Paths.get("src//main//resources//static//inmuebles");
				String rootPath = dir.toFile().getAbsolutePath();
				try {
					byte[] bytes = image.getBytes();
					Path rutaCompleta = Paths.get(rootPath + "//" + image.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
					inmobilaria.setImagen(image.getOriginalFilename());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}//fin
		
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String nombre;
			if (principal instanceof UserDetails) {
				nombre = ((UserDetails)principal).getUsername();
			} else {
			   nombre = principal.toString();
			}
			
			Usuario usuario = srvUsuario.findByNombre( nombre);
			inmobilaria.setAnunciante(usuario);
			srvInmobilaria.save(inmobilaria);
			status.setComplete();
			flash.addFlashAttribute("success", message);
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}
		return "redirect:/inmobilaria/list";
		
	}
	
	
	
	/* =================Vista de todos los inmuebles ====================================*/
	
	@GetMapping(value = "/listall")
	public String listall(Model model) {
		List<Inmobilaria> inmobilarias = srvInmobilaria.findAll();
		model.addAttribute("inmobilarias", inmobilarias);
		model.addAttribute("title", "Listado de inmobilarias");
		return ("inmobilaria/listall");
	}

	
	@RequestMapping(value = "/myusername", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
	    return principal.getName();
	}


}
