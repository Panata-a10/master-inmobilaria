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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_cliente")
	private Integer idcliente;
	
	@Column(name="usuario")
	@NotEmpty
	@Size(max=15)
	private String usuario;
	
	@Column(name="operacion")
	private int operaciones;
	
	//
	public Cliente() {
		super();
	}
	
	public Cliente(int id) {
		super();
		this.idcliente = id;
	}

	//
	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
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

	//
	public List<Movimiento> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}
	
	@OneToMany(mappedBy="cliente" , fetch = FetchType.LAZY )
	private List<Movimiento> movimiento;

}
