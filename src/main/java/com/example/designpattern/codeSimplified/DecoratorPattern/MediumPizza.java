package com.example.designpattern.codeSimplified.DecoratorPattern;

public class MediumPizza extends Pizza{

    public MediumPizza() {
        super(300,9);
    }

    @Override
    public Pizza assemble() {
        return this;
    }

}
