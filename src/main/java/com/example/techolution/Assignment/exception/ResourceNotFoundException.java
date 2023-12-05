package com.example.techolution.Assignment.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("User Not Found!!");
    }
}
