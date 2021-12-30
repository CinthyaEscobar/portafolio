package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Conductor;

public interface ConductorService {
	void agregar(Conductor conductor);
	void modificar(Conductor conductor);
	List<Conductor> listar();
	Conductor buscar(long id);

}
