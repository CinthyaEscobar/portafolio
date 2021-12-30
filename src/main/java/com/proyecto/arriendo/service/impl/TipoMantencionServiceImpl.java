 package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.TipoMantencion;
import com.proyecto.arriendo.repository.TipoMantencionRepository;
import com.proyecto.arriendo.service.TipoMantencionService;

@Service
public class TipoMantencionServiceImpl implements TipoMantencionService{

	@Autowired
	private TipoMantencionRepository repo;
	@Override
	public void agregar(TipoMantencion tipoMantencion) {
		// TODO Auto-generated method stub
		repo.save(tipoMantencion);
	}

	@Override
	public void modificar(TipoMantencion tipoMantencion) {
		// TODO Auto-generated method stub
		repo.save(tipoMantencion);
	}

	@Override
	public List<TipoMantencion> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public TipoMantencion buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	

}
