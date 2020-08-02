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

@Entity
@Table(name="movimientos")
public class Movimiento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_movimimento")
	private Integer idMovimiento;
	
	
	@Column(name="recomendacion")
	private int recomendacion;
	
	//relacion con usuario
	@JoinColumn(name ="id_cliente" , referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario cliente;
	
	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@JoinColumn(name ="id_inmobilaria" , referencedColumnName="pk_inmobilaria")
	@ManyToOne
	private Inmobilaria inmobilaria;
	
	@JoinColumn(name ="id_pago" , referencedColumnName="pk_pago")
	@ManyToOne
	private Pago pago;

	public Movimiento() {
		super();
	}
	
	public Movimiento(Integer id) {
		super();
		this.idMovimiento =id;
	}

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public int getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(int recomendacion) {
		this.recomendacion = recomendacion;
	}



	public Inmobilaria getInmobilaria() {
		return inmobilaria;
	}

	public void setInmobilaria(Inmobilaria inmobilaria) {
		this.inmobilaria = inmobilaria;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

}
