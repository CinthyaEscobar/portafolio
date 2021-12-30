package com.proyecto.arriendo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.arriendo.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {

	
	@Query(value = "SELECT T.ID_TOUR, T.LUGAR, T.DESCRIPCION, T.FECHA, T.HORA_COMIENZO, T.HORA_FIN, T.PRECIO, T.CAPACIDAD, T.ACTIVO, T.FOTO, T.ID_DIRECCION FROM TOUR T "
			+ "INNER JOIN DIRECCION D ON T.ID_DIRECCION = D.ID_DIRECCION "
			+ "INNER JOIN COMUNA C ON D.ID_CO = C.ID_CO "
			+ "INNER JOIN PROVINCIA P ON C.ID_PR = P.ID_PR WHERE P.ID_PR = :provincia and T.FECHA between :desde and :hasta", nativeQuery = true)
	List<Tour> buscarParaReserva(long provincia, LocalDate desde, LocalDate hasta);
}
