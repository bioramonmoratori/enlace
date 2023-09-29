package com.enlace.api.model.contato;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class VinculoAfetivo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String tituloDoVinculo;
	@NotNull
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
