package com.portotechstore.portotechstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portotechstore.portotechstore.model.ClienteModel;
import com.portotechstore.portotechstore.model.ProdutoModel;
import com.portotechstore.portotechstore.model.VendaModel;
import com.portotechstore.portotechstore.repository.ClienteRepository;
import com.portotechstore.portotechstore.repository.ProdutoRepository;
import com.portotechstore.portotechstore.repository.VendaRepository;
@Service
public class VendaService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	VendaRepository vendaRepository;
	
	public VendaModel saveVenda(VendaModel venda){
		ProdutoModel produto = produtoRepository.getById(venda.getProduto().getIdProduto());
		ClienteModel cliente = clienteRepository.getById(venda.getCliente().getIdCliente());
		//Nome cliente e produto
		venda.setNomeCliente(cliente.getNomeCliente());
		venda.setNomeProduto(produto.getNomeProduto());
		venda.setValorUnitarioProduto(produto.getPrecoVendaProduto());
		//Total vendido
		double precoVendaProduto = produto.getPrecoVendaProduto();
		venda.setTotal(calcularTotalVendido(precoVendaProduto,venda.getQtdeProduto(),venda.getDescontoProduto()));
		//Baixando produto
		baixaProduto(produto, venda.getQtdeProduto());
		
		return vendaRepository.save(venda);
		
	}
	
	
	public double calcularTotalVendido(double precoVendaProduto,double  qtdeVendida, Double desconto) {
		
		if(desconto == null) {
			desconto = 0.0;
		}
		return (precoVendaProduto * qtdeVendida) - desconto;
	}
	
	public void baixaProduto(ProdutoModel produto, int qtdeBaixa) {
		
		//if (qtdeBaixa > produto.getQtdeEstoqueProduto()){
		//      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		//}
		
		produto.setQtdeEstoqueProduto(produto.getQtdeEstoqueProduto() - qtdeBaixa);
		produtoRepository.save(produto);
		
	}
	
}