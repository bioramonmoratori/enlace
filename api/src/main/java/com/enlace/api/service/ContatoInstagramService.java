package com.enlace.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.AlterarContatoInstagramException;
import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.BuscarContatoInstagramPorIdException;
import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.CriarContatoInstagramException;
import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.DeletarContatoInstagramPorIdException;
import com.enlace.api.component.interfaces.repository.ContatoInstagramRepository;
import com.enlace.api.model.contato.ContatoInstagram;

/*
 * CRUD de ContatoInstagram
 */

@Service
public class ContatoInstagramService {
    
    @Autowired
    ContatoInstagramRepository contatoInstagramRepository;

    public ContatoInstagram criarContatoInstagram(ContatoInstagram contatoInstagram) throws CriarContatoInstagramException {
        
        try{
            contatoInstagram = contatoInstagramRepository.save(contatoInstagram);
            return contatoInstagram;
        }
        catch(Exception e){
            throw new CriarContatoInstagramException();
        }
    }

    public ContatoInstagram buscarContatoInstagramPorId(Long id) throws BuscarContatoInstagramPorIdException{
        
        try{
            ContatoInstagram contatoInstagram = contatoInstagramRepository.findById(id).get();
            return contatoInstagram;
        }
        catch(Exception e){
            throw new BuscarContatoInstagramPorIdException();
        }
    }

    public void deletarContatoInstagramPorId(Long id) 
        throws DeletarContatoInstagramPorIdException{

        try{
            ContatoInstagram contatoInstagram = contatoInstagramRepository.findById(id).get();
            contatoInstagramRepository.delete(contatoInstagram);

        } catch(Exception e){
            throw new DeletarContatoInstagramPorIdException();
        }
    }

    public ContatoInstagram alterarContatoInstagram(ContatoInstagram informacoesDeAlteracaoDoContato) throws AlterarContatoInstagramException{

        try{
            ContatoInstagram contatoInstagram = contatoInstagramRepository.findById(informacoesDeAlteracaoDoContato.getId()).get();
            contatoInstagramRepository.save(contatoInstagram);
            return contatoInstagram;
        }
        catch(Exception e){
            throw new AlterarContatoInstagramException();
        }
    }

    public void calcularPrioridadeDoContatoInstagram(Long idDoContato) {
        ContatoInstagram contatoInstagram = contatoInstagramRepository.findById(idDoContato).get();
        contatoInstagram.calculoDePontuacaoDePrioridadeDoContato();
    }

}
