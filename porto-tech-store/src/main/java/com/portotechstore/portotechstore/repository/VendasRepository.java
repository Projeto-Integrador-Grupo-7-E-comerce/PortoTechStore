package com.portotechstore.portotechstore.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.portotechstore.portotechstore.model.VendasModel;


public interface VendasRepository extends JpaRepository<VendasModel,Long>{

	@Autowired	
	public List<VendasModel>findAllByNomeProdutoContainingIgnoreCase(String nome);

}
