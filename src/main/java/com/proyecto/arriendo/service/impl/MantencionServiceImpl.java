package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Mantencion;
import com.proyecto.arriendo.repository.MantencionRepository;
import com.proyecto.arriendo.service.MantencionService;

@Service
public class MantencionServiceImpl implements MantencionService{
	
	@Autowired
	private MantencionRepository repo;
	
	@Override
	public void agregar(Mantencion mantencion) {
		// TODO Auto-generated method stub
		repo.save(mantencion);
	}

	@Override
	public void modificar(Mantencion mantencion) {
		// TODO Auto-generated method stub
		repo.save(mantencion);
	}

	@Override
	public List<Mantencion> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mantencion buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
