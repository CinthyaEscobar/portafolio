package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Provincia;

public interface ProvinciaService {

	List<Provincia> listar();
	Provincia buscar(long id);
}
