package com.proyecto.arriendo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.arriendo.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
	@Query(value = "select d.id_departamento, d.numero, d.piso, d.tarifa, d.porcentaje_reserva, d.descripcion, d.activo, d.id_estado, d.id_edificio, d.foto "
			+ "from departamento d "
			+ "full outer join reserva r on d.id_departamento is null or r.id_reserva is null "
			+ "left join edificio e on d.id_edificio = e.id_edificio "
			+ "left join direccion di on e.id_direccion = di.id_direccion "
			+ "left join comuna c on di.id_co = c.id_co "
			+ "left join provincia pro on c.id_pr = pro.id_pr "
			+ "left join region re on pro.id_re = re.id_re where d.id_estado = 1", nativeQuery = true)
	List<Departamento> buscarTodoDisponibles();
	
	@Query(value = "select d.id_departamento, d.numero, d.piso, d.tarifa, d.porcentaje_reserva, d.descripcion, d.activo, d.id_estado, d.id_edificio, d.foto "
			+ "from departamento d "
			+ "full outer join reserva r on d.id_departamento is null or r.id_reserva is null "
			+ "left join edificio e on d.id_edificio = e.id_edificio "
			+ "left join direccion di on e.id_direccion = di.id_direccion "
			+ "left join comuna c on di.id_co = c.id_co "
			+ "left join provincia pro on c.id_pr = pro.id_pr "
			+ "left join region re on pro.id_re = re.id_re where re.id_re = :region and d.id_estado = 1", nativeQuery = true)
	List<Departamento> buscarTodoDisponiblesPorRegion(long region);
	
	@Query(value = "select d.id_departamento, d.numero, d.piso, d.tarifa, d.porcentaje_reserva, d.descripcion, d.activo, d.id_estado, d.id_edificio, d.foto "
			+ "from departamento d "
			+ "full outer join reserva r on d.id_departamento is null or r.id_reserva is null "
			+ "left join edificio e on d.id_edificio = e.id_edificio "
			+ "left join direccion di on e.id_direccion = di.id_direccion "
			+ "left join comuna c on di.id_co = c.id_co "
			+ "left join provincia pro on c.id_pr = pro.id_pr "
			+ "left join region re on pro.id_re = re.id_re where pro.id_pr = :provincia and d.id_estado = 1", nativeQuery = true)
	List<Departamento> buscarTodoDisponiblesPorProvincia(long provincia);
	
	@Query(value = "select d.id_departamento, d.numero, d.piso, d.tarifa, d.porcentaje_reserva, d.descripcion, d.activo, d.id_estado, d.id_edificio, d.foto "
			+ "from departamento d "
			+ "full outer join reserva r on d.id_departamento is null or r.id_reserva is null "
			+ "left join edificio e on d.id_edificio = e.id_edificio "
			+ "left join direccion di on e.id_direccion = di.id_direccion "
			+ "left join comuna c on di.id_co = c.id_co "
			+ "left join provincia pro on c.id_pr = pro.id_pr "
			+ "left join region re on pro.id_re = re.id_re where c.id_co = :comuna and d.id_estado = 1", nativeQuery = true)
	List<Departamento> buscarTodoDisponiblesPorComuna(long comuna);
	

}
