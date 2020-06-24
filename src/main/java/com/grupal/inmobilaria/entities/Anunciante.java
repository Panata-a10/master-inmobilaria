package com.grupal.inmobilaria.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="anunciantes")
public class Anunciante extends Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="calificacion")
	private int calificacion ;
	
	@JoinColumn(name ="id_empresa" , referencedColumnName="id_empresa")
	@ManyToOne
	private Empresa empresa;
	
	@OneToMany(mappedBy="anunciante" , fetch = FetchType.LAZY )
	private List<Inmobilaria> inmobilaria;

	public Anunciante() {
		super();
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Anunciante(int id) {
		super();
		this.setIdpersona(id);
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

	public List<Inmobilaria> getInmobilaria() {
		return inmobilaria;
	}

	public void setInmobilaria(List<Inmobilaria> inmobilaria) {
		this.inmobilaria = inmobilaria;
	}
	
}
