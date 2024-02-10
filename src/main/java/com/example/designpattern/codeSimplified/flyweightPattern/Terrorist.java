package com.example.designpattern.codeSimplified.flyweightPattern;

public class Terrorist implements Player{

    // Intrinsic Attribute
    private final String TASK;
    private final String colour;
    private final Robot robot;
    // Extrinsic Attribute
    private String weapon;

    public Terrorist() {
        this.TASK = "PLANT A BOMB";
        this.robot = new Robot();
        this.colour = "Black";
    }


    @Override
    public void runningPlayer(WorkingPlayerProperty workingPlayerProperty) {
        System.out.println("Position of Terrorist " +  workingPlayerProperty.getId() + "  is : x : " + workingPlayerProperty.getX() +", y : "+ workingPlayerProperty.getY() + " " +
                " Mission is : " + TASK +  " and weapon is : " + workingPlayerProperty.getWeapon() + " Colour is : " + colour);

    }
}
