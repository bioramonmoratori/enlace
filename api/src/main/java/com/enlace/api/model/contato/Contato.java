package com.enlace.api.model.contato;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

import com.enlace.api.component.interfaces.CalculoPontuacaoDePrioridade;
import com.enlace.api.model.MeuInstagram;

@Entity
public abstract class Contato implements CalculoPontuacaoDePrioridade{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nomeDoContato;
	
	protected BigDecimal pontuacaoDePrioridade;

	@ManyToOne
	private VinculoAfetivo vinculoAfetivo;
	

	@ManyToOne
	private FrequenciaDeInteracoes frequenciaDeInteracoes;
	

	@ManyToOne
	private AfinidadeDoUsuarioComOContato afinidadeDoUsuarioComOContato;
	

	@ManyToOne
	private ObjetivosDoUsuarioComOContato objetivosDoUsuarioComOContato;

	
	@ManyToMany
	private List<Interesse> listaDeInteressesAbordadosNasInteracoes = new ArrayList<>();
	
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
	public String getNomeDoContato() {
		return nomeDoContato;
	}
	public void setNomeDoContato(String nomeDoContato) {
		this.nomeDoContato = nomeDoContato;
	}
	public BigDecimal getPontuacaoDePrioridade() {
		return pontuacaoDePrioridade;
	}
	public VinculoAfetivo getVinculoAfetivo() {
		return vinculoAfetivo;
	}
	public FrequenciaDeInteracoes getFrequenciaDeInteracoes() {
		return frequenciaDeInteracoes;
	}
	public void setFrequenciaDeInteracoes(FrequenciaDeInteracoes frequenciaDeInteracoes) {
		this.frequenciaDeInteracoes = frequenciaDeInteracoes;
	}
	public AfinidadeDoUsuarioComOContato getAfinidadeDoUsuarioComOContato() {
		return afinidadeDoUsuarioComOContato;
	}
	public void setAfinidadeDoUsuarioComOContato(AfinidadeDoUsuarioComOContato afinidadeDoUsuarioComOContato) {
		this.afinidadeDoUsuarioComOContato = afinidadeDoUsuarioComOContato;
	}
	public ObjetivosDoUsuarioComOContato getObjetivosDoUsuarioComOContato() {
		return objetivosDoUsuarioComOContato;
	}
	public void setObjetivosDoUsuarioComOContato(ObjetivosDoUsuarioComOContato objetivosDoUsuarioComOContato) {
		this.objetivosDoUsuarioComOContato = objetivosDoUsuarioComOContato;
	}
	public void setVinculoAfetivo(VinculoAfetivo vinculoAfetivo) {
		this.vinculoAfetivo = vinculoAfetivo;
	}
	public List<Interesse> getListaDeInteressesAbordadosNasInteracoes() {
		return listaDeInteressesAbordadosNasInteracoes;
	}
	public void setListaDeInteressesAbordadosNasInteracoes(List<Interesse> listaDeInteressesAbordadosNasInteracoes) {
		this.listaDeInteressesAbordadosNasInteracoes = listaDeInteressesAbordadosNasInteracoes;
	}
	public MeuInstagram getMeuInstagram() {
		return meuInstagram;
	}
	public void setMeuInstagram(MeuInstagram meuInstagram) {
		this.meuInstagram = meuInstagram;
	}
	
	
}
