package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.ReservaEstado;

public interface ReservaEstadoService {

	List<ReservaEstado> listar();
	ReservaEstado buscar(long id);
}
