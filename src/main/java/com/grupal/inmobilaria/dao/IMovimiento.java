package com.grupal.inmobilaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.grupal.inmobilaria.entities.Movimiento;

public interface IMovimiento extends CrudRepository<Movimiento, Integer>{

	@Query(value="SELECT * FROM movimientos WHERE id_inmobilaria = ?1",  nativeQuery = true)
	public List<Movimiento> findByInmobilaria(int id);
}
