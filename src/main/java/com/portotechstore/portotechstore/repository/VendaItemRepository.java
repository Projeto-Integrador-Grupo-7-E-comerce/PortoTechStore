package com.portotechstore.portotechstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portotechstore.portotechstore.model.UsuarioModel;
import com.portotechstore.portotechstore.model.VendaItemModel;

public interface VendaItemRepository extends JpaRepository<VendaItemModel, Long>{

	public Optional<Long> findFirstByOrderByIdCarrinhoDesc();

	
	public List<VendaItemModel> findAllByUsuarioOrderByCreatedDateProdutoDesc(UsuarioModel usuario);
	
}
