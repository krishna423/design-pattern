package com.example.generics.basicExampleWithOutGenerics;

public class basicExample {

    public static void main(String[] args) {
        Water water = new Water();
        Glass<Water> glass = new Glass<Water>(water);
        Water water1= glass.getLiquid();
        System.out.println("Result : " + water1);

        Juice juice = new Juice();
        Glass<Juice> glassJ = new Glass<Juice>(juice);
        Juice juice1 = glassJ.getLiquid();
        System.out.println("Result : " + juice1);


    }
}
