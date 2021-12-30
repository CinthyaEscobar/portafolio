package com.proyecto.arriendo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.arriendo.model.Cliente;
import com.proyecto.arriendo.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	List<Reserva> findByIdCliente(Cliente cliente);

	@Query(value = "select r.id_reserva, r.fecha_ingreso, r.fecha_salida, r.pago_reserva, r.total_pagar, r.id_reservaestado, r.id_cliente, r.id_transporte, r.id_departamento from reserva r "
			+ "inner join departamento d on r.id_departamento = d.id_departamento "
			+ "inner join edificio e on d.id_edificio = e.id_edificio "
			+ "inner join funcionario f on e.id_edificio = f.id_edificio where f.id_funcionario = :id and r.id_reservaestado <> 4", nativeQuery = true)
	List<Reserva> findByFuncionario(long id);
}
