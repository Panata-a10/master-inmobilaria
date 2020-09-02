package com.grupal.inmobilaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.grupal.inmobilaria.entities.Detalle;


public interface IDetalle extends CrudRepository <Detalle, Integer>{

	@Query(value="SELECT * FROM detalles WHERE fk_inmobilaria = ?1" , nativeQuery = true)
	public List<Detalle> findByInmobilaria(Integer id);
}
