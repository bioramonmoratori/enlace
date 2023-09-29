package com.enlace.api.component.auth;

import com.enlace.api.component.enums.Pronome;
import com.enlace.api.model.UsuarioRoles;

public class RegistroDto {
    
    private String email;
    private String senha;
    private UsuarioRoles role;
	private String nome;
	private Pronome pronome;
	private String cidade;
    
    
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
    public UsuarioRoles getRole() {
        return role;
    }
    public void setRole(UsuarioRoles role) {
        this.role = role;
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
