package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Departamento;

public interface DepartamentoService {
	void Agregar( Departamento departamento);
	void Modificar(Departamento departamento);
	List<Departamento> listar();
	Departamento buscar(long id);
	List<Departamento> buscarTodoDisponibles();
	List<Departamento> buscarTodoDisponiblesPorRegion(long region);
	List<Departamento> buscarTodoDisponiblesPorProvincia(long provincia);
	List<Departamento> buscarTodoDisponiblesPorComuna(long comuna);
	
	
}
