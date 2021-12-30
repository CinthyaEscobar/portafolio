package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.ReservaTour;

public interface ReservaTourService {

	void agregar(ReservaTour reservaTour);
	void Modificar(ReservaTour reservaTour);
	List<ReservaTour> listar();
	ReservaTour buscar(long id);
	List<ReservaTour> buscarPorReserva(long id);
}
