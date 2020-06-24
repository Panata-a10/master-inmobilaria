package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IMovimiento;
import com.grupal.inmobilaria.entities.Movimiento;

@Service
public class MovimientoService implements IMovimientoService {
	@Autowired  //inyeccion de dependencia
	private IMovimiento dao;
	
	@Override
	@Transactional
	public void save(Movimiento a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Movimiento findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Movimiento> findAll() {
		
		return (List<Movimiento>)dao.findAll();
	}


}
