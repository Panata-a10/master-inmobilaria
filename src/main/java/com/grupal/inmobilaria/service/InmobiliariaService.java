package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.IDetalle;
import com.grupal.inmobilaria.dao.IInmobilaria;
import com.grupal.inmobilaria.entities.Detalle;
import com.grupal.inmobilaria.entities.Inmobilaria;


@Service
public class InmobiliariaService implements IInmobilariaService {
	@Autowired  //inyeccion de dependencia
	private IInmobilaria dao;
	
	@Autowired  //inyeccion de dependencia
	private IDetalle daoDetalle;
	
	@Override
	@Transactional
	public void save(Inmobilaria a) {
		try {
			dao.save(a);
			for(Detalle d: a.getDetalles()) {
				d.setInmobilaria(a);
				this.daoDetalle.save(d);
			}
		}catch(Exception ex)
		{	System.out.print(ex.getMessage());
			throw ex;}
		
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
