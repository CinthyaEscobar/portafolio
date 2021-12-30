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
@Table(name = "FUNCIONARIO")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionario.findByActivo", query = "SELECT f FROM Funcionario f WHERE f.activo = :activo")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FUNCIONARIO")
    private long idFuncionario;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private String activo;
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA")
    @ManyToOne(optional = false)
    private Cuenta idCuenta;
    @JoinColumn(name = "ID_EDIFICIO", referencedColumnName = "ID_EDIFICIO")
    @ManyToOne(optional = false)
    private Edificio idEdificio;

    public Funcionario() {
    }

    public Funcionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(long idFuncionario, String activo) {
        this.idFuncionario = idFuncionario;
        this.activo = activo;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Edificio getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Edificio idEdificio) {
        this.idEdificio = idEdificio;
    }

    @Override
    public String toString() {
        return "modelo.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
