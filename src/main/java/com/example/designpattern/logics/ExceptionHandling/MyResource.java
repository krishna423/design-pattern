package com.example.designpattern.logics.ExceptionHandling;

public class MyResource implements AutoCloseable {

    private String filePath ;

    public MyResource(String filePath) {
        this.filePath = filePath;
    }

    //@Override
    public void close() throws Exception {
        System.out.println("Releasing resource...");
    }
}
