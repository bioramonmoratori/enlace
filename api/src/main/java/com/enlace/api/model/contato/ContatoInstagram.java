package com.enlace.api.model.contato;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.enlace.api.model.CalculoDePrioridadeDoContatoDoInstagram;

@Entity
public class ContatoInstagram extends Contato{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoContato;
	private String fotoDoPerfilURL;
	private Integer numeroDeContasQueOContatoSegue;
	private Integer numeroDeSeguidoresDoContato;
	private Boolean contatoSegueOUsuario;
	private Integer numeroDePostsDoUsuarioQueEsseContatoCurtiu;
	private Integer numeroDePostsDoUsuarioQueEsseContatoComentou;

	
	@Override
	public void calculoDePontuacaoDePrioridadeDoContato() {
		
		BigDecimal prioridadeDoContato = new CalculoDePrioridadeDoContatoDoInstagram().calcularPrioridadeInstagram(
				super.getVinculoAfetivo(),
				this.getContatoSegueOUsuario(),
				super.getFrequenciaDeInteracoes(),
				super.getListaDeInteressesAbordadosNasInteracoes(),
				super.getAfinidadeDoUsuarioComOContato(),
				super.getObjetivosDoUsuarioComOContato(),
				this.numeroDeContasQueOContatoSegue,
				this.numeroDeSeguidoresDoContato,
				this.numeroDePostsDoUsuarioQueEsseContatoCurtiu,
				this.numeroDePostsDoUsuarioQueEsseContatoComentou,
				this.getId(),
				super.getMeuInstagram());
		
		super.pontuacaoDePrioridade = prioridadeDoContato;
	}
	
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

	public String getNomeDoContato() {
		return nomeDoContato;
	}

	public void setNomeDoContato(String nomeDoContato) {
		this.nomeDoContato = nomeDoContato;
	}
	
	public String getFotoDoPerfilURL() {
		return fotoDoPerfilURL;
	}
	
	public void setFotoDoPerfilURL(String fotoDoPerfilURL) {
		this.fotoDoPerfilURL = fotoDoPerfilURL;
	}

	public Boolean getContatoSegueOUsuario() {
		return contatoSegueOUsuario;
	}

	public void setContatoSegueOUsuario(Boolean contatoSegueOUsuario) {
		this.contatoSegueOUsuario = contatoSegueOUsuario;
	}

	public Integer getNumeroDePostsDoUsuarioQueEsseContatoCurtiu() {
		return numeroDePostsDoUsuarioQueEsseContatoCurtiu;
	}

	public void setNumeroDePostsDoUsuarioQueEsseContatoCurtiu(Integer numeroDePostsDoUsuarioQueEsseContatoCurtiu) {
		this.numeroDePostsDoUsuarioQueEsseContatoCurtiu = numeroDePostsDoUsuarioQueEsseContatoCurtiu;
	}

	public Integer getNumeroDePostsDoUsuarioQueEsseContatoComentou() {
		return numeroDePostsDoUsuarioQueEsseContatoComentou;
	}

	public void setNumeroDePostsDoUsuarioQueEsseContatoComentou(Integer numeroDePostsDoUsuarioQueEsseContatoComentou) {
		this.numeroDePostsDoUsuarioQueEsseContatoComentou = numeroDePostsDoUsuarioQueEsseContatoComentou;
	}
	public Integer getNumeroDeContasQueOContatoSegue() {
		return numeroDeContasQueOContatoSegue;
	}

	public void setNumeroDeContasQueOContatoSegue(Integer numeroDeContasQueOContatoSegue) {
		this.numeroDeContasQueOContatoSegue = numeroDeContasQueOContatoSegue;
	}

	public Integer getNumeroDeSeguidoresDoContato() {
		return numeroDeSeguidoresDoContato;
	}

	public void setNumeroDeSeguidoresDoContato(Integer numeroDeSeguidoresDoContato) {
		this.numeroDeSeguidoresDoContato = numeroDeSeguidoresDoContato;
	}
	
}
