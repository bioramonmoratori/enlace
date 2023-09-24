package com.enlace.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.CriarContatoInstagramException;
import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.ListarContatosException;
import com.enlace.api.component.exceptions.UsuarioExceptions.AlterarUsuarioException;
import com.enlace.api.component.exceptions.UsuarioExceptions.BuscarUsuarioPorIdException;
import com.enlace.api.component.exceptions.UsuarioExceptions.DeletarUsuarioException;
import com.enlace.api.component.exceptions.UsuarioExceptions.SalvarUsuarioException;
import com.enlace.api.component.interfaces.repository.ContatoInstagramRepository;
import com.enlace.api.component.interfaces.repository.UsuarioRepository;
import com.enlace.api.model.Usuario;
import com.enlace.api.model.contato.Contato;
import com.enlace.api.model.contato.ContatoInstagram;

/*
 * CRUD Usuario
 */

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ContatoInstagramRepository contatoInstagramRepository;

    public Usuario criarUsuario(Usuario usuario) throws SalvarUsuarioException {
        
        try{
            usuario = usuarioRepository.save(usuario);
            return usuario;
        }
        catch(Exception e){
            throw new SalvarUsuarioException();
        }
    }

    public Usuario buscarUsuarioPorId(Long id) throws BuscarUsuarioPorIdException{
        
        try{
            Usuario usuario = usuarioRepository.findById(id).get();
            return usuario;
        }
        catch(Exception e){
            throw new BuscarUsuarioPorIdException();
        }
    }

    public void deletarUsuarioPorId(Long id) 
        throws DeletarUsuarioException{

        try{
            Usuario usuario = usuarioRepository.findById(id).get();
            usuarioRepository.delete(usuario);

        } catch(Exception e){
            throw new DeletarUsuarioException();
        }
    }
    
    public Usuario atualizarUsuario(Usuario informacoesDeAlteracaoDoUsuario) throws AlterarUsuarioException{
        try{
            Usuario usuario = usuarioRepository.findById(informacoesDeAlteracaoDoUsuario.getId()).get();
            usuarioRepository.save(usuario);
            return usuario;
        } catch(Exception e){
            throw new AlterarUsuarioException();
        }
    }

    public List<Contato> criarContatoInstagram(Long usuarioID, ContatoInstagram contatoInstagram) throws CriarContatoInstagramException {
        
        try{
            Usuario usuario = usuarioRepository.findById(usuarioID).get();
            usuario.getListaGeralDeContatos().add(contatoInstagram);

            contatoInstagramRepository.save(contatoInstagram);
            usuario = usuarioRepository.save(usuario);

            return (List<Contato>) usuario.getListaGeralDeContatos();
        }
        catch(Exception e){
            throw new CriarContatoInstagramException();
        }
    }

    public List<Contato> listarContatos(Long usuarioID) throws ListarContatosException {

        try{
            Usuario usuario = usuarioRepository.findById(usuarioID).get();
            return (List<Contato>) usuario.getListaGeralDeContatos();
        } catch(Exception e){
            throw new ListarContatosException();
        }
    }

}
