package com.grupal.inmobilaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupal.inmobilaria.dao.ICliente;
import com.grupal.inmobilaria.entities.Cliente;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired  //inyeccion de dependencia
	private ICliente dao;
	
	@Override
	@Transactional
	public void save(Cliente a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Cliente findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}
 
	@Override
	@Transactional
	public List<Cliente> findAll() {
		
		return (List<Cliente>)dao.findAll();
	}

}
