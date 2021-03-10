package com.example.designpattern.codeSimplified.DecoratorPattern;

public class ExtraCronDecorator extends PizzaDecorator{

    public ExtraCronDecorator(Pizza pizza) {
        super(pizza,5);
    }

}
