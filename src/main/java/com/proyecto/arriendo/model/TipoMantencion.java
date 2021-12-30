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
@Table(name = "TIPO_MANTENCION")
@NamedQueries({
    @NamedQuery(name = "TipoMantencion.findAll", query = "SELECT t FROM TipoMantencion t"),
    @NamedQuery(name = "TipoMantencion.findByIdTipomantencion", query = "SELECT t FROM TipoMantencion t WHERE t.idTipomantencion = :idTipomantencion"),
    @NamedQuery(name = "TipoMantencion.findByDescripcion", query = "SELECT t FROM TipoMantencion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoMantencion.findByCosto", query = "SELECT t FROM TipoMantencion t WHERE t.costo = :costo")})
public class TipoMantencion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPOMANTENCION")
    private long idTipomantencion;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private int costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipomantencion")
    private List<Mantencion> mantencionList;

    public TipoMantencion() {
    }

    public TipoMantencion(long idTipomantencion) {
        this.idTipomantencion = idTipomantencion;
    }

    public TipoMantencion(long idTipomantencion, String descripcion, int costo) {
        this.idTipomantencion = idTipomantencion;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public long getIdTipomantencion() {
        return idTipomantencion;
    }

    public void setIdTipomantencion(long idTipomantencion) {
        this.idTipomantencion = idTipomantencion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public List<Mantencion> getMantencionList() {
        return mantencionList;
    }

    public void setMantencionList(List<Mantencion> mantencionList) {
        this.mantencionList = mantencionList;
    }   

    @Override
    public String toString() {
        return "modelo.TipoMantencion[ idTipomantencion=" + idTipomantencion + " ]";
    }
    
}
