package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Cuenta;
import com.proyecto.arriendo.repository.CuentaRepository;
import com.proyecto.arriendo.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	private CuentaRepository repo;
	
	@Override
	public void agregar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		repo.save(cuenta);
	}

	@Override
	public void modificar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		repo.save(cuenta);

	}

	@Override
	public List<Cuenta> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Cuenta buscar(Long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
