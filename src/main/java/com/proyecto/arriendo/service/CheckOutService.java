package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.CheckOut;

public interface CheckOutService {

	void agregar(CheckOut checkIn);
	void modificar(CheckOut checkIn);
	List<CheckOut> listar();
	CheckOut buscar(long id);
}
