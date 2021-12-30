package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Departamento;
import com.proyecto.arriendo.model.Item;
import com.proyecto.arriendo.repository.ItemRepository;
import com.proyecto.arriendo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository repo;
	
	@Override
	public void agregar(Item item) {
		// TODO Auto-generated method stub
		repo.save(item);
	}

	@Override
	public void modificar(Item item) {
		// TODO Auto-generated method stub
		repo.save(item);
	}

	@Override
	public List<Item> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Item buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Item> buscarPorDepartamento(Departamento dpto) {
		// TODO Auto-generated method stub
		return repo.findByIdDepartamento(dpto);
	}

}
