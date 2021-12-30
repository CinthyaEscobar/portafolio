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
@Table(name = "TIPO_CUENTA")
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t"),
    @NamedQuery(name = "TipoCuenta.findByIdTipocuenta", query = "SELECT t FROM TipoCuenta t WHERE t.idTipocuenta = :idTipocuenta"),
    @NamedQuery(name = "TipoCuenta.findByDescripcion", query = "SELECT t FROM TipoCuenta t WHERE t.descripcion = :descripcion")})
public class TipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPOCUENTA")
    private long idTipocuenta;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipocuenta")
    private List<Cuenta> cuentaList;

    public TipoCuenta() {
    }

    public TipoCuenta(long idTipocuenta) {
        this.idTipocuenta = idTipocuenta;
    }

    public TipoCuenta(long idTipocuenta, String descripcion) {
        this.idTipocuenta = idTipocuenta;
        this.descripcion = descripcion;
    }

    public long getIdTipocuenta() {
        return idTipocuenta;
    }

    public void setIdTipocuenta(long idTipocuenta) {
        this.idTipocuenta = idTipocuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }
    
    @Override
    public String toString() {
        return "modelo.TipoCuenta[ idTipocuenta=" + idTipocuenta + " ]";
    }
    
}
