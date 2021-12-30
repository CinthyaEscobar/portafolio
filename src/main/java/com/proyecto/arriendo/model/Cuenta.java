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
@Table(name = "CUENTA")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuenta.findByCorreo", query = "SELECT c FROM Cuenta c WHERE c.correo = :correo"),
    @NamedQuery(name = "Cuenta.findByContrasena", query = "SELECT c FROM Cuenta c WHERE c.contrasena = :contrasena"),
    @NamedQuery(name = "Cuenta.findByRut", query = "SELECT c FROM Cuenta c WHERE c.rut = :rut"),
    @NamedQuery(name = "Cuenta.findByNombre", query = "SELECT c FROM Cuenta c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cuenta.findByApellidop", query = "SELECT c FROM Cuenta c WHERE c.apellidop = :apellidop"),
    @NamedQuery(name = "Cuenta.findByApellidom", query = "SELECT c FROM Cuenta c WHERE c.apellidom = :apellidom"),
    @NamedQuery(name = "Cuenta.findByTelefono", query = "SELECT c FROM Cuenta c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cuenta.findByCelular", query = "SELECT c FROM Cuenta c WHERE c.celular = :celular")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CUENTA")
    private long idCuenta;
    @Basic(optional = false)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDOP")
    private String apellidop;
    @Basic(optional = false)
    @Column(name = "APELLIDOM")
    private String apellidom;
    @Column(name = "TELEFONO")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "CELULAR")
    private int celular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private List<Funcionario> funcionarioList;
    @JoinColumn(name = "ID_TIPOCUENTA", referencedColumnName = "ID_TIPOCUENTA")
    @ManyToOne(optional = false)
    private TipoCuenta idTipocuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private List<Admin> adminList;

    public Cuenta() {
    }

    public Cuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuenta(long idCuenta, String correo, String contrasena, String rut, String nombre, String apellidop, String apellidom, int celular) {
        this.idCuenta = idCuenta;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.celular = celular;
    }

    public long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public TipoCuenta getIdTipocuenta() {
        return idTipocuenta;
    }

    public void setIdTipocuenta(TipoCuenta idTipocuenta) {
        this.idTipocuenta = idTipocuenta;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }    

    @Override
    public String toString() {
        return "modelo.Cuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
