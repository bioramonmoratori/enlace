package com.enlace.api.component.dto;

import org.springframework.stereotype.Component;

import com.enlace.api.component.enums.Pronome;

@Component
public class UsuarioDto {
        
    private Long id;  
    private String nome;
    private Pronome pronome;
    private String cidade;
    
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
}
