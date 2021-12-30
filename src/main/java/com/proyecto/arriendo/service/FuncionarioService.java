package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Cuenta;
import com.proyecto.arriendo.model.Funcionario;

public interface FuncionarioService {
	void agregar (Funcionario funcionario);
	void modificar (Funcionario funcionario);
	List<Funcionario> listar();
	Funcionario buscar(Long id);
	Funcionario buscarPorCuenta(Cuenta cuenta);
	
}
