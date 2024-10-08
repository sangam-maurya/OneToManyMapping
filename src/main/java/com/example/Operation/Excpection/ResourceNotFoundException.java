package com.example.Operation.Excpection;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
