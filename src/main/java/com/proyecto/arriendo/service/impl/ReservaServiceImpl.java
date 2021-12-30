package com.proyecto.arriendo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.model.Cliente;
import com.proyecto.arriendo.model.Reserva;
import com.proyecto.arriendo.repository.ReservaRepository;
import com.proyecto.arriendo.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository repo;
	
	@Override
	public void agregar(Reserva reserva) {
		// TODO Auto-generated method stub
		repo.save(reserva);
	}

	@Override
	public void modificar(Reserva reserva) {
		// TODO Auto-generated method stub
		repo.save(reserva);
	}

	@Override
	public List<Reserva> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Reserva buscar(long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Reserva> listarPorCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return repo.findByIdCliente(cliente);
	}

	@Override
	public List<Reserva> listarPorFuncionario(long id) {
		// TODO Auto-generated method stub
		return repo.findByFuncionario(id);
	}

}
