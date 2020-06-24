package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IPago;
import com.grupal.inmobilaria.entities.Pago;

@Service
public class PagoService implements IPagoService {
	@Autowired  //inyeccion de dependencia
	private IPago dao;
	
	@Override
	@Transactional
	public void save(Pago a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Pago findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Pago> findAll() {
		
		return (List<Pago>)dao.findAll();
	}


}
