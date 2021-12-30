package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Edificio;
import com.proyecto.arriendo.repository.EdificioRepository;
import com.proyecto.arriendo.service.EdificioService;

@Service
public class EdificioServiceImpl implements EdificioService {

	@Autowired
	private EdificioRepository repo;
	
	@Override
	public void agregar(Edificio edificio) {
		// TODO Auto-generated method stub
		repo.save(edificio);
		
	}

	@Override
	public void modificar(Edificio edificio) {
		// TODO Auto-generated method stub
		repo.save(edificio);
		
	}

	@Override
	public List<Edificio> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Edificio buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
