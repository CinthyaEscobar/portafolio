package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Estado;



public interface EstadoService {

	void agregar(Estado estado);
	void modificar(Estado estado);
	List<Estado> listar();
	Estado buscar(long id);
}