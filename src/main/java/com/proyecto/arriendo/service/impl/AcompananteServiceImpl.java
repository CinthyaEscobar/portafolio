package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Acompanante;
import com.proyecto.arriendo.repository.AcompananteRepository;
import com.proyecto.arriendo.service.AcompananteService;

@Service
public class AcompananteServiceImpl  implements AcompananteService {
	
	@Autowired
	private AcompananteRepository repo;
	
	@Override
	public void agregar(Acompanante acompanante) {
		// TODO Auto-generated method stub
		repo.save(acompanante);
	}

	@Override
	public void modificar(Acompanante acompanante) {
		// TODO Auto-generated method stub
		repo.save(acompanante);
	}

	@Override
	public List<Acompanante> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Acompanante buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
