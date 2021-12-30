package com.proyecto.arriendo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.arriendo.model.ReservaTour;

public interface ReservaTourRepository  extends JpaRepository<ReservaTour, Long>{

	@Query(value = "select rt.id_reservatour,rt.id_reserva, rt.id_tour from reserva_tour rt "
			+ "inner join reserva r on rt.id_reserva = r.id_reserva where r.id_reserva = :id", nativeQuery = true)
	List<ReservaTour> findByReserva(long id);
}
