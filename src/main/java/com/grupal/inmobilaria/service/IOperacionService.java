package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Operacion;

public interface IOperacionService {
	public void save(Operacion a);
	public Operacion findById(Integer id);
	public void delete (Integer id);
	public List<Operacion> findAll();

}
