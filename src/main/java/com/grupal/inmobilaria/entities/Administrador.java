package com.grupal.inmobilaria.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="administradores")
public class Administrador extends Persona implements Serializable   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="usuario")
	private String usuario;

	public Administrador() {
		super();
	}
	
	public Administrador(int id) {
		super();
		this.setIdpersona(id);
	}

	
	public String getUsuario() {
		return usuario;
	}

	


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	
}
