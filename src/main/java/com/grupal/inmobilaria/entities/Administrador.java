package com.grupal.inmobilaria.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="administradores")
public class Administrador extends Persona implements Serializable   {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_admin")
	private Integer idadmin;
	
	@Column(name="usuario")
	@NotEmpty
	@Size(max=15)
	private String usuario;

	//
	public Administrador() {
		super();
	}
	
	public Administrador(int id) {
		super();
		this.idadmin = id;
	}

	//
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getIdadmin() {
		return idadmin;
	}

	public void setIdadmin(Integer idadmin) {
		this.idadmin = idadmin;
	}
		
}
