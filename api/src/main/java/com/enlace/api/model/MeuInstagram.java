package com.enlace.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.enlace.api.model.contato.ContatoInstagram;

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
