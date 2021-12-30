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
@Table(name = "PROVINCIA")
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByIdPr", query = "SELECT p FROM Provincia p WHERE p.idPr = :idPr"),
    @NamedQuery(name = "Provincia.findByStrDescripcion", query = "SELECT p FROM Provincia p WHERE p.strDescripcion = :strDescripcion"),
    @NamedQuery(name = "Provincia.findByNumComunas", query = "SELECT p FROM Provincia p WHERE p.numComunas = :numComunas")})
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PR")
    private long idPr;
    @Column(name = "STR_DESCRIPCION")
    private String strDescripcion;
    @Column(name = "NUM_COMUNAS")
    private int numComunas;
    @JoinColumn(name = "ID_RE", referencedColumnName = "ID_RE")
    @ManyToOne(optional = false)
    private Region idRe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPr")
    private List<Comuna> comunaList;

    public Provincia() {
    }

    public Provincia(long idPr) {
        this.idPr = idPr;
    }

    public long getIdPr() {
        return idPr;
    }

    public void setIdPr(int idPr) {
        this.idPr = idPr;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public int getNumComunas() {
        return numComunas;
    }

    public void setNumComunas(int numComunas) {
        this.numComunas = numComunas;
    }

    public Region getIdRe() {
        return idRe;
    }

    public void setIdRe(Region idRe) {
        this.idRe = idRe;
    }

    public List<Comuna> getComunaList() {
        return comunaList;
    }

    public void setComunaList(List<Comuna> comunaList) {
        this.comunaList = comunaList;
    }

    @Override
    public String toString() {
        return "modelo.Provincia[ idPr=" + idPr + " ]";
    }
    
}
