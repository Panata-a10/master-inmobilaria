package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.TipoInmobilaria;

public interface ITipoInmobilariaService {
	public void save(TipoInmobilaria a);
	public TipoInmobilaria findById(Integer id);
	public void delete (Integer id);
	public List<TipoInmobilaria> findAll();

}
