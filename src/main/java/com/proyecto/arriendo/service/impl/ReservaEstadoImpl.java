package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.ReservaEstado;
import com.proyecto.arriendo.repository.ReservaEstadoRepository;
import com.proyecto.arriendo.service.ReservaEstadoService;

@Service
public class ReservaEstadoImpl implements ReservaEstadoService{

	@Autowired
	private ReservaEstadoRepository repo;
	
	@Override
	public List<ReservaEstado> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ReservaEstado buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
