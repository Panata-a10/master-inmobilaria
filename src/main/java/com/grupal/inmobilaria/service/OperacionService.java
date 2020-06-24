package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IOperacion;
import com.grupal.inmobilaria.entities.Operacion;

@Service
public class OperacionService implements IOperacionService {
	@Autowired  //inyeccion de dependencia
	private IOperacion dao;
	
	@Override
	@Transactional
	public void save(Operacion a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Operacion findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Operacion> findAll() {
		
		return (List<Operacion>)dao.findAll();
	}


}
