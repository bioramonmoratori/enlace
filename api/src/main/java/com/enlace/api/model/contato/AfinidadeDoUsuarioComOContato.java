package com.enlace.api.model.contato;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class AfinidadeDoUsuarioComOContato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotNull
	private String tituloDaAfinidade;
	@NotNull
	private BigDecimal valorDaAfinidade;
	
	/*
	 * 
	 * 
	 */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTituloDaAfinidade() {
		return tituloDaAfinidade;
	}
	public void setTituloDaAfinidade(String tituloDaAfinidade) {
		this.tituloDaAfinidade = tituloDaAfinidade;
	}
	public BigDecimal getValorDaAfinidade() {
		return valorDaAfinidade;
	}
	public void setValorDaAfinidade(BigDecimal valorDaAfinidade) {
		this.valorDaAfinidade = valorDaAfinidade;
	}
}
