package com.enlace.api.model;

public enum UsuarioRoles {
    
    ROLE_USER ("user"),
    ROLE_ADMIN("admin");

    private String role;

    UsuarioRoles(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

}
