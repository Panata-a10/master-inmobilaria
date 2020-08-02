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
@Table(name="operaciones")
public class Operacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_operacion")
	private Integer idOperacion;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy="operacion" , fetch = FetchType.LAZY )
	private List<Inmobilaria> inmobilaria;

	public Operacion() {
		super();
	}
	
	public Operacion(Integer id) {
		super();
		this.idOperacion =id;
	}


	public Integer getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Inmobilaria> getInmobilaria() {
		return inmobilaria;
	}

	public void setInmobilaria(List<Inmobilaria> inmobilaria) {
		this.inmobilaria = inmobilaria;
	}
}
