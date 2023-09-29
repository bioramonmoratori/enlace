package com.enlace.api.model.contato;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class ObjetivosDoUsuarioComOContato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tituloDoObjetivo;
	private BigDecimal valorDoObjetivo;
	
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
	public String getTituloDoObjetivo() {
		return tituloDoObjetivo;
	}
	public void setTituloDoObjetivo(String tituloDoObjetivo) {
		this.tituloDoObjetivo = tituloDoObjetivo;
	}
	public BigDecimal getValorDoObjetivo() {
		return valorDoObjetivo;
	}
	public void setValorDoObjetivo(BigDecimal valorDoObjetivo) {
		this.valorDoObjetivo = valorDoObjetivo;
	}
}
