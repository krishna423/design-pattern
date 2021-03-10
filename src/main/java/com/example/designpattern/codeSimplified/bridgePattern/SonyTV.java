package com.example.designpattern.codeSimplified.bridgePattern;

public class SonyTV  extends TV{

    public SonyTV(Remote remote) {
        super(remote);
    }

    @Override
    void onTV() {
        System.out.println("Sony TV on command processing");
        this.getRemote().on();
    }

    @Override
    void offTV() {
        System.out.println("Sony TV off command processing");
        this.getRemote().off();
    }
}
