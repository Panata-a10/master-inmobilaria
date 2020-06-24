package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Pago;

public interface IPagoService {
	public void save(Pago a);
	public Pago findById(Integer id);
	public void delete (Integer id);
	public List<Pago> findAll();

}
