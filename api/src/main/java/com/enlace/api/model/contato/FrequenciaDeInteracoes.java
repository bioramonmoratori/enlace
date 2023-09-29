package com.enlace.api.model.contato;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class FrequenciaDeInteracoes {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String tituloDaFrequencia;
	@NotNull
	private BigDecimal valorDaFrequencia;
	
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
	public String getTituloDaFrequencia() {
		return tituloDaFrequencia;
	}
	public void setTituloDaFrequencia(String tituloDaFrequencia) {
		this.tituloDaFrequencia = tituloDaFrequencia;
	}
	public BigDecimal getValorDaFrequencia() {
		return valorDaFrequencia;
	}
	public void setValorDaFrequencia(BigDecimal valorDaFrequencia) {
		this.valorDaFrequencia = valorDaFrequencia;
	}
}
