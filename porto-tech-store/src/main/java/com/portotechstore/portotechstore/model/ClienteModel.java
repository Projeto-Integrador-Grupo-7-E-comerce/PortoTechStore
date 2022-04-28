package com.portotechstore.portotechstore.model;

import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "clientes")
public class ClienteModel {
	
	
	//Id Cliente
	@Id //Id do cliente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
			
	@NotNull
	@Size(min=2, max = 20)
	private String nomeCliente;
	
	@NotNull
	@Size(min=11,max=11)
	private String cpfCliente;	
		
	@NotNull
	@Size(min=7,max=40)
	private String emailCliente;
	
	@NotNull
	@Size(min=11)
	private String celularCliente;	
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataNascimentoCliente;
	
	
	@NotNull
	@Size(min=2, max=60)
	private String enderecoCliente;
	
	@NotNull
	@Size(min=1, max=8)
	private String numeroCliente;
	
	@NotNull
	@Size(min=1,max=30)
	private String complementoCliente;
	
	@NotNull
	@Size(min=1,max=20)
	private String bairroCliente;
		
	@NotNull
	@Size(min=2,max=30)
	private String cidadeCliente;
	
	@NotNull
	@Size(min=2,max=2)
	private String estadoCliente;
		
	@NotNull
	@Size(min=8,max=8)
	private String cepCliente;
	
	@Temporal(TemporalType.TIMESTAMP) //Informando que o tipo de dado é um tipo date timestamp
    private Date createdDateClientes = new java.sql.Date(System.currentTimeMillis());//Captura a data exata que o dado  foi inserido

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCelularCliente() {
		return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}

	
	public LocalDate getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	public void setDataNascimentoCliente(LocalDate dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getComplementoCliente() {
		return complementoCliente;
	}

	public void setComplementoCliente(String complementoCliente) {
		this.complementoCliente = complementoCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public Date getCreatedDateClientes() {
		return createdDateClientes;
	}

	public void setCreatedDateClientes(Date createdDateClientes) {
		this.createdDateClientes = createdDateClientes;
	}

	
	
}
