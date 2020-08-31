package com.grupal.inmobilaria.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="detalles")
public class Detalle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_detalle")	
	private Integer iddetalle;
	
	@Column(name="descripcion")
	private String descripcion;
	
	


	@Column(name="cantidad")
	private String cantidad;
	
	@Column(name="tamano")
	private Float tamano;
	
	@JoinColumn(name="fk_inmobilaria", referencedColumnName="pk_inmobilaria")
	@ManyToOne
	private Inmobilaria inmobilaria;

	public Detalle() {
		super();
	}

	public Detalle(Integer iddetalle) {
		super();
		this.iddetalle = iddetalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getIddetalle() {
		return iddetalle;
	}

	public void setIddetalle(Integer iddetalle) {
		this.iddetalle = iddetalle;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Float getTamano() {
		return tamano;
	}

	public void setTamano(Float tamano) {
		this.tamano = tamano;
	}

	public Inmobilaria getInmobilaria() {
		return inmobilaria;
	}

	public void setInmobilaria(Inmobilaria inmobilaria) {
		this.inmobilaria = inmobilaria;
	}
	
	

	/**** TRANSIENT ***/
	
	@Transient
	private int inmobilariaid;
	
	
	public int geInmobilaraiid() {
		return inmobilariaid;
	}



	public void setInmobilaria(int id) {
		this.inmobilariaid = id;
	}

	
	
	
	

}
