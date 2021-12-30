/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author cinth
 */
@Entity
@Table(name = "TOUR")
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findByIdTour", query = "SELECT t FROM Tour t WHERE t.idTour = :idTour"),
    @NamedQuery(name = "Tour.findByLugar", query = "SELECT t FROM Tour t WHERE t.lugar = :lugar"),
    @NamedQuery(name = "Tour.findByDescripcion", query = "SELECT t FROM Tour t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tour.findByFecha", query = "SELECT t FROM Tour t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Tour.findByHoraComienzo", query = "SELECT t FROM Tour t WHERE t.horaComienzo = :horaComienzo"),
    @NamedQuery(name = "Tour.findByHoraFin", query = "SELECT t FROM Tour t WHERE t.horaFin = :horaFin"),
    @NamedQuery(name = "Tour.findByPrecio", query = "SELECT t FROM Tour t WHERE t.precio = :precio"),
    @NamedQuery(name = "Tour.findByCapacidad", query = "SELECT t FROM Tour t WHERE t.capacidad = :capacidad"),
    @NamedQuery(name = "Tour.findByActivo", query = "SELECT t FROM Tour t WHERE t.activo = :activo")})
public class Tour implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TOUR")
    private long idTour;
    @Basic(optional = false)
    @Column(name = "LUGAR")
    private String lugar;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA")
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha;
    @Basic(optional = false)
    @Column(name = "HORA_COMIENZO")    
    //@Temporal(TemporalType.TIME)   
    private LocalTime  horaComienzo;
    @Basic(optional = false)
    @Column(name = "HORA_FIN")
    //@Temporal(TemporalType.TIME)    
    private LocalTime  horaFin;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @Column(name = "CAPACIDAD")
    private int capacidad;
    @Lob
    @Column(name = "FOTO", columnDefinition = "BLOB")
    private byte[] foto;
    @JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID_DIRECCION")
    @ManyToOne(optional = false)
    private Direccion idDireccion;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private String activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTour")
    private List<ReservaTour> reservaTourList;

    public Tour() {
    }

    public Tour(long idTour) {
        this.idTour = idTour;
    }

    public Tour(long idTour, String lugar, String descripcion, LocalDate fecha, LocalTime  horaComienzo, LocalTime  horaFin, int precio, int capacidad, byte[] foto ,String activo) {
        this.idTour = idTour;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horaComienzo = horaComienzo;
        this.horaFin = horaFin;
        this.precio = precio;
        this.capacidad = capacidad;
        this.foto = foto;
        this.activo = activo;       
    }

    public long getIdTour() {
        return idTour;
    }

    public void setIdTour(long idTour) {
        this.idTour = idTour;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime  getHoraComienzo() {
        return horaComienzo;
    }

    public void setHoraComienzo(LocalTime  horaComienzo) {
        this.horaComienzo = horaComienzo;
    }

    public LocalTime  getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime  horaFin) {
        this.horaFin = horaFin;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<ReservaTour> getReservaTourList() {
        return reservaTourList;
    }

    public void setReservaTourList(List<ReservaTour> reservaTourList) {
        this.reservaTourList = reservaTourList;
    }
    
    public Direccion getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Direccion idDireccion) {
		this.idDireccion = idDireccion;
	}
	
	public String getImg()
	{
		return Base64.getEncoder().encodeToString(foto);
	}
	
	@Override
    public String toString() {
        return "modelo.Tour[ idTour=" + idTour + " ]";
    }
    
}
