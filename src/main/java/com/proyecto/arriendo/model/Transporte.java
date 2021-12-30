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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cinth
 */
@Entity
@Table(name = "TRANSPORTE")
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.findByIdTransporte", query = "SELECT t FROM Transporte t WHERE t.idTransporte = :idTransporte"),
    @NamedQuery(name = "Transporte.findByActivo", query = "SELECT t FROM Transporte t WHERE t.activo = :activo")})
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TRANSPORTE")
    private long idTransporte;
    @Column(name = "ACTIVO")
    private String activo;
    @Column(name = "PRECIO")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransporte")
    private List<Reserva> reservaList;
    @JoinColumn(name = "ID_CONDUCTOR", referencedColumnName = "ID_CONDUCTOR")
    @ManyToOne
    private Conductor idConductor;
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne
    private Vehiculo idVehiculo;

    public Transporte() {
    }

    public Transporte(long idTransporte) {
        this.idTransporte = idTransporte;
    }
    
    

    public Transporte(long idTransporte, String activo, int precio) {
		super();
		this.idTransporte = idTransporte;
		this.activo = activo;
		this.precio = precio;
	}

	public long getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(long idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public Conductor getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Conductor idConductor) {
        this.idConductor = idConductor;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    
    public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
    public String toString() {
        return "modelo.Transporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
