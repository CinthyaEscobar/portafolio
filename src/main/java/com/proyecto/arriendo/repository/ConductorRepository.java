package com.proyecto.arriendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.arriendo.model.Conductor;

public interface ConductorRepository  extends JpaRepository<Conductor, Long>{

}
