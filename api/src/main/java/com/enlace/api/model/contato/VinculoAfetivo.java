package com.enlace.api.model.contato;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class VinculoAfetivo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String tituloDoVinculo;
	@NonNull
	private BigDecimal valorDoVinculo;
	
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
	public String getTituloDoVinculo() {
		return tituloDoVinculo;
	}
	public void setTituloDoVinculo(String tituloDoVinculo) {
		this.tituloDoVinculo = tituloDoVinculo;
	}
	public BigDecimal getValorDoVinculo() {
		return valorDoVinculo;
	}
	public void setValorDoVinculo(BigDecimal valorDoVinculo) {
		this.valorDoVinculo = valorDoVinculo;
	}
}
