package com.example.docapp.exceptions;

public class MatchCityNotFoundException extends RuntimeException{
    public MatchCityNotFoundException(){
        super();
    }
    public MatchCityNotFoundException(String msg){
        super(msg);
    }
}
