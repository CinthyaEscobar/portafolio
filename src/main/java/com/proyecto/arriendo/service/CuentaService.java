package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Cuenta;

public interface CuentaService {
	void agregar(Cuenta cuenta);
	void modificar(Cuenta cuenta);
	List<Cuenta> listar();
	Cuenta buscar(Long id);
	
}
