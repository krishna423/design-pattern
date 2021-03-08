package com.example.designpattern.codeSimplified.DecoratorPattern;

public class PizzaDecorator extends Pizza {

    private Pizza pizza;
    private int additionalPrice;

    public PizzaDecorator(Pizza pizza,int additionalPrice) {
        super(pizza.getPrice(), pizza.getSize());
        this.pizza = pizza;
        this.additionalPrice = additionalPrice;
    }

    @Override
    public Pizza assemble() {
        this.pizza.setPrice(pizza.getPrice() + pizza.getSize()* additionalPrice);
        return pizza;
    }
}
