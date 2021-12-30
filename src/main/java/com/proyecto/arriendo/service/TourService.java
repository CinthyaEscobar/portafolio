package com.proyecto.arriendo.service;

import java.time.LocalDate;
import java.util.List;

import com.proyecto.arriendo.model.Tour;

public interface TourService {

	void agregar(Tour tour);
	void modificar(Tour tour);
	List<Tour> listar();
	Tour buscar(long id);
	List<Tour> buscarParaReserva(long provincia, LocalDate desde, LocalDate hasta);
}
