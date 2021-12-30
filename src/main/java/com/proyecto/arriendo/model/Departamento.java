/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
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

/**
 *
 * @author cinth
 */
@Entity
@Table(name = "DEPARTAMENTO")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdDepartamento", query = "SELECT d FROM Departamento d WHERE d.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Departamento.findByNumero", query = "SELECT d FROM Departamento d WHERE d.numero = :numero"),
    @NamedQuery(name = "Departamento.findByPiso", query = "SELECT d FROM Departamento d WHERE d.piso = :piso"),
    @NamedQuery(name = "Departamento.findByTarifa", query = "SELECT d FROM Departamento d WHERE d.tarifa = :tarifa"),
    @NamedQuery(name = "Departamento.findByPorcentajeReserva", query = "SELECT d FROM Departamento d WHERE d.porcentajeReserva = :porcentajeReserva"),
    @NamedQuery(name = "Departamento.findByDescripcion", query = "SELECT d FROM Departamento d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Departamento.findByActivo", query = "SELECT d FROM Departamento d WHERE d.activo = :activo")})

public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DEPARTAMENTO")
    private long idDepartamento;
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private int numero;
    @Basic(optional = false)
    @Column(name = "PISO")
    private int piso;
    @Basic(optional = false)
    @Column(name = "TARIFA")
    private int tarifa;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_RESERVA")
    private int porcentajeReserva;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private String activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private List<Mantencion> mantencionList;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private List<Reserva> reservaList;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private List<Item> itemList;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "ID_EDIFICIO", referencedColumnName = "ID_EDIFICIO")
    @ManyToOne(optional = false)
    private Edificio idEdificio;
    @Lob
    @Column(name = "FOTO", columnDefinition = "BLOB")
    private byte[] foto;
    
    
    public Departamento() {
    }

    public Departamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Departamento(long idDepartamento, int numero, int piso, int tarifa, int porcentajeReserva, String descripcion, String activo,byte[] foto) {
        this.idDepartamento = idDepartamento;
        this.numero = numero;
        this.piso = piso;
        this.tarifa = tarifa;
        this.porcentajeReserva = porcentajeReserva;
        this.descripcion = descripcion;
        this.activo = activo;
        this.foto = foto;
    }
    
    public Departamento(long idDepartamento, int numero, int piso, int tarifa, int porcentajeReserva, String descripcion, String activo) {
        this.idDepartamento = idDepartamento;
        this.numero = numero;
        this.piso = piso;
        this.tarifa = tarifa;
        this.porcentajeReserva = porcentajeReserva;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public int getPorcentajeReserva() {
        return porcentajeReserva;
    }

    public void setPorcentajeReserva(int porcentajeReserva) {
        this.porcentajeReserva = porcentajeReserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    
    public List<Mantencion> getMantencionList() {
        return mantencionList;
    }

    public void setMantencionList(List<Mantencion> mantencionList) {
        this.mantencionList = mantencionList;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Edificio getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(Edificio idEdificio) {
		this.idEdificio = idEdificio;
	}

	public List<Reserva> getReservaList() {
		return reservaList;
	}

	public void setReservaList(List<Reserva> reservaList) {
		this.reservaList = reservaList;
	}
	
	public String getImg()
	{
		return Base64.getEncoder().encodeToString(foto);
	}

	@Override
    public String toString() {
        return "modelo.Departamento[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
