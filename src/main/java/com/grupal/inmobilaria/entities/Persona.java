package com.grupal.inmobilaria.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class Persona {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_persona")
	private Integer idpersona;
	*/
	@Column(name="nombres")
	@NotEmpty
	@Size(max=35)
	private String nombres;
	
	@Column(name="apellidos")
	@NotEmpty
	@Size(max=35)
	private String apellidos;
	
	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fechaNacimienta;
	
	@Column(name="cedula")
	//@NotEmpty
	@Size(max=10)
	private String cedula;
	
	@Column(name="email")
	@Email
	//@NotEmpty
	@Size(max=50)
	private String email;
	
	
	
	
	public Persona() {
		super();
	}
	
	public Persona(Integer id) {
		super();
	}

	

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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


	
	//
	@Override
	public String toString() {
		return this.getApellidos() + " " + this.getNombres();
	}
	
	public String fechaNac() {
		if(this.fechaNacimienta == null) return "-";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fechaNacimienta.getTime());
	}	
}
