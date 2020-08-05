package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IInmobilaria;
import com.grupal.inmobilaria.entities.Inmobilaria;


@Service
public class InmobiliariaService implements IInmobilariaService {
	@Autowired  //inyeccion de dependencia
	private IInmobilaria dao;
	
	@Override
	@Transactional
	public void save(Inmobilaria a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Inmobilaria findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Inmobilaria> findAll() {
		
		return (List<Inmobilaria>)dao.findAll();
	}

	@Override
	@Transactional
	public List<Inmobilaria> findUsuario(Integer id) {

		return (List<Inmobilaria>)dao.findByUsuario(id);
	
	}

	
	

	
	


}
