package com.grupal.inmobilaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.grupal.inmobilaria.entities.Inmobilaria;


public interface IInmobilaria extends CrudRepository<Inmobilaria, Integer >{


	@Query("SELECT I FROM Inmobilaria I WHERE I.anunciante.idusuario = :id")	
	public List<Inmobilaria> findByUsuario(Integer id);
}
