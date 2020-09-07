package com.grupal.inmobilaria.reporting;

import java.io.Serializable;

public class RptUsuarioInmuebles implements Serializable{

private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String creadoPor;
	
	public RptUsuarioInmuebles(String nombre, String creadoPor) {
		super();
		this.nombre = nombre;
		this.creadoPor = creadoPor;
	}
	
	public RptUsuarioInmuebles() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getcreadoPor() {
		return creadoPor;
	}


	public void setcreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

}
