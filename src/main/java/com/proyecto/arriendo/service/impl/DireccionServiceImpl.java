package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Direccion;
import com.proyecto.arriendo.repository.DireccionRepository;
import com.proyecto.arriendo.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionRepository repo;
	
	@Override
	public void agregar(Direccion dire) {
		// TODO Auto-generated method stub
		repo.save(dire);
		
	}

	@Override
	public void modificar(Direccion dire) {
		// TODO Auto-generated method stub
		repo.save(dire);
		
	}

	@Override
	public List<Direccion> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Direccion buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
