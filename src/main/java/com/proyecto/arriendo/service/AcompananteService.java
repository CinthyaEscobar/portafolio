package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Acompanante;

public interface AcompananteService {

	void agregar(Acompanante acompanante);
	void modificar(Acompanante acompanante);
	List<Acompanante> listar();
	Acompanante buscar(long id);
}
