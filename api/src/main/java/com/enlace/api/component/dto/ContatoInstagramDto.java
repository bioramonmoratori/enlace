package com.enlace.api.component.dto;

public class ContatoInstagramDto {
    
    private Long id;
    private String nomeDoContato;
    private String fotoDoPerfilURL;
    private Integer numeroDeContasQueOContatoSegue;
	private Integer numeroDeSeguidoresDoContato;
	private Boolean contatoSegueOUsuario;
	private Integer numeroDePostsDoUsuarioQueEsseContatoCurtiu;
	private Integer numeroDePostsDoUsuarioQueEsseContatoComentou;

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
    public String getNomeDoContato() {
        return nomeDoContato;
    }
    public void setNomeDoContato(String nomeDoContato) {
        this.nomeDoContato = nomeDoContato;
    }
    public String getFotoDoPerfilURL() {
        return fotoDoPerfilURL;
    }
    public void setFotoDoPerfilURL(String fotoDoPerfilURL) {
        this.fotoDoPerfilURL = fotoDoPerfilURL;
    }
    public Integer getNumeroDeContasQueOContatoSegue() {
        return numeroDeContasQueOContatoSegue;
    }
    public void setNumeroDeContasQueOContatoSegue(Integer numeroDeContasQueOContatoSegue) {
        this.numeroDeContasQueOContatoSegue = numeroDeContasQueOContatoSegue;
    }
    public Integer getNumeroDeSeguidoresDoContato() {
        return numeroDeSeguidoresDoContato;
    }
    public void setNumeroDeSeguidoresDoContato(Integer numeroDeSeguidoresDoContato) {
        this.numeroDeSeguidoresDoContato = numeroDeSeguidoresDoContato;
    }
    public Boolean getContatoSegueOUsuario() {
        return contatoSegueOUsuario;
    }
    public void setContatoSegueOUsuario(Boolean contatoSegueOUsuario) {
        this.contatoSegueOUsuario = contatoSegueOUsuario;
    }
    public Integer getNumeroDePostsDoUsuarioQueEsseContatoCurtiu() {
        return numeroDePostsDoUsuarioQueEsseContatoCurtiu;
    }
    public void setNumeroDePostsDoUsuarioQueEsseContatoCurtiu(Integer numeroDePostsDoUsuarioQueEsseContatoCurtiu) {
        this.numeroDePostsDoUsuarioQueEsseContatoCurtiu = numeroDePostsDoUsuarioQueEsseContatoCurtiu;
    }
    public Integer getNumeroDePostsDoUsuarioQueEsseContatoComentou() {
        return numeroDePostsDoUsuarioQueEsseContatoComentou;
    }
    public void setNumeroDePostsDoUsuarioQueEsseContatoComentou(Integer numeroDePostsDoUsuarioQueEsseContatoComentou) {
        this.numeroDePostsDoUsuarioQueEsseContatoComentou = numeroDePostsDoUsuarioQueEsseContatoComentou;
    }

}
