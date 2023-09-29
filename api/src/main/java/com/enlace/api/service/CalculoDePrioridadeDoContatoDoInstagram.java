package com.enlace.api.service;

import java.math.BigDecimal;
import java.util.List;

import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.CalculoDePrioridadeException;
import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.CalculoDePrioridadeValoresNulosException;
import com.enlace.api.model.MeuInstagram;
import com.enlace.api.model.contato.AfinidadeDoUsuarioComOContato;
import com.enlace.api.model.contato.FrequenciaDeInteracoes;
import com.enlace.api.model.contato.Interesse;
import com.enlace.api.model.contato.ObjetivosDoUsuarioComOContato;
import com.enlace.api.model.contato.VinculoAfetivo;

public class CalculoDePrioridadeDoContatoDoInstagram {
	
	/*
	 * Calculos do quanto o contato e relevante para o usuario
	 * com base nas informacoes fornecidas pelo proprio usuario 
	 * e pela coleta de metricas do seu Instagram
	 */
	
	public BigDecimal calcularPrioridadeInstagram(
			VinculoAfetivo vinculoAfetivo, 
			Boolean contatoSegueOUsuario, 
			FrequenciaDeInteracoes frequenciaDeInteracao, 
			List<Interesse> listaDeInteressesAbordadosNasInteracoes, 
			AfinidadeDoUsuarioComOContato afinidadeDoUsuarioComOContato, 
			ObjetivosDoUsuarioComOContato objetivosDoUsuarioComOContato, 
			Integer numeroDeContasQueOContatoSegue,
			Integer numeroDeSeguidoresDoContato, 
			Integer numeroDePostsDoUsuarioQueEsseContatoCurtiu, 
			Integer numeroDePostsDoUsuarioQueEsseContatoComentou, 
			Long id,
			MeuInstagram meuInstagram) {
		
		if(vinculoAfetivo == null ||
			contatoSegueOUsuario == null ||
			frequenciaDeInteracao == null ||
			listaDeInteressesAbordadosNasInteracoes == null ||
			afinidadeDoUsuarioComOContato == null ||
			objetivosDoUsuarioComOContato == null ||
			numeroDeContasQueOContatoSegue == null ||
			numeroDeSeguidoresDoContato == null ||
			numeroDePostsDoUsuarioQueEsseContatoCurtiu == null ||
			numeroDePostsDoUsuarioQueEsseContatoComentou == null ||
			id == null ||
			meuInstagram == null) {
				throw new CalculoDePrioridadeValoresNulosException();
		}
		try{
			BigDecimal valorDaPrioridade = new BigDecimal(0.00);
			
			valorDaPrioridade.add(vinculoAfetivo.getValorDoVinculo());
			valorDaPrioridade.add(frequenciaDeInteracao.getValorDaFrequencia());
			valorDaPrioridade.add(afinidadeDoUsuarioComOContato.getValorDaAfinidade());
			valorDaPrioridade.add(objetivosDoUsuarioComOContato.getValorDoObjetivo());
			
			/*
			* Regras de curtidas e comentarios
			*/
			
			if(numeroDePostsDoUsuarioQueEsseContatoCurtiu / meuInstagram.getNumeroDePublicacoes() > 0.15) {
				valorDaPrioridade.add(new BigDecimal(10.00));
			}
			
			if(numeroDePostsDoUsuarioQueEsseContatoComentou / meuInstagram.getNumeroDePublicacoes() > 0.15) {
				valorDaPrioridade.add(new BigDecimal(10.00));
			}
			
			/*
			* O Contato segue o Usuario
			*/
			
			if(contatoSegueOUsuario == true) {
				valorDaPrioridade.add(new BigDecimal(10.00));
			}
			
			/*
			* Lista de Interesses
			*/
			
			if(listaDeInteressesAbordadosNasInteracoes.size() <= 2) {
				valorDaPrioridade.add(new BigDecimal(2.00));
			} else if(listaDeInteressesAbordadosNasInteracoes.size() > 2 && 
					listaDeInteressesAbordadosNasInteracoes.size() <= 5 ) {
				valorDaPrioridade.add(new BigDecimal(5.00));
			} else if(listaDeInteressesAbordadosNasInteracoes.size() > 5 && 
					listaDeInteressesAbordadosNasInteracoes.size() <= 7 ) {
				valorDaPrioridade.add(new BigDecimal(8.00));
			} else if(listaDeInteressesAbordadosNasInteracoes.size() > 7) {
				valorDaPrioridade.add(new BigDecimal(10.00));
			}
			
			/*
			* Se o contato e um HUB de outros contatos
			*/
			
			if(numeroDeSeguidoresDoContato / numeroDeContasQueOContatoSegue > 1.5 && numeroDeSeguidoresDoContato >= 800) {
				valorDaPrioridade.add(new BigDecimal(2.00));
			}

			return valorDaPrioridade;
		} catch(Exception e) {
			throw new CalculoDePrioridadeException();
		}
		
	}
	
	
	
}
