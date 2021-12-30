package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.TipoCuenta;
import com.proyecto.arriendo.repository.TipoCuentaRepository;
import com.proyecto.arriendo.service.TipoCuentaService;

@Service
public class TipoCuentaImpl implements TipoCuentaService{

	@Autowired
	private TipoCuentaRepository repo;
	
	@Override
	public void agregar(TipoCuenta tipocuenta) {
		// TODO Auto-generated method stub
		repo.save(tipocuenta);
	}

	@Override
	public void modificar(TipoCuenta tipocuenta) {
		// TODO Auto-generated method stub
		repo.save(tipocuenta);
	}

	@Override
	public List<TipoCuenta> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public TipoCuenta buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
