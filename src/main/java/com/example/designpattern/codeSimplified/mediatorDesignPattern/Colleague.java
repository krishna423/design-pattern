package com.example.designpattern.codeSimplified.mediatorDesignPattern;

public abstract class Colleague {

    private int id;
    private String name;

    public Colleague(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void addBid(int bidAmount);
    abstract void receiveNotification(int bitAmount);

}
