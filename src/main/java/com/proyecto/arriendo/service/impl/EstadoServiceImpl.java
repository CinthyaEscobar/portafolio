package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Estado;
import com.proyecto.arriendo.repository.EstadoRepository;
import com.proyecto.arriendo.service.EstadoService;

@Service
public class EstadoServiceImpl  implements EstadoService{

	@Autowired
	private EstadoRepository repo;
	
	@Override
	public void agregar(Estado estado) {
		// TODO Auto-generated method stub
		repo.save(estado);
	}

	@Override
	public void modificar(Estado estado) {
		// TODO Auto-generated method stub
		repo.save(estado);
	}

	@Override
	public List<Estado> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Estado buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
