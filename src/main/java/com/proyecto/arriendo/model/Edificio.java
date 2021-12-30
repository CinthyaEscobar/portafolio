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
@Table(name = "EDIFICIO")
@NamedQueries({
    @NamedQuery(name = "Edificio.findAll", query = "SELECT e FROM Edificio e"),
    @NamedQuery(name = "Edificio.findByIdEdificio", query = "SELECT e FROM Edificio e WHERE e.idEdificio = :idEdificio"),
    @NamedQuery(name = "Edificio.findByNombre", query = "SELECT e FROM Edificio e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Edificio.findByActivo", query = "SELECT e FROM Edificio e WHERE e.activo = :activo")})
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EDIFICIO")
    private long idEdificio;
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private String activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEdificio")
    private List<Funcionario> funcionarioList;
    @JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID_DIRECCION")
    @ManyToOne(optional = false)
    private Direccion idDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEdificio")
    private List<Departamento> departamentoList;

    public Edificio() {
    }

    public Edificio(long idEdificio) {
        this.idEdificio = idEdificio;
    }

    public Edificio(long idEdificio,String nombre ,String activo ) {
        this.idEdificio = idEdificio;
        this.nombre = nombre;
        this.activo = activo;
    }

    public long getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(long idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }


    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }        

    public List<Departamento> getDepartamentoList() {
		return departamentoList;
	}

	public void setDepartamentoList(List<Departamento> departamentoList) {
		this.departamentoList = departamentoList;
	}

	@Override
    public String toString() {
        return "modelo.Edificio[ idEdificio=" + idEdificio + " ]";
    }
    
}
