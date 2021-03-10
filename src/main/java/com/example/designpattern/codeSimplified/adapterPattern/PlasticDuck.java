package com.example.designpattern.codeSimplified.adapterPattern;

public class PlasticDuck implements ToyDuck{

    @Override
    public void squeak() {
        System.out.println("Squeak");
    }
}
