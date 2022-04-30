package com.portotechstore.portotechstore.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity // Indica que essa classe será uma entidade
@Table(name = "tb_vendas") // Nome da tabela no banco de dados
public class VendasModel {
	
	//Id Cliente
		@Id //Id venda
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idVenda;
				
		@NotNull
		private double valorUnitario;//apenas essa informação?
		
		@NotNull
		private int qtdeEstoque;	
			
		@NotNull
		private double total;
		
		@NotNull
		@Size(min=10, max = 20)
		private String formaDePagamento;	
		
		
		@ManyToOne //Associação
	    @JoinColumn(name = "id_cliente") //Nome da coluna
	    ClienteModel cliente;
		
		

	

	
		
}
