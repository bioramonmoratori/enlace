package com.enlace.api.model.contato;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class FrequenciaDeInteracoes {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String tituloDaFrequencia;
	@NonNull
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
