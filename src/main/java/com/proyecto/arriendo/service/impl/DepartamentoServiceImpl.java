package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Departamento;
import com.proyecto.arriendo.repository.DepartamentoRepository;
import com.proyecto.arriendo.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoRepository repo;
	
	@Override
	public void Agregar(Departamento departamento) {
		// TODO Auto-generated method stub
		repo.save(departamento);
	}

	@Override
	public void Modificar(Departamento departamento) {
		// TODO Auto-generated method stub
		repo.save(departamento);
	}

	@Override
	public List<Departamento> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Departamento buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Departamento> buscarTodoDisponibles() {
		// TODO Auto-generated method stub
		return repo.buscarTodoDisponibles();
	}

	@Override
	public List<Departamento> buscarTodoDisponiblesPorRegion(long region) {
		// TODO Auto-generated method stub
		return repo.buscarTodoDisponiblesPorRegion(region);
	}

	@Override
	public List<Departamento> buscarTodoDisponiblesPorProvincia(long provincia) {
		// TODO Auto-generated method stub
		return repo.buscarTodoDisponiblesPorProvincia(provincia);
	}

	@Override
	public List<Departamento> buscarTodoDisponiblesPorComuna(long comuna) {
		// TODO Auto-generated method stub
		return repo.buscarTodoDisponiblesPorComuna(comuna);
	}
	
}
