package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Cuenta;
import com.proyecto.arriendo.model.Funcionario;
import com.proyecto.arriendo.repository.FuncionarioRepository;
import com.proyecto.arriendo.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	@Override
	public void agregar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		repo.save(funcionario);
	}

	@Override
	public void modificar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		repo.save(funcionario);
	}

	@Override
	public List<Funcionario> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Funcionario buscar(Long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public Funcionario buscarPorCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return repo.findByIdCuenta(cuenta);
	}

}
