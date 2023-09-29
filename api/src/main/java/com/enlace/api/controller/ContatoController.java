package com.enlace.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlace.api.component.dto.ContatoInstagramDto;
import com.enlace.api.model.contato.Contato;
import com.enlace.api.model.contato.ContatoInstagram;
import com.enlace.api.service.ContatoInstagramService;
import com.enlace.api.service.UsuarioService;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ContatoInstagramService contatoInstagramService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/criarcontato/{idDoUsuario}")
    public ResponseEntity<?> criarContato(@PathVariable Long idDoUsuario, @RequestBody ContatoInstagramDto contatoInstagramDto){

        ContatoInstagram contatoInstagram = modelMapper.map(contatoInstagramDto, ContatoInstagram.class);

        try{
            List<Contato> listaDeContatosDoUsuario = usuarioService.criarContatoInstagram(idDoUsuario, contatoInstagram);
            return ResponseEntity.ok().body(listaDeContatosDoUsuario);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/listarcontatos/{idDoUsuario}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> listarContatos(@PathVariable Long idDoUsuario){

        try{
            List<Contato> listaDeContatosDoUsuario = usuarioService.listarContatos(idDoUsuario);
            return ResponseEntity.ok().body(listaDeContatosDoUsuario);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/buscarcontato/{idDoUsuario}/{idDoContato}")
    public ResponseEntity<?> buscarContato(@PathVariable Long idDoUsuario, @PathVariable Long idDoContato) {

        try{
            List<Contato> listaDeContatos = usuarioService.listarContatos(idDoUsuario);
            ContatoInstagramDto contatoInstagramDto = null;


            for(Contato contato : listaDeContatos){
                if(contato.getId() == idDoContato){
                    contatoInstagramDto = modelMapper.map(contato, ContatoInstagramDto.class);
                }
            }

            if(contatoInstagramDto == null){
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(contatoInstagramDto);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/editarcontato/{idDoUsuario}/{idDoContato}")
    public ResponseEntity<?> editarContato(@PathVariable Long idDoUsuario, @PathVariable Long idDoContato, @RequestBody ContatoInstagramDto contatoInstagramDto) {
        
        ContatoInstagram contatoInstagram = modelMapper.map(contatoInstagramDto, ContatoInstagram.class);

        try{
            ContatoInstagram contatoAlterado = contatoInstagramService.alterarContatoInstagram(contatoInstagram);
            return ResponseEntity.ok().body(contatoAlterado);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deletarcontato/{idDoUsuario}/{idDoContato}")
    public ResponseEntity<?> deletarContato(@PathVariable Long idDoUsuario, @PathVariable Long idDoContato) {

        try{
            contatoInstagramService.deletarContatoInstagramPorId(idDoContato);
            return ResponseEntity.noContent().build();
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
