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



@Entity
@Table(name="inmobilarias")
public class Inmobilaria implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_inmobilaria")
	private Integer idInmobilaria;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="habitaciones")
	private int habitaciones;
	
	@Column(name="caracteristicas")
	private String caracteristicas;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="valor")
	private float valor;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="area_construccion")
	private String area_construccion;
	
	@JoinColumn(name ="id_anunciante" , referencedColumnName="id_persona")
	@ManyToOne
	private Anunciante anunciante;
	
	@JoinColumn(name ="id_tipo" , referencedColumnName="id_tip_inmobilaria")
	@ManyToOne
	private TipoInmobilaria tipoImnobilaria;


	@JoinColumn(name ="id_operaciones" , referencedColumnName="id_operacion")
	@ManyToOne
	private Operacion operacion;
	
	@OneToMany(mappedBy="inmobilaria" , fetch = FetchType.LAZY )
	private List<Movimiento> movimiento;

	public Inmobilaria() {
		super();
	}
	
	public Inmobilaria(Integer id) {
		super();
		this.idInmobilaria =id;
	}

	

	public Integer getIdInmobilaria() {
		return idInmobilaria;
	}

	public void setIdInmobilaria(Integer idInmobilaria) {
		this.idInmobilaria = idInmobilaria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getArea_construccion() {
		return area_construccion;
	}

	public void setArea_construccion(String area_construccion) {
		this.area_construccion = area_construccion;
	}

	public Anunciante getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}

	public TipoInmobilaria getTipoImnobilaria() {
		return tipoImnobilaria;
	}

	public void setTipoImnobilaria(TipoInmobilaria tipoImnobilaria) {
		this.tipoImnobilaria = tipoImnobilaria;
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public List<Movimiento> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}
	
	
	
	
	
	

}
