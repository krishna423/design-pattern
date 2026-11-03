package com.example.designpattern.logics.ExceptionHandling;

public class FileRelatedException extends  RuntimeException{
    int errorCode ;
    public FileRelatedException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

