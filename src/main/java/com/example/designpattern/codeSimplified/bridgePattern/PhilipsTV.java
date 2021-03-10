package com.example.designpattern.codeSimplified.bridgePattern;

public class PhilipsTV extends TV{

    public PhilipsTV(Remote remote) {
        super(remote);
    }

    @Override
    void onTV() {
        System.out.println("PhilipsTV on command processing");
        this.getRemote().on();
    }

    @Override
    void offTV() {
        System.out.println("PhilipsTV off command processing");
        this.getRemote().off();
    }
}
