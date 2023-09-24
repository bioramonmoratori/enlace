package com.enlace.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlace.api.component.dto.UsuarioDto;
import com.enlace.api.component.exceptions.UsuarioExceptions.SalvarUsuarioException;
import com.enlace.api.model.Usuario;
import com.enlace.api.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    ModelMapper modelMapper = new ModelMapper();

    /*
     * Preciso passar o nome, pronome e cidade do usuário
     */
    @PostMapping("/cadastrarusuario")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) throws SalvarUsuarioException {

        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);

        try{
            usuario = usuarioService.criarUsuario(usuario);
            usuarioDto.setId(usuario.getId());
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().body(usuarioDto);
    }

    @GetMapping("/buscarusuario/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id){

        try{
            Usuario usuario = usuarioService.buscarUsuarioPorId(id);
            if(usuario == null){
                return ResponseEntity.notFound().build();
            } else {
                UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
                return ResponseEntity.ok().body(usuarioDto);
            }
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/deletarusuario/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        try{
            usuarioService.deletarUsuarioPorId(id);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editarusuario/{idDoUsuario}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long idDoUsuario, @RequestBody UsuarioDto usuarioDto){
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);

        try{

            usuario = usuarioService.atualizarUsuario(usuario);
            usuarioDto.setId(usuario.getId());
            return ResponseEntity.ok().body(usuarioDto);

        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
