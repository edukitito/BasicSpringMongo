package com.springwithmongo.basicspringmongo.Services.Exception;

public class NotFound extends RuntimeException{
    public NotFound(Object id){
        super("Id Not Found: " + id);
    }
}
