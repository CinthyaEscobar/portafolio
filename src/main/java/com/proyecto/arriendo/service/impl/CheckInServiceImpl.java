package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.CheckIn;
import com.proyecto.arriendo.repository.CheckInRepository;
import com.proyecto.arriendo.service.CheckInService;

@Service
public class CheckInServiceImpl implements CheckInService {
	
	@Autowired
	private CheckInRepository repo;

	@Override
	public void agregar(CheckIn checkIn) {
		// TODO Auto-generated method stub
		repo.save(checkIn);
		
	}

	@Override
	public void modificar(CheckIn checkIn) {
		// TODO Auto-generated method stub
		repo.save(checkIn);		
	}

	@Override
	public List<CheckIn> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public CheckIn buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
