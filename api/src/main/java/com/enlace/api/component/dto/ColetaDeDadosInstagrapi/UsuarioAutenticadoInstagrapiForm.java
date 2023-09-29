package com.enlace.api.component.dto.ColetaDeDadosInstagrapi;

import org.springframework.stereotype.Component;

@Component
public class UsuarioAutenticadoInstagrapiForm {
    
    private String sessionID;
    private String userID;

    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

}
