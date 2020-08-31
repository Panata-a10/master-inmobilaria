package com.grupal.inmobilaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IUsuario;
import com.grupal.inmobilaria.entities.Rol;
import com.grupal.inmobilaria.entities.Usuario;

@Service
public class UsuarioService  implements UserDetailsService  {
	
	@Autowired
	private IUsuario dao;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Usuario usuario = dao.findByNombre(username);		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario " + username + " no encontrado");
		}
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for(Rol rol: usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		
		if(roles.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + username + " no tiene roles asignados");
		}			
		return new User(usuario.getNombre(), usuario.getPassword(), usuario.getHabilitado(), true, true, true, roles);		
	}
	
	@Transactional
	public void save(Usuario usuario) {
		dao.save(usuario);		
	} 
	
	@Transactional	
	public List<Usuario> findAll(){		
		return (List<Usuario>) dao.findAll();
	}
	
	@Transactional	
	public Usuario findByNombre(String nombre){		
		return dao.findByNombre(nombre);
	}
	
	@Transactional	
	public Usuario findById(Integer id){		
		return dao.findById(id).get();
	}
	
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
	
	@Transactional
	public List<Usuario> findByRoles (String nombre) {
		
		return (List<Usuario>) dao.findByRoles(nombre);
	}
	
	
	@Transactional
	public Rol findRol (Integer id) {
		
		return  dao.FindRol(id);
	}
}
