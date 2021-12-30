package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Test;
import com.proyecto.arriendo.repository.TestRepository;
import com.proyecto.arriendo.service.testService;

@Service
public class TestServiceImpl implements testService{

	@Autowired
	public TestRepository repo;
	

	@Override
	public List<Test> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
