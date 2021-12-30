package com.proyecto.arriendo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="filtrar_zona")
public class FiltroProvincia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String provincia;
	private int ingreso;
	
	@Id
	private Long idPr;

	@Column(name = "provincia")
	public String getProvincia() {
		return provincia;
	}

	
	@Column(name = "ingreso")
	public int getIngreso() {
		return ingreso;
	}

	
	@Column(name = "id_pr")
	public Long getIdPr() {
		return idPr;
	}

	
	
	
	
	
	
}
