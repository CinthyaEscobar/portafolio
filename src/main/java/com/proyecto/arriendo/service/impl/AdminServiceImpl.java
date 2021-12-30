package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Admin;
import com.proyecto.arriendo.repository.AdminRepository;
import com.proyecto.arriendo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository repo;
	
	@Override
	public void agregar(Admin admin) {
		// TODO Auto-generated method stub
		repo.save(admin);
	}

	@Override
	public void modificar(Admin admin) {
		// TODO Auto-generated method stub
		repo.save(admin);
	}

	@Override
	public List<Admin> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Admin buscar(Long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
