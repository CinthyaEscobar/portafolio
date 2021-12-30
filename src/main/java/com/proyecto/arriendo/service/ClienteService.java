package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Cliente;

public interface ClienteService {
	void agregar (Cliente cliente);
	void modificar (Cliente cliente);
	List<Cliente> listar();
	Cliente buscar(long id);
}
