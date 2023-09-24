package com.enlace.api.model.contato;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Interesse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String tituloDoInteresse;
	@NonNull
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
