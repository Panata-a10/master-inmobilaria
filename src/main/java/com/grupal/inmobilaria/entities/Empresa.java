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
@Table(name="empresas")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_empresa")
	private Integer idEmpresa;
	
	@Column(name="nombre")
	@NotEmpty
	@Size(max=35)
	private String nombre;
	
	@Column(name="direccion")
	@NotEmpty
	@Size(max=35)
	private String direccion;
	
	@Column(name="telefono")
	@NotEmpty
	@Size(max=35)
	private String telefono;
	
	//
	public Empresa() {
		super();
	}
	public Empresa(Integer id) {
		super();
		this.idEmpresa =id;
	}

	//
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/*
	@OneToMany(mappedBy="empresa" , fetch = FetchType.LAZY )
	private List<Anunciante> anunciantes;
	
	public List<Anunciante> getAnunciantes() {
		return anunciantes;
	}
	public void setAnunciantes(List<Anunciante> anunciantes) {
		this.anunciantes = anunciantes;
	}	*/
	
	
	
	/* realcion con usuario anunciante*/
	@OneToMany(mappedBy="empresa" , fetch = FetchType.LAZY )
	private List<Usuario> usuario;

	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
