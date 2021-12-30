/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "MANTENCION")
@NamedQueries({
    @NamedQuery(name = "Mantencion.findAll", query = "SELECT m FROM Mantencion m"),
    @NamedQuery(name = "Mantencion.findByIdMantencion", query = "SELECT m FROM Mantencion m WHERE m.idMantencion = :idMantencion"),
    @NamedQuery(name = "Mantencion.findByFecha", query = "SELECT m FROM Mantencion m WHERE m.fecha = :fecha")})
public class Mantencion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MANTENCION")
    private long idMantencion;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private int costo;
    @Basic(optional = false)
    @Column(name = "FECHA")
    //@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha;
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @JoinColumn(name = "ID_TIPOMANTENCION", referencedColumnName = "ID_TIPOMANTENCION")
    @ManyToOne(optional = false)
    private TipoMantencion idTipomantencion;

    public Mantencion() {
    }

    public Mantencion(long idMantencion) {
        this.idMantencion = idMantencion;
    }

    public Mantencion(long idMantencion, LocalDate fecha, int costo) {
        this.idMantencion = idMantencion;
        this.fecha = fecha;
        this.costo = costo;
    }

    public long getIdMantencion() {
        return idMantencion;
    }

    public void setIdMantencion(long idMantencion) {
        this.idMantencion = idMantencion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public TipoMantencion getIdTipomantencion() {
        return idTipomantencion;
    }

    public void setIdTipomantencion(TipoMantencion idTipomantencion) {
        this.idTipomantencion = idTipomantencion;
    }
    
    public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
    public String toString() {
        return "modelo.Mantencion[ idMantencion=" + idMantencion + " ]";
    }
    
}
