package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Cliente;
import com.proyecto.arriendo.model.Reserva;

public interface ReservaService {

	void agregar(Reserva reserva);
	void modificar(Reserva reserva);
	List<Reserva> listar();
	Reserva buscar(long id);
	List<Reserva> listarPorCliente(Cliente cliente);
	List<Reserva> listarPorFuncionario(long id);
}
