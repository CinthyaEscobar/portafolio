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
@Table(name = "REGION")
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByIdRe", query = "SELECT r FROM Region r WHERE r.idRe = :idRe"),
    @NamedQuery(name = "Region.findByStrDescripcion", query = "SELECT r FROM Region r WHERE r.strDescripcion = :strDescripcion"),
    @NamedQuery(name = "Region.findByStrRoman", query = "SELECT r FROM Region r WHERE r.strRoman = :strRoman"),
    @NamedQuery(name = "Region.findByNumProvincias", query = "SELECT r FROM Region r WHERE r.numProvincias = :numProvincias"),
    @NamedQuery(name = "Region.findByNumComunas", query = "SELECT r FROM Region r WHERE r.numComunas = :numComunas")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RE")
    private long idRe;
    @Basic(optional = false)
    @Column(name = "STR_DESCRIPCION")
    private String strDescripcion;
    @Basic(optional = false)
    @Column(name = "STR_ROMAN")
    private String strRoman;
    @Basic(optional = false)
    @Column(name = "NUM_PROVINCIAS")
    private int numProvincias;
    @Basic(optional = false)
    @Column(name = "NUM_COMUNAS")
    private int numComunas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRe")
    private List<Provincia> provinciaList;

    public Region() {
    }

    public Region(long idRe) {
        this.idRe = idRe;
    }

    public Region(long idRe, String strDescripcion, String strRoman, int numProvincias, int numComunas) {
        this.idRe = idRe;
        this.strDescripcion = strDescripcion;
        this.strRoman = strRoman;
        this.numProvincias = numProvincias;
        this.numComunas = numComunas;
    }

    public long getIdRe() {
        return idRe;
    }

    public void setIdRe(long idRe) {
        this.idRe = idRe;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public String getStrRoman() {
        return strRoman;
    }

    public void setStrRoman(String strRoman) {
        this.strRoman = strRoman;
    }

    public int getNumProvincias() {
        return numProvincias;
    }

    public void setNumProvincias(int numProvincias) {
        this.numProvincias = numProvincias;
    }

    public int getNumComunas() {
        return numComunas;
    }

    public void setNumComunas(int numComunas) {
        this.numComunas = numComunas;
    }

    public List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList) {
        this.provinciaList = provinciaList;
    }

    @Override
    public String toString() {
        return "modelo.Region[ idRe=" + idRe + " ]";
    }
    
}
