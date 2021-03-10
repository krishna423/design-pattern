package com.example.designpattern.codeSimplified.bridgePattern;

public class NewRemote implements Remote{

    @Override
    public void on() {
        System.out.println("TV on via New Remote");
    }

    @Override
    public void off() {
        System.out.println("TV off via New Remote");
    }
}
