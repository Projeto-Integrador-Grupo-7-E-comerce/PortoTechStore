package com.portotechstore.portotechstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portotechstore.portotechstore.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {

}
