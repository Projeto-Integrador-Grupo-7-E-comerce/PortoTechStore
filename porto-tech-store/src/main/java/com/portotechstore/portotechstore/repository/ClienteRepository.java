package com.portotechstore.portotechstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portotechstore.portotechstore.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel,Long>{

	public List<ClienteModel>findAllByNomeClienteContainingIgnoreCase(String nome);
	
	
}
