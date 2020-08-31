package com.grupal.inmobilaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.grupal.inmobilaria.entities.Rol;
import com.grupal.inmobilaria.entities.Usuario;

public interface IUsuario  extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByNombre(String nombre);
	
	//Clasificacion de usuarios por roles 
	@Query("Select U from Usuario U  left join Rol R on U.idusuario = R.idrol where R.nombre = :id")
	public List<Usuario> findByRoles(String id);
	//Rol roles = new Rol();
	
	//@Query("Select R from Rol R where R.fk_usuario = :id")
	@Query("Select R from Rol R  left join Usuario U on   R.idrol = U.idusuario where U.idusuario = :id")
	public Rol FindRol(Integer id);

}
