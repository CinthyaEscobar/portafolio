/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cinth
 */
@Entity
@Table(name = "RESERVA_ESTADO")
@NamedQueries({
    @NamedQuery(name = "ReservaEstado.findAll", query = "SELECT r FROM ReservaEstado r"),
    @NamedQuery(name = "ReservaEstado.findByIdReservaestado", query = "SELECT r FROM ReservaEstado r WHERE r.idReservaestado = :idReservaestado"),
    @NamedQuery(name = "ReservaEstado.findByDescripcion", query = "SELECT r FROM ReservaEstado r WHERE r.descripcion = :descripcion")})
public class ReservaEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESERVAESTADO")
    private long idReservaestado;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReservaestado")
    private List<Reserva> reservaList;

    public ReservaEstado() {
    }

    public ReservaEstado(long idReservaestado) {
        this.idReservaestado = idReservaestado;
    }

    public ReservaEstado(long idReservaestado, String descripcion) {
        this.idReservaestado = idReservaestado;
        this.descripcion = descripcion;
    }

    public long getIdReservaestado() {
        return idReservaestado;
    }

    public void setIdReservaestado(long idReservaestado) {
        this.idReservaestado = idReservaestado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }  

    @Override
    public String toString() {
        return "modelo.ReservaEstado[ idReservaestado=" + idReservaestado + " ]";
    }
    
}
