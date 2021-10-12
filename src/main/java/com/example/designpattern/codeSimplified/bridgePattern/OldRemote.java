package com.example.designpattern.codeSimplified.bridgePattern;

public class OldRemote implements Remote{

    @Override
    public void on() {
        System.out.println("TV on via OLD Remote");
    }

    @Override
    public void off() {
        System.out.println("TV off via OLD Remote");
    }
}
