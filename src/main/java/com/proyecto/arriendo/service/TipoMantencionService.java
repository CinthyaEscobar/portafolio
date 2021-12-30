package com.proyecto.arriendo.service;

import java.util.List;

import com.proyecto.arriendo.model.TipoMantencion;

public interface TipoMantencionService {
	void agregar(TipoMantencion tipoMantencion);
	void modificar(TipoMantencion tipoMantencion);
	List<TipoMantencion> listar();
	TipoMantencion buscar(long id);


}
