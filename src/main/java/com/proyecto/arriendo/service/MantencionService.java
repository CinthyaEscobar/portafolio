package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Mantencion;

public interface MantencionService {
	void agregar(Mantencion mantencion);
	void modificar(Mantencion mantencion);
	List<Mantencion> listar();
	Mantencion buscar(long id);
	
}
