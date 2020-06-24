package com.grupal.inmobilaria.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_persona")
	private Integer idpersona;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fechaNacimienta;
	
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contrasena")
	private String contrasena;
	
	
	public Persona() {
		super();
	}
	
	public Persona(Integer id) {
		super();
		this.idpersona = id;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Calendar getFechaNacimienta() {
		return fechaNacimienta;
	}

	public void setFechaNacimienta(Calendar fechaNacimienta) {
		this.fechaNacimienta = fechaNacimienta;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	//
	@Override
	public String toString() {
		return this.getApellido() + " " + this.getNombre();
	}
	
	public String fechaNac() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fechaNacimienta.getTime());
	}	
}
