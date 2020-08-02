package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Anunciante;

public interface IAnuncianteService {
	
	public void save(Anunciante a);
	public Anunciante findById(Integer id);
	public void delete (Integer id);
	public List<Anunciante> findAll();

}
