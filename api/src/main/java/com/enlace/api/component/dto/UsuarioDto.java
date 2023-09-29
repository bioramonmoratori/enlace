package com.enlace.api.component.dto;

import org.springframework.stereotype.Component;

import com.enlace.api.component.enums.Pronome;

@Component
public class UsuarioDto {
        
    private String id;  
    private String nome;
    private String email;
    private String senha;
    private Pronome pronome;
    private String cidade;

    
    /*
    * 
    * 
    */
    

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
