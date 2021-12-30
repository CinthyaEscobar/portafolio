package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Transporte;
import com.proyecto.arriendo.repository.TransporteRepository;
import com.proyecto.arriendo.service.TransporteService;

@Service
public class TransporteServiceImpl implements TransporteService{
	@Autowired
	private TransporteRepository repo;

	@Override
	public void agregar(Transporte transporte) {
		// TODO Auto-generated method stub
		repo.save(transporte);
		
	}

	@Override
	public void modificar(Transporte transporte) {
		// TODO Auto-generated method stub
		repo.save(transporte);
		
	}

	@Override
	public List<Transporte> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Transporte buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}
}
