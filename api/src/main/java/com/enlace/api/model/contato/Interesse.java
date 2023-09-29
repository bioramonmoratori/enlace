package com.enlace.api.model.contato;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class Interesse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String tituloDoInteresse;
	@NotNull
	private BigDecimal valorDoInteresse;
	
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
	public String getTituloDoInteresse() {
		return tituloDoInteresse;
	}
	public void setTituloDoInteresse(String tituloDoInteresse) {
		this.tituloDoInteresse = tituloDoInteresse;
	}
	public BigDecimal getValorDoInteresse() {
		return valorDoInteresse;
	}
	public void setValorDoInteresse(BigDecimal valorDoInteresse) {
		this.valorDoInteresse = valorDoInteresse;
	}
}
