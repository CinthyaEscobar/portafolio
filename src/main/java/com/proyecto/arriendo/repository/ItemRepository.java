package com.proyecto.arriendo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.arriendo.model.Departamento;
import com.proyecto.arriendo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findByIdDepartamento(Departamento dpto);
}
