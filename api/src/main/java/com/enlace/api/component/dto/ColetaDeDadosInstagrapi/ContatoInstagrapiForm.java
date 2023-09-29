package com.enlace.api.component.dto.ColetaDeDadosInstagrapi;

import org.springframework.stereotype.Component;

@Component
public class ContatoInstagrapiForm {
    
    private String usuario;
    private String fotoDePerfilURL;

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getFotoDePerfilURL() {
        return fotoDePerfilURL;
    }
    public void setFotoDePerfilURL(String fotoDePerfilURL) {
        this.fotoDePerfilURL = fotoDePerfilURL;
    }

}
