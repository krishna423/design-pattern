package com.example.designpattern.codeSimplified.flyweightPattern;


public class WorkingPlayerProperty {
    private int id;
    private WeaponType weapon;
    private int x;
    private int y;


    public WorkingPlayerProperty(int id, WeaponType weapon, int x, int y) {
        this.id = id;
        this.weapon = weapon;
        this.x = x;
        this.y = y;
    }

    public WeaponType getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
