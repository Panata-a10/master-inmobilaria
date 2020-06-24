package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IEmpresa;
import com.grupal.inmobilaria.entities.Empresa;

@Service
public class EmpresaService implements IEmpresaService {
	@Autowired  //inyeccion de dependencia
	private IEmpresa dao;
	
	@Override
	@Transactional
	public void save(Empresa a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Empresa findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Empresa> findAll() {
		
		return (List<Empresa>)dao.findAll();
	}


}
