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
@Table(name = "COMUNA")
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c"),
    @NamedQuery(name = "Comuna.findByIdCo", query = "SELECT c FROM Comuna c WHERE c.idCo = :idCo"),
    @NamedQuery(name = "Comuna.findByStrDescripcion", query = "SELECT c FROM Comuna c WHERE c.strDescripcion = :strDescripcion")})
public class Comuna implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CO")
    private long idCo;
    @Column(name = "STR_DESCRIPCION")
    private String strDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCo")
    private List<Direccion> direccionList;
    @JoinColumn(name = "ID_PR", referencedColumnName = "ID_PR")
    @ManyToOne(optional = false)
    private Provincia idPr;

    public Comuna() {
    }

    public Comuna(long idCo) {
        this.idCo = idCo;
    }

    public long getIdCo() {
        return idCo;
    }

    public void setIdCo(long idCo) {
        this.idCo = idCo;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public Provincia getIdPr() {
        return idPr;
    }

    public void setIdPr(Provincia idPr) {
        this.idPr = idPr;
    }    

    @Override
    public String toString() {
        return "modelo.Comuna[ idCo=" + idCo + " ]";
    }
    
}
