package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Edificio;

public interface EdificioService {

	void agregar(Edificio edificio);
	void modificar(Edificio edificio);
	List<Edificio> listar();
	Edificio buscar(long id);
}
