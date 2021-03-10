package com.example.designpattern.codeSimplified.flyweightPattern;

public class CounterTerrorist implements Player{

    // Intrinsic Attribute
    private final String TASK;

    // Extrinsic Attribute
    private String weapon;

    public CounterTerrorist() {
        this.TASK = "DIFFUSE BOMB";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        //Work on the Mission
        System.out.println("Counter Terrorist with weapon "+ weapon + "|" + " Task is " + TASK);

    }
}
