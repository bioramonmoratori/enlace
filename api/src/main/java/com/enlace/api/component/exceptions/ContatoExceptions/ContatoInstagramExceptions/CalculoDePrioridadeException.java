package com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions;

public class CalculoDePrioridadeException extends RuntimeException{
    
    public CalculoDePrioridadeException() {
        super("Impossivel calcular prioridade. Erro inesperado");
    }
}
