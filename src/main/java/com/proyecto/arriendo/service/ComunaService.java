package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Comuna;

public interface ComunaService {

	List<Comuna> listar();
	Comuna buscar(long id);
}
