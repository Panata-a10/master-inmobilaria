package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Provincia;


public interface IProvinciaService {

	public void save(Provincia a);
	public Provincia findById(Integer id);
	public void delete (Integer id);
	public List<Provincia> findAll();
}
