package com.enlace.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


import com.enlace.api.model.contato.Contato;

@Entity
public class Publicacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private List<Contato> listaDeContatosQueCurtiram = new ArrayList<>();

	@ManyToMany
	private List<Contato> listaDeContatosQueComentaram = new ArrayList<>();
	
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
	public List<Contato> getListaDeContatosQueCurtiram() {
		return listaDeContatosQueCurtiram;
	}
	public void setListaDeContatosQueCurtiram(List<Contato> listaDeContatosQueCurtiram) {
		this.listaDeContatosQueCurtiram = listaDeContatosQueCurtiram;
	}
	public List<Contato> getListaDeContatosQueComentaram() {
		return listaDeContatosQueComentaram;
	}
	public void setListaDeContatosQueComentaram(List<Contato> listaDeContatosQueComentaram) {
		this.listaDeContatosQueComentaram = listaDeContatosQueComentaram;
	}
	
	
	
}
