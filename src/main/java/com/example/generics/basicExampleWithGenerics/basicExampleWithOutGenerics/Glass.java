package com.example.generics.basicExampleWithGenerics.basicExampleWithOutGenerics;

public class Glass {
    private Liquid liquid;

    public Glass(Liquid liquid) {
        this.liquid = liquid;
        System.out.println("Glass");
    }

    public Liquid getLiquid() {
        System.out.println("Get glass");
        return liquid;
    }
}
