package com.enlace.api.model;

import java.util.ArrayList;
import java.util.List;


import com.enlace.api.model.contato.ContatoInstagram;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class MeuInstagram {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDeContasQueOUsuarioSegue;
	private Integer numeroDeSeguidoresDoUsuario;
	private Integer numeroDePublicacoes;

	@OneToMany
	private List<Publicacao> listaDePublicacao = new ArrayList<>();

	@OneToMany
	private List<ContatoInstagram> listaDeContatosQueSeguemDeVolta = new ArrayList<>();
	private String nomeDoUsuarioDaConta;
	
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
	public Integer getNumeroDeContasQueOUsuarioSegue() {
		return numeroDeContasQueOUsuarioSegue;
	}
	public void setNumeroDeContasQueOUsuarioSegue(Integer numeroDeContasQueOUsuarioSegue) {
		this.numeroDeContasQueOUsuarioSegue = numeroDeContasQueOUsuarioSegue;
	}
	public Integer getNumeroDeSeguidoresDoUsuario() {
		return numeroDeSeguidoresDoUsuario;
	}
	public void setNumeroDeSeguidoresDoUsuario(Integer numeroDeSeguidoresDoUsuario) {
		this.numeroDeSeguidoresDoUsuario = numeroDeSeguidoresDoUsuario;
	}
	public Integer getNumeroDePublicacoes() {
		return numeroDePublicacoes;
	}
	public void setNumeroDePublicacoes(Integer numeroDePublicacoes) {
		this.numeroDePublicacoes = numeroDePublicacoes;
	}
	public List<Publicacao> getListaDePublicacao() {
		return listaDePublicacao;
	}
	public void setListaDePublicacao(List<Publicacao> listaDePublicacao) {
		this.listaDePublicacao = listaDePublicacao;
	}
	public List<ContatoInstagram> getListaDeContatosQueSeguemDeVolta() {
		return listaDeContatosQueSeguemDeVolta;
	}
	public void setListaDeContatosQueSeguemDeVolta(List<ContatoInstagram> listaDeContatosQueSeguemDeVolta) {
		this.listaDeContatosQueSeguemDeVolta = listaDeContatosQueSeguemDeVolta;
	}
	public String getNomeDoUsuarioDaConta() {
		return nomeDoUsuarioDaConta;
	}
	public void setNomeDoUsuarioDaConta(String nomeDoUsuarioDaConta) {
		this.nomeDoUsuarioDaConta = nomeDoUsuarioDaConta;
	}
	
	
}
