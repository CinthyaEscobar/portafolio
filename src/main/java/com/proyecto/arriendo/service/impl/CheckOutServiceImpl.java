package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.CheckOut;
import com.proyecto.arriendo.repository.CheckOutRepository;
import com.proyecto.arriendo.service.CheckOutService;

@Service
public class CheckOutServiceImpl implements CheckOutService{
	
	@Autowired
	private CheckOutRepository repo;

	@Override
	public void agregar(CheckOut checkIn) {
		// TODO Auto-generated method stub
		repo.save(checkIn);
	}

	@Override
	public void modificar(CheckOut checkIn) {
		// TODO Auto-generated method stub
		repo.save(checkIn);
	}

	@Override
	public List<CheckOut> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public CheckOut buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
