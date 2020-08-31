package com.grupal.inmobilaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupal.inmobilaria.dao.IDetalle;
import com.grupal.inmobilaria.entities.Detalle;

@Service
public class DetalleService implements IDetalleService {
	
	@Autowired 
	private IDetalle dao;
	
	@Override
	@Transactional 
	public void save (Detalle a) {	
		dao.save(a);
	}
	
	@Override 
	@Transactional 
	public Detalle findById (Integer id) {
		return dao.findById(id).get();
		
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	@Override
	@Transactional 
	public List<Detalle> findAll(){
		return (List<Detalle>) dao.findAll();
	}
	
	

}
