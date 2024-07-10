package com.glo.app.exception;

public class InvalidSimServiceNumber extends  RuntimeException{
    public InvalidSimServiceNumber(String message){
        super(message);
    }
}
