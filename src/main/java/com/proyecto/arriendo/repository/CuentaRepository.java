package com.proyecto.arriendo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.arriendo.model.Cuenta;


public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
	
	Cuenta findByCorreo(String correo);	

}
