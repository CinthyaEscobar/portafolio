package com.proyecto.arriendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.arriendo.model.CheckOut;

public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {

}
