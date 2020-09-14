package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IProvincia;
import com.grupal.inmobilaria.entities.Provincia;

@Service
public class ProvinciaService implements IProvinciaService {

	@Autowired 
	private IProvincia dao;

	@Override
	@Transactional
	public void save(Provincia a) {
		
		dao.save(a);
	}

	@Override
	@Transactional
	public Provincia findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Provincia> findAll() {
	
		return (List<Provincia>) dao.findAll();
	} 
	
}
