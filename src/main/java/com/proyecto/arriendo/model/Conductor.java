/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "CONDUCTOR")
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c"),
    @NamedQuery(name = "Conductor.findByIdConductor", query = "SELECT c FROM Conductor c WHERE c.idConductor = :idConductor"),
    @NamedQuery(name = "Conductor.findByRut", query = "SELECT c FROM Conductor c WHERE c.rut = :rut"),
    @NamedQuery(name = "Conductor.findByNombre", query = "SELECT c FROM Conductor c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Conductor.findByApellidop", query = "SELECT c FROM Conductor c WHERE c.apellidop = :apellidop"),
    @NamedQuery(name = "Conductor.findByActivo", query = "SELECT c FROM Conductor c WHERE c.activo = :activo")})
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONDUCTOR")
    private long idConductor;
    @Basic(optional = false)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDOP")
    private String apellidop;
    @Column(name = "ACTIVO")
    private String activo;
    @OneToMany(mappedBy = "idConductor")
    private List<Transporte> transporteList;

    public Conductor() {
    }

    public Conductor(long idConductor) {
        this.idConductor = idConductor;
    }

    public Conductor(long idConductor, String rut, String nombre, String apellidop) {
        this.idConductor = idConductor;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidop = apellidop;
        
        
    }

    public long getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(long idConductor) {
        this.idConductor = idConductor;
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

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

   
    

    public List<Transporte> getTransporteList() {
        return transporteList;
    }

    public void setTransporteList(List<Transporte> transporteList) {
        this.transporteList = transporteList;
    }    

    @Override
    public String toString() {
        return "modelo.Conductor[ idConductor=" + idConductor + " ]";
    }
    
}
