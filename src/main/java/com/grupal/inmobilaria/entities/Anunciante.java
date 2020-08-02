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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="anunciantes")
public class Anunciante extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_anunciante")
	private Integer idanunciante;
	
	@Column(name="usuario")
	@NotEmpty
	@Size(max=15)
	private String usuario;
	
	@Column(name="calificacion")
	//@NotEmpty
	//@Size(max=10)
	private int calificacion ;
	
	//
	public Anunciante() {
		super();
	}
	
	public Anunciante(int id) {
		super();
		this.idanunciante = id;
	}
	
	//
	public Integer getIdanunciante() {
		return idanunciante;
	}

	public void setIdanunciante(Integer idanunciante) {
		this.idanunciante = idanunciante;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	//
	public List<Inmobilaria> getInmobilaria() {
		return inmobilaria;
	}

	public void setInmobilaria(List<Inmobilaria> inmobilaria) {
		this.inmobilaria = inmobilaria;
	}
	
	
	
	@JoinColumn(name ="id_empresa" , referencedColumnName="pk_empresa")
	@ManyToOne
	private Empresa empresa;
	
	@OneToMany(mappedBy="anunciante" , fetch = FetchType.LAZY )
	private List<Inmobilaria> inmobilaria;
	
}
