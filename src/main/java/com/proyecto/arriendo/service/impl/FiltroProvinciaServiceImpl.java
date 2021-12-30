package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.FiltroProvincia;
import com.proyecto.arriendo.repository.FiltroProvinciaRepository;
import com.proyecto.arriendo.service.FiltroProvinciaService;

@Service
public class FiltroProvinciaServiceImpl implements FiltroProvinciaService{

	@Autowired
	FiltroProvinciaRepository repo;
	
	@Override
	public List<FiltroProvincia> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
