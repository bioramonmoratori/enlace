package com.enlace.insta.apiinsta.components.Forms;

import org.springframework.stereotype.Component;

@Component
public class UsuarioForm {
    
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
