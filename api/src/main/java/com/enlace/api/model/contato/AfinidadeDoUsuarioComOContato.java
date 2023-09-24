package com.enlace.api.model.contato;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class AfinidadeDoUsuarioComOContato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NonNull
	private String tituloDaAfinidade;
	@NonNull
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
