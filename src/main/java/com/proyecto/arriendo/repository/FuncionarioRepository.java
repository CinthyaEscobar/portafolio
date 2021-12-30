package com.proyecto.arriendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.arriendo.model.Cuenta;
import com.proyecto.arriendo.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario findByIdCuenta(Cuenta cuenta);
	
}
