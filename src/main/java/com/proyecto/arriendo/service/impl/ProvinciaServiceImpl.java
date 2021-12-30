package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Provincia;
import com.proyecto.arriendo.repository.ProvinciaRepository;
import com.proyecto.arriendo.service.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	private ProvinciaRepository repo;
	
	@Override
	public List<Provincia> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Provincia buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
