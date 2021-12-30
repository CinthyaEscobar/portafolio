package com.proyecto.arriendo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Tour;
import com.proyecto.arriendo.repository.TourRepository;
import com.proyecto.arriendo.service.TourService;

@Service
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourRepository repo;

	@Override
	public void agregar(Tour tour) {
		// TODO Auto-generated method stub
		repo.save(tour);
		
	}

	@Override
	public void modificar(Tour tour) {
		// TODO Auto-generated method stub
		repo.save(tour);
		
	}

	@Override
	public List<Tour> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Tour buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Tour> buscarParaReserva(long provincia, LocalDate desde, LocalDate hasta) {
		// TODO Auto-generated method stub
		return repo.buscarParaReserva(provincia, desde, hasta);
	}

}
