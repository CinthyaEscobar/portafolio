package com.proyecto.arriendo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACOMPANANTE")
public class Acompanante implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "ID_ACOMPANANTE")
	private long idAcompanante;
	@Basic(optional = false)
    @Column(name = "RUT")
	private String rut;
	@Basic(optional = false)
    @Column(name = "NOMBRE")
	private String nombre;
	@JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
	@ManyToOne(optional = false)
	private Reserva idReserva;
	
	public Acompanante() {
		super();			
	}
	
	public Acompanante(long idAcompanante) {
		super();
		this.idAcompanante = idAcompanante;		
	}
	
	public Acompanante(long idAcompanante, String rut, String nombre) {
		super();
		this.idAcompanante = idAcompanante;
		this.rut = rut;
		this.nombre = nombre;
	}

	public long getIdAcompanante() {
		return idAcompanante;
	}

	public void setIdAcompanante(long idAcompanante) {
		this.idAcompanante = idAcompanante;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Reserva getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Reserva idReserva) {
		this.idReserva = idReserva;
	}
}
