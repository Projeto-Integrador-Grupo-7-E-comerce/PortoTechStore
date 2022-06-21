package com.portotechstore.portotechstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portotechstore.portotechstore.model.UsuarioModel;
import com.portotechstore.portotechstore.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<UsuarioModel> post (@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());//.ok resposta do http 
	}

	@GetMapping("/{id}") // qual metodo http vou enviar a api - nesse caso o getmapping com parametro do id, para executar esse metodo
	public ResponseEntity<UsuarioModel> GetByIdProduto(@PathVariable long id){ // @PathVariable transforma o parametro id em uma variavel para ser usada em (return repository.findById(id))

		return repository.findById(id)
				///retorno de resposta se encontra ok, se nao encontra notFound
				.map(resp -> ResponseEntity.ok(resp))// caso encontra o id na base de dados retorna cod 200 ok
				.orElse(ResponseEntity.notFound().build());//caso nao encontre o id retorna o notFound 
	}
}
