package com.enlace.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.enlace.api.component.enums.Pronome;
import com.enlace.api.model.contato.Contato;
import com.enlace.api.model.contato.Interesse;

@Entity
public class Usuario {
	
	//Faltam atributos Email e Senha para autenticacao
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String nome;
	
	@NonNull
	private Pronome pronome;
	
	@NonNull
	private String cidade;
	
	@ManyToMany(fetch = FetchType.LAZY)
    private List<Interesse> listaDeInteressesDoUsuario = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Contato> listaGeralDeContatos = new ArrayList<>();
	
	@OneToOne
	private MeuInstagram meuInstagram;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pronome getPronome() {
		return pronome;
	}

	public void setPronome(Pronome pronome) {
		this.pronome = pronome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Interesse> getListaDeInteressesDoUsuario() {
		return listaDeInteressesDoUsuario;
	}

	public void setListaDeInteressesDoUsuario(List<Interesse> listaDeInteressesDoUsuario) {
		this.listaDeInteressesDoUsuario = listaDeInteressesDoUsuario;
	}

	public List<Contato> getListaGeralDeContatos() {
		return listaGeralDeContatos;
	}

	public void setListaGeralDeContatos(List<Contato> listaGeralDeContatos) {
		this.listaGeralDeContatos = listaGeralDeContatos;
	}

	public MeuInstagram getMeuInstagram() {
		return meuInstagram;
	}

	public void setMeuInstagram(MeuInstagram meuInstagram) {
		this.meuInstagram = meuInstagram;
	}
	
}
