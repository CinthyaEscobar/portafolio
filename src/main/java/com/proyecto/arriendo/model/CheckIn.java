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
@Table(name = "CHECK_IN")
@NamedQueries({
    @NamedQuery(name = "CheckIn.findAll", query = "SELECT c FROM CheckIn c"),
    @NamedQuery(name = "CheckIn.findByIdCechkin", query = "SELECT c FROM CheckIn c WHERE c.idCechkin = :idCechkin"),
    @NamedQuery(name = "CheckIn.findByFecha", query = "SELECT c FROM CheckIn c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CheckIn.findByHora", query = "SELECT c FROM CheckIn c WHERE c.hora = :hora"),
    @NamedQuery(name = "CheckIn.findByPagoPendiente", query = "SELECT c FROM CheckIn c WHERE c.pagoPendiente = :pagoPendiente")})
public class CheckIn implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CECHKIN")
    private long idCechkin;
    @Basic(optional = false)
    @Column(name = "FECHA")
    //@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha;
    @Basic(optional = false)
    @Column(name = "HORA")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalTime hora;
    @Basic(optional = false)
    @Column(name = "PAGO_PENDIENTE")
    private int pagoPendiente;
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    @ManyToOne(optional = false)
    private Reserva idReserva;

    public CheckIn() {
    }

    public CheckIn(long idCechkin) {
        this.idCechkin = idCechkin;
    }

    public CheckIn(long idCechkin, LocalDate fecha, LocalTime hora, int pagoPendiente) {
        this.idCechkin = idCechkin;
        this.fecha = fecha;
        this.hora = hora;
        this.pagoPendiente = pagoPendiente;
    }

    public long getIdCechkin() {
        return idCechkin;
    }

    public void setIdCechkin(long idCechkin) {
        this.idCechkin = idCechkin;
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

    public int getPagoPendiente() {
        return pagoPendiente;
    }

    public void setPagoPendiente(int pagoPendiente) {
        this.pagoPendiente = pagoPendiente;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }
    
    @Override
    public String toString() {
        return "modelo.CheckIn[ idCechkin=" + idCechkin + " ]";
    }
    
}
