package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Cliente;
import com.proyecto.arriendo.repository.ClienteRepository;
import com.proyecto.arriendo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		repo.save(cliente);
	}

	@Override
	public void modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		repo.save(cliente);
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Cliente buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
