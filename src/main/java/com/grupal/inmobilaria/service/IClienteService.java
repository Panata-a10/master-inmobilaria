package com.grupal.inmobilaria.service;

import java.util.List;

import com.grupal.inmobilaria.entities.Cliente;

public interface IClienteService {

	public void save(Cliente a);
	public Cliente findById(Integer id);
	public void delete (Integer id);
	public List<Cliente> findAll();
}
