package com.grupal.inmobilaria.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupal.inmobilaria.dao.IMovimiento;
import com.grupal.inmobilaria.entities.Detalle;
import com.grupal.inmobilaria.entities.Inmobilaria;
import com.grupal.inmobilaria.entities.Movimiento;
import com.grupal.inmobilaria.entities.Operacion;
import com.grupal.inmobilaria.entities.Rol;
import com.grupal.inmobilaria.entities.TipoInmobilaria;
import com.grupal.inmobilaria.entities.Usuario;
import com.grupal.inmobilaria.service.IDetalleService;
import com.grupal.inmobilaria.service.IInmobilariaService;
import com.grupal.inmobilaria.service.IOperacionService;
import com.grupal.inmobilaria.service.ITipoInmobilariaService;
import com.grupal.inmobilaria.service.UsuarioService;



@Controller 
@SessionAttributes("inmobilaria")
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
	
	
	
	@Autowired
	private IDetalleService srvDetalle;
	
	@Autowired
	private IMovimiento srvMovimiento;
	
	
	//Cada metodo en el controlador gestionaun peticion al backend
	//a travez de una URL(puede ser escrita en el navegador)
	// 2 HuperLink
	//3 Puede ser un action Form
	
	
	@GetMapping(value = "/create")
	public String create(Model model) {
		Inmobilaria inmobilaria = new Inmobilaria();
		
		inmobilaria.setDetalles(new ArrayList<Detalle>());
		
		model.addAttribute("title", "Registro de nueva Inmobiliaria");
		
		model.addAttribute("inmobilaria", inmobilaria); //similar VieBag
		
		List<TipoInmobilaria> tipoIs = srvTipoInmo.findAll();
		model.addAttribute("tipo_inmobilarias", tipoIs);
		

		List<Operacion> operacion = srvOperacion.findAll() ;
		model.addAttribute("operaciones", operacion);
		
		return "inmobilaria/form";//la ubicacion de la vista
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		srvInmobilaria.delete(id);
		return "redirect:/inmobilaria/list";
	}

	
	
	@PostMapping(value = "/save")
	public String save(@Validated Inmobilaria inmobilaria,BindingResult result,Model model
			,@RequestParam("photo") MultipartFile image,
			SessionStatus status, RedirectAttributes flash,  HttpSession session) {
		
		try {
			String message = "Registro agregado correctamente";
			String titulo = "Registro de nueva Inmobiliaria";
			
			if(inmobilaria.getIdInmobilaria() != null) {
				message = "Registro actualizado correctamente";
				titulo = "Actualizando el registro de " + inmobilaria.getNombre();
			}
			if(result.hasErrors()) {
				titulo = "Error al registrar Inmobilaria";
				model.addAttribute("title", titulo);
				model.addAttribute("error", "Intentalo otra vez");
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
			Inmobilaria inmobilariaSession = (Inmobilaria) session.getAttribute("inmobilaria");
			
			inmobilaria.setDetalles(inmobilariaSession.getDetalles());
			
			/*
			for(Detalle d:  ) {
				inmobilaria.getDetalles().add(d);
			}
			*/
			
			srvInmobilaria.save(inmobilaria);
			status.setComplete();
			flash.addFlashAttribute("success", message);
			
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
			System.out.print(ex.getMessage());
			
		}
		return "redirect:/inmobilaria/list";
		
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
	
	
	
	
	@PostMapping(value="/add")
	public @ResponseBody Object add(@RequestBody @Valid Detalle detalle, 
			BindingResult result, Model model, HttpSession session) {
		try {
			Inmobilaria inmobilaria = (Inmobilaria) session.getAttribute("inmobilaria");
			inmobilaria.getDetalles().add(detalle);
			return detalle;
			
		}catch (Exception ex) {
			return ex;
		}
		
		
	}
	
	@GetMapping(value= "/details")
	public String details (Model model, HttpSession session) {
		Inmobilaria inmobilaria = (Inmobilaria) session.getAttribute("inmobilaria");
		model.addAttribute("detalles", inmobilaria.getDetalles());
		//model.addAttribute("title", "Listado de los detalles");
		return "detalle/list";
	}
	
	@GetMapping(value = "/movimiento/{id}")
	public String movimiento( @PathVariable(value="id")Integer id, Model model, RedirectAttributes flash) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
		String nombre;
		if (principal instanceof UserDetails) {
			nombre = ((UserDetails)principal).getUsername();
		} else {
		   nombre = principal.toString();
		}
		
		Usuario usuario = srvUsuario.findByNombre(nombre);
		
		Inmobilaria inmobilaria = srvInmobilaria.findById(id);
		
		Movimiento mov = new Movimiento();
		mov.setInmobilaria(inmobilaria);
		mov.setCliente(usuario);
		
		flash.addFlashAttribute("success", "El anunciante le enviara un mensaje a su email" );
		srvMovimiento.save(mov);
		
		return "redirect:/inmobilaria/listall";
	}
	
	
	
	

	
	/* =================Vista de todos los inmuebles Cliente====================================*/
	
	@GetMapping(value = "/listall")
	public String listall(Model model) {
		List<Inmobilaria> inmobilarias = srvInmobilaria.findAll();
		model.addAttribute("inmobilarias", inmobilarias);
		model.addAttribute("title", "Listado de inmobilarias");
		return ("inmobilaria/listall");
	}
	
	
	@GetMapping(value = "/product/{id}")
	public String productCard( @PathVariable(value="id")Integer id, Model model) {
		
		Inmobilaria inmobilaria = srvInmobilaria.findById(id);
		List<Detalle> detalles = srvDetalle.findByInmobilaria(inmobilaria.getIdInmobilaria());
		if(detalles != null)
			model.addAttribute("detalles", detalles);
		
		model.addAttribute("inmobilaria", inmobilaria);	
		model.addAttribute("title", inmobilaria.getNombre());
		return "inmobilaria/product";
	}
	
	
	
	

	
	
/*========================Vista de los usuario=========*/
	@GetMapping(value = "/vista")
	public String vista() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
		String nombre;
		if (principal instanceof UserDetails) {
			nombre = ((UserDetails)principal).getUsername();
		} else {
		   nombre = principal.toString();
		}
		
		Usuario usuario = srvUsuario.findByNombre(nombre);
		
		Rol rol = srvUsuario.findRol(usuario.getIdusuario());
		if(rol.getNombre() == "ROLE_ADMIN") {
			return "redirect:/usuario/list";
		}
		if(rol.getNombre() == "ROLE_USER") {
			return "redirect:/inmobilaria/listall";
		}
		if(rol.getNombre() == "ROLE_ANUN") {
			return "redirect:/inmobilaria/list";
		}
		
		return ("inmobilaria/listall");
	}



}
