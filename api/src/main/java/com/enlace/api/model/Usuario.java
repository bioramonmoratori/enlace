package com.enlace.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

import com.enlace.api.component.enums.Pronome;
import com.enlace.api.model.contato.Contato;
import com.enlace.api.model.contato.Interesse;

@Entity
public class Usuario implements UserDetails{
	
	//Faltam atributos Email e Senha para autenticacao
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@NotNull
	private String nome;

	@NotNull
	private String email;
	
	@NotNull
	private String senha;

	@NotNull
	private UsuarioRoles role;

	@NotNull
	private Pronome pronome;
	
	@NotNull
	private String cidade;
	
	@ManyToMany(fetch = FetchType.LAZY)
    private List<Interesse> listaDeInteressesDoUsuario = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Contato> listaGeralDeContatos = new ArrayList<>();
	
	@OneToOne
	private MeuInstagram meuInstagram;

	
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

	public List<Interesse> getListaDeInteressesDoUsuario() {
		return listaDeInteressesDoUsuario;
	}

	public void setListaDeInteressesDoUsuario(List<Interesse> listaDeInteressesDoUsuario) {
		this.listaDeInteressesDoUsuario = listaDeInteressesDoUsuario;
	}

	public List<Contato> getListaGeralDeContatos() {
		return listaGeralDeContatos;
	}

	public void setListaGeralDeContatos(List<Contato> listaGeralDeContatos) {
		this.listaGeralDeContatos = listaGeralDeContatos;
	}

	public MeuInstagram getMeuInstagram() {
		return meuInstagram;
	}

	public void setMeuInstagram(MeuInstagram meuInstagram) {
		this.meuInstagram = meuInstagram;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha(){
		return senha;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}
	public UsuarioRoles getRole() {
		return role;
	}

	public void setRole(UsuarioRoles role) {
		this.role = role;
	}


	// Spring Security
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UsuarioRoles.ROLE_ADMIN){

			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), 
				new SimpleGrantedAuthority("ROLE_USER"));

		} else {
			
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}

	@Override
	public String getPassword() {
		
		return this.senha;
	}

	@Override
	public String getUsername() {
		
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
