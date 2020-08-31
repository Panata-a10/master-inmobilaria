package com.grupal.inmobilaria.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="inmobilarias")
public class Inmobilaria implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_inmobilaria")
	private Integer idInmobilaria;
	
	@Column(name="nombre")
	@NotEmpty
	@Size(max=50)
	private String nombre;
	
	@Column(name="provincia")
	@NotEmpty
	@Size(max=25)
	private String provincia;
	
	@Column(name="habitaciones")
	@NotEmpty
	@Size(max=5)
	private String habitaciones;
	
	@Column(name="caracteristicas")
	private String caracteristicas;
	
	@Column(name="direccion")
	@NotEmpty
	@Size(max=50)
	private String direccion;
	
	@Column(name="valor")
	private float valor;
	
	@Column(name="descripcion")
	@NotEmpty
	@Size(max=50)
	private String descripcion;
	
	@Column(name="area_construccion")
	private String area_construccion;
	
	@Column(name="imagen")
	private String imagen;
	
	//relacion anunciante
	@JoinColumn(name ="id_usuario" , referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario anunciante;
	
	@JoinColumn(name ="id_tipo" , referencedColumnName="pk_tip_inmobilaria")
	@ManyToOne
	private TipoInmobilaria tipoImnobilaria;


	@JoinColumn(name ="id_operaciones" , referencedColumnName="pk_operacion")
	@ManyToOne
	private Operacion operacion;
	
	@OneToMany(mappedBy="inmobilaria" , fetch = FetchType.LAZY )
	private List<Movimiento> movimiento;
	
	@JsonIgnore
	@OneToMany(mappedBy="inmobilaria", fetch=FetchType.LAZY) 
	private List<Detalle> detalles;

	
	

	public Inmobilaria() {
		super();
	}
	
	public Inmobilaria(Integer id) {
		super();
		this.idInmobilaria =id;
	}

	
	
	
	public List<Detalle> getDetalles() {
		
		if(detalles == null) {
			detalles = new ArrayList<Detalle>();
		}
					
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
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

	public String getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(String habitaciones) {
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

	
	public Usuario getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Usuario anunciante) {
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
