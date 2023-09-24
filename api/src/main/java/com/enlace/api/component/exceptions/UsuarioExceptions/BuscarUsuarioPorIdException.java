package com.enlace.api.component.exceptions.UsuarioExceptions;

public class BuscarUsuarioPorIdException extends Exception{
    
    public BuscarUsuarioPorIdException(){
        super("Impossivel buscar o usuario por ID no banco de dados");
    }

}
