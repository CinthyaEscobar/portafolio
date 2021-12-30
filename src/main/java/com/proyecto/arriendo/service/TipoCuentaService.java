package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.TipoCuenta;

public interface TipoCuentaService {
	void agregar(TipoCuenta tipocuenta);
	void modificar(TipoCuenta tipocuenta);
	List<TipoCuenta> listar();
	TipoCuenta buscar(long id);

}
