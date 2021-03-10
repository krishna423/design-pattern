package com.example.designpattern.codeSimplified.flyweightPattern;

public class Terrorist implements Player{

    // Intrinsic Attribute
    private final String TASK;

    // Extrinsic Attribute
    private String weapon;

    public Terrorist() {
        this.TASK = "PLANT A BOMB";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        //Work on the Mission
        System.out.println("Terrorist with weapon "+ weapon + "|" + " Task is " + TASK);

    }
}
