package com.proyecto.arriendo.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<T,ID> extends Repository<T, ID> {
	
	List<T> findAll();

}
