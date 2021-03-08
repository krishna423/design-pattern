package com.example.designpattern.codeSimplified.DecoratorPattern;

public abstract class Pizza {
    private int size;
    private int price;

    public Pizza(int price,int size) {
        this.price = price;
        this.size = size;

    }

    public abstract Pizza assemble();

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", price=" + price +
                '}';
    }
}
