package com.example.springfirst.infra.err;

public class FilterNotFoundException extends RuntimeException{
public FilterNotFoundException(){super("Filtro não encontrado ");}
    public FilterNotFoundException(String message){super(message);}
}
