package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IAdministrador;
import com.grupal.inmobilaria.entities.Administrador;

@Service 
public class AdministradorService implements IAdministradorService{
	
	@Autowired  //inyeccion de dependencia
	private IAdministrador dao;
	
	@Override
	@Transactional
	public void save( Administrador a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Administrador findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Administrador> findAll() {
		
		return (List<Administrador>)dao.findAll();
	}


}
