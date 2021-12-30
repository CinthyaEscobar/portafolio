package com.proyecto.arriendo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="filtrar_departamento")
public class Test implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private String nombre;
	private int total;
	
	@Id
	private Long idDepartamento;
	
	@Column(name = "total")
	public int getTotal() {
		return total;
	}

	@Column(name = "id_departamento")
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	
	@Column(name = "numero")
	public int getNumero() {
		return numero;
	}

	
	
	
	
	
}
