package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Inmobilaria;


public interface IInmobilariaService {
	
	public void save(Inmobilaria a);
	public Inmobilaria findById(Integer id);
	public void delete (Integer id);
	public List<Inmobilaria> findAll();
	public List<Inmobilaria> findUsuario(Integer id);

}
