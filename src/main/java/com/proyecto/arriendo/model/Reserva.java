/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.arriendo.model;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author cinth
 */
@Entity
@Table(name = "RESERVA")
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByFechaIngreso", query = "SELECT r FROM Reserva r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Reserva.findByFechaSalida", query = "SELECT r FROM Reserva r WHERE r.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Reserva.findByPagoReserva", query = "SELECT r FROM Reserva r WHERE r.pagoReserva = :pagoReserva"),
    @NamedQuery(name = "Reserva.findByTotalPagar", query = "SELECT r FROM Reserva r WHERE r.totalPagar = :totalPagar")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESERVA")
    private long idReserva;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fechaIngreso;
    @Basic(optional = false)
    @Column(name = "FECHA_SALIDA")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fechaSalida;
    @Basic(optional = false)
    @Column(name = "PAGO_RESERVA")
    private int pagoReserva;
    @Basic(optional = false)
    @Column(name = "TOTAL_PAGAR")
    private int totalPagar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private List<ReservaTour> reservaTourList;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "ID_RESERVAESTADO", referencedColumnName = "ID_RESERVAESTADO")
    @ManyToOne(optional = false)
    private ReservaEstado idReservaestado;
    @JoinColumn(name = "ID_TRANSPORTE", referencedColumnName = "ID_TRANSPORTE")
    @ManyToOne(optional = true)
    private Transporte idTransporte;    
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private List<CheckOut> checkOutList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private List<CheckIn> checkInList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private List<Acompanante> acompananteList;

    public Reserva() {
    }

    public Reserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(long idReserva, LocalDate fechaIngreso, LocalDate fechaSalida, int pagoReserva, int totalPagar) {
        this.idReserva = idReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.pagoReserva = pagoReserva;
        this.totalPagar = totalPagar;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPagoReserva() {
        return pagoReserva;
    }

    public void setPagoReserva(int pagoReserva) {
        this.pagoReserva = pagoReserva;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public List<ReservaTour> getReservaTourList() {
        return reservaTourList;
    }

    public void setReservaTourList(List<ReservaTour> reservaTourList) {
        this.reservaTourList = reservaTourList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public ReservaEstado getIdReservaestado() {
        return idReservaestado;
    }

    public void setIdReservaestado(ReservaEstado idReservaestado) {
        this.idReservaestado = idReservaestado;
    }

    public Transporte getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Transporte idTransporte) {
        this.idTransporte = idTransporte;
    }

    public List<CheckOut> getCheckOutList() {
        return checkOutList;
    }

    public void setCheckOutList(List<CheckOut> checkOutList) {
        this.checkOutList = checkOutList;
    }

    public List<CheckIn> getCheckInList() {
        return checkInList;
    }

    public void setCheckInList(List<CheckIn> checkInList) {
        this.checkInList = checkInList;
    }
    
    public List<Acompanante> getAcompananteList() {
		return acompananteList;
	}

	public void setAcompananteList(List<Acompanante> acompananteList) {
		this.acompananteList = acompananteList;
	}

	public Departamento getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Departamento idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@Override
    public String toString() {
        return "modelo.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
