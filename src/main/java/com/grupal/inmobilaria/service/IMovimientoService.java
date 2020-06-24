package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Movimiento;

public interface IMovimientoService {
	public void save(Movimiento a);
	public Movimiento findById(Integer id);
	public void delete (Integer id);
	public List<Movimiento> findAll();

}
