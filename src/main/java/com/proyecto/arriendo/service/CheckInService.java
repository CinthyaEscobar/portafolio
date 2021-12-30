package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.CheckIn;

public interface CheckInService {
	
	void agregar(CheckIn checkIn);
	void modificar(CheckIn checkIn);
	List<CheckIn> listar();
	CheckIn buscar(long id);

}
