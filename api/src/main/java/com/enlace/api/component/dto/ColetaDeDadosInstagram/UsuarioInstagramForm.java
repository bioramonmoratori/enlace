package com.enlace.api.component.dto.ColetaDeDadosInstagram;

import org.springframework.stereotype.Component;

@Component
public class UsuarioInstagramForm {
    
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
