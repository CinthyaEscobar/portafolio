package com.proyecto.arriendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.arriendo.model.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn, Long>{

}
