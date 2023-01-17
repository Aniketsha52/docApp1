package com.example.docapp.exceptions;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(){
        super();
    }
    public DoctorNotFoundException(String msg){
        super(msg);
    }
}
