package com.example.designpattern.codeSimplified.bridgePattern;

public abstract class TV {

    private Remote remote;

    public TV(Remote remote) {
        this.remote = remote;
    }

    protected Remote getRemote() {
        return remote;
    }

    abstract void onTV();
    abstract void offTV();

}
