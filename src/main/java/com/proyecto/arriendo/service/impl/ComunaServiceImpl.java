package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Comuna;
import com.proyecto.arriendo.repository.ComunaRepository;
import com.proyecto.arriendo.service.ComunaService;

@Service
public class ComunaServiceImpl implements ComunaService{

	@Autowired
	private ComunaRepository repo;
	
	@Override
	public List<Comuna> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Comuna buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
