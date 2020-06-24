package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IAnunciante;
import com.grupal.inmobilaria.entities.Anunciante;

@Service 
public class AnuncianteService implements IAnuncianteService {
	@Autowired  //inyeccion de dependencia
	private IAnunciante dao;
	
	@Override
	@Transactional
	public void save(Anunciante a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Anunciante findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Anunciante> findAll() {
		
		return (List<Anunciante>)dao.findAll();
	}

}
