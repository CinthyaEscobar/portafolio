package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Transporte;

public interface TransporteService{
	void agregar(Transporte transporte);
	void modificar(Transporte transporte);
	List<Transporte> listar();
	Transporte buscar(long id);
}
