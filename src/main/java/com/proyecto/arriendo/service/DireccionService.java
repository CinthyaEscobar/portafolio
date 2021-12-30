package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Direccion;

public interface DireccionService {

	void agregar(Direccion dire);
	void modificar(Direccion dire);
	List<Direccion> listar();
	Direccion buscar(long id);
}
