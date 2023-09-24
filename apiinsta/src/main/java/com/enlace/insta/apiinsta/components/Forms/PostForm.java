package com.enlace.insta.apiinsta.components.Forms;

import org.springframework.stereotype.Component;

@Component
public class PostForm {
    
    private String sessionID;
    private String mediaID;

    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    public String getMediaID() {
        return mediaID;
    }
    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

}
