package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Empresa;

public interface IEmpresaService {
	
	
	public void save(Empresa a);
	public Empresa findById(Integer id);
	public void delete (Integer id);
	public List<Empresa> findAll();
}
