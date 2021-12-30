package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Vehiculo;
import com.proyecto.arriendo.repository.VehiculoRepository;
import com.proyecto.arriendo.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	private VehiculoRepository repo;
	
	@Override
	public void agregar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		repo.save(vehiculo);
	}

	@Override
	public void modificar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		repo.save(vehiculo);
	}

	@Override
	public List<Vehiculo> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Vehiculo buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
