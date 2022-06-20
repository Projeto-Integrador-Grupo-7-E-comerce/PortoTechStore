package com.portotechstore.portotechstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portotechstore.portotechstore.model.VendaModel;
import com.portotechstore.portotechstore.repository.ProdutoRepository;
import com.portotechstore.portotechstore.repository.VendaRepository;
import com.portotechstore.portotechstore.service.VendaService;

@RestController
@RequestMapping("/vendas")
@CrossOrigin("*")
public class VendaController {

	@Autowired
	VendaRepository vendaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	VendaService vendaService;
	
	@GetMapping
	public ResponseEntity<List<VendaModel>>GetAll(){
		return ResponseEntity.ok(vendaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VendaModel>GetByIdUsuario(@PathVariable long id){
		return vendaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	public ResponseEntity<VendaModel>post(@RequestBody VendaModel venda){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.criarVenda(venda));
	}
	
	@PutMapping
	public ResponseEntity<VendaModel> put (@RequestBody VendaModel venda){
		return ResponseEntity.status(HttpStatus.OK).body(vendaRepository.save(venda));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		vendaRepository.deleteById(id);
	}	
}