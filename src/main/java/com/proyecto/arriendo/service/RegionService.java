package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.Region;

public interface RegionService {

	List<Region> listar();
	Region buscar(long id);
}
