package com.example.designpattern.codeSimplified.DecoratorPattern;

public class SmallPizza extends Pizza{


    public SmallPizza() {
        super(100,7);
    }

    @Override
    public Pizza assemble() {
       return this;
    }

}
