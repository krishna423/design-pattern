package com.example.designpattern.codeSimplified.flyweightPattern;

public class CounterTerrorist implements Player{

    // Intrinsic Attribute
    private final String TASK;
    private final Robot robot;
    private final String colour;

    // Extrinsic Attribute : weapon, position(x,y)

    public CounterTerrorist() {
        this.TASK = "DIFFUSE BOMB";
        this.robot = new Robot();
        this.colour = "Yellow";
    }

    @Override
    public void runningPlayer(WorkingPlayerProperty workingPlayerProperty) {
        System.out.println("Position of Counter Terrorist " +  workingPlayerProperty.getId() + "  is : x : " + workingPlayerProperty.getX() +", y : "+ workingPlayerProperty.getY() + " " +
                " Mission is : " + TASK +  " and weapon is : " + workingPlayerProperty.getWeapon()  + " Colour is : " + colour);

    }
}
