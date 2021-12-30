package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Vehiculo;

public interface VehiculoService {
	void agregar(Vehiculo vehiculo);
	void modificar(Vehiculo vehiculo);
	List<Vehiculo> listar();
	Vehiculo buscar(long id);
}
