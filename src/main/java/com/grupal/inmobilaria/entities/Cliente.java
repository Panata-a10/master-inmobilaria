package com.grupal.inmobilaria.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="usuario")
	private String usuario;
	@Column(name="operacion")
	private int operaciones;
	
	@OneToMany(mappedBy="cliente" , fetch = FetchType.LAZY )
	private List<Movimiento> movimiento;

	public Cliente() {
		super();
	}
	
	public Cliente(int id) {
		super();
		this.setIdpersona(id);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(int operaciones) {
		this.operaciones = operaciones;
	}

	public List<Movimiento> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}
	
	
	
	
	

}
