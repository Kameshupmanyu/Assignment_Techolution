package com.example.techolution.Assignment.exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(){
        super("User Already Exist!!");
    }
}
