package com.enlace.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/teste")
    public ResponseEntity<?> teste(){
        return ResponseEntity.ok().body("Autenticacao bem sucedida!");
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

}
