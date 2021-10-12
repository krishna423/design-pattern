package com.example.generics.basicExampleWithOutGenerics;

public class Glass<T> {
    private T liquid;

    public Glass(T liquid) {
        this.liquid = liquid;
        System.out.println("Glass");
    }

    public T getLiquid() {
        System.out.println("Get glass");
        return liquid;
    }
}
