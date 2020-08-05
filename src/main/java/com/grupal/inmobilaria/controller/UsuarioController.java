package com.grupal.inmobilaria.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupal.inmobilaria.entities.Empresa;
import com.grupal.inmobilaria.entities.Rol;
import com.grupal.inmobilaria.entities.Usuario;
import com.grupal.inmobilaria.service.IEmpresaService;
import com.grupal.inmobilaria.service.UsuarioService;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	/*===============Clientes registro===========================*/
	
	@GetMapping(value="/create")
	public String registro(Model model) {	
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Registro de nuevo usuario");				
		return "usuario/form";
	}
	
	
	
	
	
	@PostMapping(value="/save")
	public String save(@Validated Usuario usuario, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{	
				model.addAttribute("title", "Registro de nuevo usuario");
				model.addAttribute("error", "Error al registrar");
				return "usuario/form";
			}			
			String pass = usuario.getPassword();
			usuario.setPassword(encoder.encode(pass));			
			usuario.getRoles().add(new Rol("ROLE_USER"));
			usuario.setHabilitado(true);
			service.save(usuario);
			flash.addFlashAttribute("success", "El usuario fue agregado con éxito.");
		}
		catch(Exception ex) {
			
			flash.addFlashAttribute("error", ex.getMessage());
		}
		return "redirect:/login";	
		
		
		
	}
	
	@GetMapping(value = "/listcli")
	public String listCli(Model model) {
		List<Usuario> usuario = service.findByRoles("ROLE_USER");
		model.addAttribute("administradores", usuario);
		model.addAttribute("title", "Listado de Clientes");
		return ("usuario/listcli");
	}
	/*================================Fin registro cliente ====================================*/
	
	
	/*===============================Administradores=============================================*/
	
	@GetMapping(value="/createAdmin")
	public String registroAdmin(Model model) {	
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Registro de nuevo usuario");				
		return "usuario/formadmin";
	}
	
	
	


	@GetMapping(value = "/retrieveAdmin/{id}")
	public String retrieve( @PathVariable(value="id")Integer id, Model model) {
		
		Usuario administrador = service.findById(id);
		model.addAttribute("administrador", administrador);
		model.addAttribute("title", "Datos de " + administrador);
		return "usuario/cardadmin";
	}
	
	@GetMapping(value = "/updateAdmin/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Usuario administrador = service.findById(id);
		model.addAttribute("usuario", administrador);
		model.addAttribute("title", "Actualizado el registro de " + administrador);
		return "usuario/formadmin";
	}
	
	@GetMapping(value = "/deleteAdmin/{id}")
	public String delete(@PathVariable(value="id")Integer id,Model model) {
		service.delete(id);
		return "redirect:/usuario/list";
	}
	
	
	
	
	@PostMapping(value="/saveAdmin")
	public String saveAdmin(@Validated Usuario usuario, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{	
				model.addAttribute("title", "Registro de nuevo Administrador");
				model.addAttribute("usuario", usuario);
				return "usuario/formadmin";
			}			
			String pass = usuario.getPassword();
			usuario.setPassword(encoder.encode(pass));			
			usuario.getRoles().add(new Rol("ROLE_ADMIN"));
			usuario.setHabilitado(true);
			service.save(usuario);
			flash.addFlashAttribute("success", "El Admimistrador fue agregado con éxito.");
		}
		catch(Exception ex) {
			
			flash.addFlashAttribute("error", ex.getMessage());
		}
		return "redirect:/usuario/list";		
	} 
	
	
	
	
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Usuario> usuario = service.findByRoles("ROLE_ADMIN");
		model.addAttribute("administradores", usuario);
		model.addAttribute("title", "Listado de Administradores");
		return ("usuario/list");
	}
	
	/*====================Fin administrador ============================================*/

	@Autowired
    private IEmpresaService empresa;
	

	/*===============================Anunciante=============================================*/
	
	@GetMapping(value="/createAnun")
	public String registroAnun(Model model) {	
		
		try {

			List<Empresa> empresas = empresa.findAll();
			model.addAttribute("empresas", empresas);
			Usuario usuario = new Usuario();
			model.addAttribute("usuario", usuario);
			model.addAttribute("title", "Registro de nuevo Anunciante");
			return "usuario/formanun";
		}catch(Exception ex ) {
			
			//logger.info(""+ex.getMessage());
			System. out. println("" + ex.getMessage());
		}				
		return "usuario/listanun";
	}
	
	
	


	@GetMapping(value = "/retrieveAnun/{id}")
	public String retrieveAnun( @PathVariable(value="id")Integer id, Model model) {
		
		Usuario administrador = service.findById(id);
		model.addAttribute("administrador", administrador);
		model.addAttribute("title", "Datos de " + administrador);
		return "usuario/cardanun";
	}
	
	@GetMapping(value = "/updateAnun/{id}")
	public String updateAnun(@PathVariable(value="id")Integer id,Model model) {
		List<Empresa> empresas = empresa.findAll();
		model.addAttribute("empresas", empresas);
		Usuario administrador = service.findById(id);
		model.addAttribute("usuario", administrador);
		model.addAttribute("title", "Actualizado el registro de " + administrador);
		return "usuario/formanun";
	}
	
	@GetMapping(value = "/deleteAnun/{id}")
	public String deleteAnun(@PathVariable(value="id")Integer id,Model model) {
		service.delete(id);
		return "redirect:/usuario/listanun";
	}
	
	
	
	
	@PostMapping(value="/saveAnun")
	public String saveAnun(@Validated Usuario usuario, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{	
				model.addAttribute("title", "Registro de nuevo Anunciante");
				model.addAttribute("usuario", usuario);
				return "usuario/formanun";
			}			
			String pass = usuario.getPassword();
			usuario.setPassword(encoder.encode(pass));			
			usuario.getRoles().add(new Rol("ROLE_ANUN"));
			usuario.setHabilitado(true);
			service.save(usuario);
			flash.addFlashAttribute("success", "El Anunciante fue agregado con éxito.");
		}
		catch(Exception ex) {
			
			flash.addFlashAttribute("error", ex.getMessage());
		}
		return "redirect:/usuario/listanun";		
	} 
	
	
	
	
	@GetMapping(value = "/listanun")
	public String listanun(Model model) {
		List<Usuario> usuario = service.findByRoles("ROLE_ANUN");
		model.addAttribute("administradores", usuario);
		model.addAttribute("title", "Listado de Administradores");
		return ("usuario/listanun");
	}
	
	/*====================Fin anunciante ============================================*/


	
}
