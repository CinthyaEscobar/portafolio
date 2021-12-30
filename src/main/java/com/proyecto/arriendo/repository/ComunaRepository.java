package com.proyecto.arriendo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.arriendo.model.Comuna;

public interface ComunaRepository  extends JpaRepository<Comuna, Long>{
	
}
