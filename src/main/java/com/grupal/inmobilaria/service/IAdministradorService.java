package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Administrador;

public interface IAdministradorService {
	
	public void save(Administrador a);
	public Administrador findById(Integer id);
	public void delete (Integer id);
	public List<Administrador> findAll();

}
