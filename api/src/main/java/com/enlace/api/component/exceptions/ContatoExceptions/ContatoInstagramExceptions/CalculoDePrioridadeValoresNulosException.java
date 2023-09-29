package com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions;

public class CalculoDePrioridadeValoresNulosException extends RuntimeException{
    
    public CalculoDePrioridadeValoresNulosException() {
        super("Impossivel calcular prioridade, valores nulos");
    }
}
