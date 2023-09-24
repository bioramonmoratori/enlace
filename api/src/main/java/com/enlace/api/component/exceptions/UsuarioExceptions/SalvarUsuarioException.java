package com.enlace.api.component.exceptions.UsuarioExceptions;

public class SalvarUsuarioException extends Exception{
    
    public SalvarUsuarioException(){
        super("Impossivel salvar o usuario no banco de dados");
    }

}
