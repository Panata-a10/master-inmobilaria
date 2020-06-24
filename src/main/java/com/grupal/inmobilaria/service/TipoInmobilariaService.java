package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.ITipoInmobilaria;
import com.grupal.inmobilaria.entities.TipoInmobilaria;

@Service
public class TipoInmobilariaService implements ITipoInmobilariaService {
	@Autowired  //inyeccion de dependencia
	private ITipoInmobilaria dao;
	
	@Override
	@Transactional
	public void save(TipoInmobilaria a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public TipoInmobilaria findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<TipoInmobilaria> findAll() {
		
		return (List<TipoInmobilaria>)dao.findAll();
	}


}
