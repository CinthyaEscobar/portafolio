package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Admin;

public interface AdminService {
	void agregar(Admin admin);
	void modificar(Admin admin);
	List<Admin> listar();
	Admin buscar(Long id);

}
