package com.example.generics.basicExampleWithGenerics.basicExampleWithOutGenerics;

import com.example.generics.basicExampleWithOutGenerics.Glass;
import com.example.generics.basicExampleWithOutGenerics.Water;

public class basicExample {

    public static void main(String[] args) {
        com.example.generics.basicExampleWithOutGenerics.Water water = new com.example.generics.basicExampleWithOutGenerics.Water();
        com.example.generics.basicExampleWithOutGenerics.Glass glass = new Glass(water);


        com.example.generics.basicExampleWithOutGenerics.Water water1= (Water) glass.getLiquid();
        System.out.println("Result : " + water1);
    }
}
