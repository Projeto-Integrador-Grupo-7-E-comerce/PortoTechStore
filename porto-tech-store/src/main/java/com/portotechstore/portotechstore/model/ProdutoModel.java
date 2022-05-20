package com.portotechstore.portotechstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // Indica que essa classe será uma entidade
@Table(name = "produtos") // Nome da tabela no banco de dados
public class ProdutoModel {
	 
	//teste commit
	// Campos da Tabela: ID,NOME,PRECO_VENDA,PRECO_CUSTO,QTDE_ESTOQUE,DATA_CADASTRO

	// Id do Produto
	@Id // Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerador automático de Ids (Ex: 1,2,3,4,5...)
	private long idProduto;

	// Nome Produtos
	@NotNull // Obrigatório
	@Size(min = 3, max = 30) // Qtde de caracteres no nome
	private String nomeProduto;

	// Preço de Venda
	@NotNull // ??????????? É apenas isso mesmo?
	private double precoVendaProduto;

	// Preço de custo
	@NotNull // ??????????? É apenas isso mesmo?
	private double precoCustoProduto;

	// Qtde Estoque
	@NotNull // ??????????? É apenas isso mesmo?
	private int qtdeEstoqueProduto;

	// Data de Cadastro
	@Temporal(TemporalType.TIMESTAMP) //Informando que o tipo de dado é um tipo date timestamp
	private Date createdDateProduto = new java.sql.Date(System.currentTimeMillis());// Captura a data exata que o dado foi inserido

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoVendaProduto() {
		return precoVendaProduto;
	}

	public void setPrecoVendaProduto(double precoVendaProduto) {
		this.precoVendaProduto = precoVendaProduto;
	}

	public double getPrecoCustoProduto() {
		return precoCustoProduto;
	}

	public void setPrecoCustoProduto(double precoCustoProduto) {
		this.precoCustoProduto = precoCustoProduto;
	}

	public int getQtdeEstoqueProduto() {
		return qtdeEstoqueProduto;
	}

	public void setQtdeEstoqueProduto(int qtdeEstoqueProduto) {
		this.qtdeEstoqueProduto = qtdeEstoqueProduto;
	}

	public Date getCreatedDateProduto() {
		return createdDateProduto;
	}

	public void setCreatedDateProduto(Date createdDateProduto) {
		this.createdDateProduto = createdDateProduto;
	}
		
	
}