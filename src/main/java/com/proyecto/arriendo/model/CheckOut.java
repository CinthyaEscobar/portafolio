/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author cinth
 */
@Entity
@Table(name = "CHECK_OUT")
@NamedQueries({
    @NamedQuery(name = "CheckOut.findAll", query = "SELECT c FROM CheckOut c"),
    @NamedQuery(name = "CheckOut.findByIdCheckout", query = "SELECT c FROM CheckOut c WHERE c.idCheckout = :idCheckout"),
    @NamedQuery(name = "CheckOut.findByFecha", query = "SELECT c FROM CheckOut c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CheckOut.findByHora", query = "SELECT c FROM CheckOut c WHERE c.hora = :hora"),
    @NamedQuery(name = "CheckOut.findByMulta", query = "SELECT c FROM CheckOut c WHERE c.multa = :multa")})
public class CheckOut implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CHECKOUT")
    private long idCheckout;
    @Basic(optional = false)
    @Column(name = "FECHA") 
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha;
    @Basic(optional = false)
    @Column(name = "HORA")    
    private LocalTime hora;
    @Column(name = "MULTA")
    private int multa;
    @Column(name = "DETALLE")
    private String detalle;
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    @ManyToOne(optional = false)
    private Reserva idReserva;

    public CheckOut() {
    }

    public CheckOut(long idCheckout) {
        this.idCheckout = idCheckout;
    }    

    public CheckOut(long idCheckout, LocalDate fecha, LocalTime hora, int multa, String detalle) {
		super();
		this.idCheckout = idCheckout;
		this.fecha = fecha;
		this.hora = hora;
		this.multa = multa;
		this.detalle = detalle;
	}

	public long getIdCheckout() {
        return idCheckout;
    }

    public void setIdCheckout(long idCheckout) {
        this.idCheckout = idCheckout;
    }

    public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }    

    @Override
    public String toString() {
        return "modelo.CheckOut[ idCheckout=" + idCheckout + " ]";
    }
    
}
