package com.grupal.inmobilaria.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_provincia")
	private Integer idProvincia;
	
	


	@Column(name="nombre")
	private String nombre;
	

	
	
	public Provincia(Integer idProvincia) {
		super();
		this.idProvincia = idProvincia;
	}


	public Provincia() {
		super();
	}


	public Integer getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	
	

}
