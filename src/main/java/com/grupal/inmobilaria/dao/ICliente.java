package com.grupal.inmobilaria.dao;

import org.springframework.data.repository.CrudRepository;

import com.grupal.inmobilaria.entities.Cliente;

public interface ICliente extends CrudRepository <Cliente, Integer> {

}
