/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cinth
 */
@Entity
@Table(name = "RESERVA_TOUR")
@NamedQueries({
    @NamedQuery(name = "ReservaTour.findAll", query = "SELECT r FROM ReservaTour r"),
    @NamedQuery(name = "ReservaTour.findByIdReservatour", query = "SELECT r FROM ReservaTour r WHERE r.idReservatour = :idReservatour")})
public class ReservaTour implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESERVATOUR")
    private long idReservatour;
    @JoinColumn(name = "ID_RESERVA", referencedColumnName = "ID_RESERVA")
    @ManyToOne(optional = false)
    private Reserva idReserva;
    @JoinColumn(name = "ID_TOUR", referencedColumnName = "ID_TOUR")
    @ManyToOne(optional = false)
    private Tour idTour;

    public ReservaTour() {
    }

    public ReservaTour(long idReservatour) {
        this.idReservatour = idReservatour;
    }

    public long getIdReservatour() {
        return idReservatour;
    }

    public void setIdReservatour(long idReservatour) {
        this.idReservatour = idReservatour;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Tour getIdTour() {
        return idTour;
    }

    public void setIdTour(Tour idTour) {
        this.idTour = idTour;
    }

    @Override
    public String toString() {
        return "modelo.ReservaTour[ idReservatour=" + idReservatour + " ]";
    }
    
}
