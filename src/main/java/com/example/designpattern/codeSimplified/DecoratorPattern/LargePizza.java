package com.example.designpattern.codeSimplified.DecoratorPattern;

public class LargePizza extends Pizza{


    public LargePizza() {
        super(500,11);
    }

    @Override
    public Pizza assemble() {
        return this;
    }

}
