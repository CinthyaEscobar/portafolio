package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Region;
import com.proyecto.arriendo.repository.RegionRepository;
import com.proyecto.arriendo.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	private RegionRepository repo;
	
	@Override
	public List<Region> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Region buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
