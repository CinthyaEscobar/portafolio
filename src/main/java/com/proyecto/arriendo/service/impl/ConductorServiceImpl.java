package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Conductor;
import com.proyecto.arriendo.repository.ConductorRepository;
import com.proyecto.arriendo.service.ConductorService;

@Service
public class ConductorServiceImpl implements ConductorService{
	@Autowired
	private ConductorRepository repo; 
	
	
	@Override
	public void agregar(Conductor conductor) {
		// TODO Auto-generated method stub
		repo.save(conductor);
	}

	@Override
	public void modificar(Conductor conductor) {
		// TODO Auto-generated method stub
		repo.save(conductor);

	}

	@Override
	public List<Conductor> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Conductor buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}
	
	
}
