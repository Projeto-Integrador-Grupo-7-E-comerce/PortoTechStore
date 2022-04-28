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

import com.portotechstore.portotechstore.model.ClienteModel;
import com.portotechstore.portotechstore.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

	@Autowired //coloca o spring para executar e gerenciar essa classe, isto é passa a responsabilidade do spring em instanciar e executar os metodos de uma classe do tipo interface
	private ClienteRepository repository;
	
	//Criação dos métodos GET,POST,PUT e DELETE
		@GetMapping//toda vez que tiver uma requisicao da api /produtos, verificara o metodo que chama, se for o GET disparara este metodo
		public ResponseEntity<List<ClienteModel>>GetAll()
		{
			return ResponseEntity.ok(repository.findAll());//.ok resposta do http 
		}
				
		@GetMapping("/{id}") // qual metodo http vou enviar a api - nesse caso o getmapping com parametro do id, para executar esse metodo
		public ResponseEntity<ClienteModel> GetByIdCliente(@PathVariable long id){ // @PathVariable transforma o parametro id em uma variavel para ser usada em (return repository.findById(id))

			return repository.findById(id)
					///retorno de resposta se encontra ok, se nao encontra notFound
					.map(resp -> ResponseEntity.ok(resp))// caso encontra o id na base de dados retorna cod 200 ok
					.orElse(ResponseEntity.notFound().build());//caso nao encontre o id retorna o notFound 
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<ClienteModel>> GetByNome(@PathVariable String nome){ //
			
			return ResponseEntity.ok(repository.findAllByNomeClienteContainingIgnoreCase(nome));
		}
		
		@PostMapping
		public ResponseEntity<ClienteModel> post (@RequestBody ClienteModel cliente){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
		}
		
		@PutMapping
		public ResponseEntity<ClienteModel> put (@RequestBody ClienteModel cliente){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}	
	
	
	
}
