package com.enlace.api.component.dto.ColetaDeDadosInstagram;

import org.springframework.stereotype.Component;

@Component
public class ContatoForm {
    
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
