package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.ReservaTour;
import com.proyecto.arriendo.repository.ReservaTourRepository;
import com.proyecto.arriendo.service.ReservaTourService;

@Service
public class ReservaTourServiceImpl implements ReservaTourService {

	@Autowired
	private ReservaTourRepository repo;
	
	@Override
	public void agregar(ReservaTour reservaTour) {
		// TODO Auto-generated method stub
		repo.save(reservaTour);
		
	}

	@Override
	public void Modificar(ReservaTour reservaTour) {
		// TODO Auto-generated method stub
		repo.save(reservaTour);
		
	}

	@Override
	public List<ReservaTour> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ReservaTour buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<ReservaTour> buscarPorReserva(long id) {
		// TODO Auto-generated method stub
		return repo.findByReserva(id);
	}

}
