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
@Table(name = "DIRECCION")
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByCalle", query = "SELECT d FROM Direccion d WHERE d.calle = :calle"),
    @NamedQuery(name = "Direccion.findByNumero", query = "SELECT d FROM Direccion d WHERE d.numero = :numero")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DIRECCION")
    private long idDireccion;
    @Basic(optional = false)
    @Column(name = "CALLE")
    private String calle;
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private int numero;
    @JoinColumn(name = "ID_CO", referencedColumnName = "ID_CO")
    @ManyToOne(optional = false)
    private Comuna idCo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDireccion")
    private List<Edificio> edificioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDireccion")
    private List<Tour> tourList;

    public Direccion() {
    }

    public Direccion(long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Direccion(long idDireccion, String calle, int numero) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
    }

    public long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Comuna getIdCo() {
        return idCo;
    }

    public void setIdCo(Comuna idCo) {
        this.idCo = idCo;
    }

    public List<Edificio> getEdificioList() {
        return edificioList;
    }

    public void setEdificioList(List<Edificio> edificioList) {
        this.edificioList = edificioList;
    }      
    

    public List<Tour> getTourList() {
		return tourList;
	}

	public void setTourList(List<Tour> tourList) {
		this.tourList = tourList;
	}

	@Override
    public String toString() {
        return "modelo.Direccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
