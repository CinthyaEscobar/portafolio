package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Departamento;
import com.proyecto.arriendo.model.Item;

public interface ItemService {
	void agregar(Item item);
	void modificar(Item item);
	List<Item> listar();
	Item buscar(long id);
	List<Item> buscarPorDepartamento(Departamento dpto);

}
