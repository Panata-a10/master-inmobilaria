package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Detalle;

public interface IDetalleService {


	public void save(Detalle a);
	public Detalle findById(Integer id);
	public void delete(Integer id);
	public List<Detalle> findAll();
	public List<Detalle> findByInmobilaria(Integer id);
}
